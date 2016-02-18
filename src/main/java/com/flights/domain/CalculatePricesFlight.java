package com.flights.domain;

import java.util.Map;

import com.flights.domain.model.Flight;
import com.flights.domain.model.MyDate;
import com.flights.domain.model.PassengerType;
import com.flights.domain.model.Passengers;
import com.flights.domain.model.Price;
import com.flights.domain.model.SearchCriteria;
import com.flights.domain.rule.daysadvancerule.DaysAdvanceRule;
import com.flights.domain.rule.destinationdaterule.DestinationDateRule;
import com.flights.domain.rule.passengertype.PassengerTypeRule;
import com.flights.domain.rule.passengertype.PassengerTypeRuleFactory;

public class CalculatePricesFlight
{
  private PassengerTypeRuleFactory passengerTypeRuleFactory;
  private DaysAdvanceRule daysAdvanceRule;
  private DestinationDateRule destinationDateRule;

  public CalculatePricesFlight(PassengerTypeRuleFactory passengerTypeRuleFactory,
      DaysAdvanceRule daysAdvanceRule, DestinationDateRule destinationDateRule)
  {
    this.passengerTypeRuleFactory = passengerTypeRuleFactory;
    this.daysAdvanceRule = daysAdvanceRule;
    this.destinationDateRule = destinationDateRule;
  }

  public Price calculate(SearchCriteria criteria, Flight flight, MyDate today)
  {
    Price daysAdvancebasePrice = daysAdvanceRule.calculatePrice(today,
                                                                criteria.getDepartureDate(),
                                                                flight.getBasePrice());

    Price departureDatebasePrice = destinationDateRule.calculatePrice(daysAdvancebasePrice,
                                                                      criteria.getDepartureDate());

    return calculateTotalPriceByAllPassenger(criteria.getPassenger(),
                                             flight,
                                             departureDatebasePrice);
  }

  private Price calculateTotalPriceByAllPassenger(Passengers passenger,
                                                  Flight flight,
                                                  Price departureDatePrice)
  {
    Double totalPrice = 0.0;
    for (PassengerType passangerType : passenger.get().keySet())
    {
      int numPassenger = obtainNumberPassenger(passenger.get(), passangerType);
      Price basePrice = calculateBasePrice(flight, departureDatePrice, passangerType);
      PassengerTypeRule passengerTypeRule = obtainPassengerTypeRule(passangerType);
      totalPrice += passengerTypeRule.calculatePrice(basePrice, numPassenger).getValue();
    }
    return new Price(totalPrice);
  }

  private Integer obtainNumberPassenger(Map<PassengerType, Integer> passenger, PassengerType passangerType)
  {
    return passenger.get(passangerType);
  }

  private Price calculateBasePrice(Flight flight, Price departureDatePrice, PassengerType passangerType)
  {
    Price basePrice = departureDatePrice;
    basePrice = basePriceWhenIsInfant(flight, passangerType, basePrice);
    return basePrice;
  }

  private Price basePriceWhenIsInfant(Flight flight, PassengerType passangerType, Price basePrice)
  {
    if (PassengerType.INFANT.equals(passangerType))
    {
      basePrice = flight.getInfantPrice();
    }
    return basePrice;
  }

  private PassengerTypeRule obtainPassengerTypeRule(PassengerType passangerType)
  {
    return passengerTypeRuleFactory.get(passangerType);
  }
}
