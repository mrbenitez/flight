package com.flights.domain;

import java.util.Map;

import com.flights.domain.model.Flight;
import com.flights.domain.model.PassengerType;
import com.flights.domain.model.Passengers;
import com.flights.domain.model.SearchCriteria;
import com.flights.domain.rule.destinationdate.DestinationDateRule;
import com.flights.domain.rule.passengertype.PassengerTypeRule;
import com.flights.domain.rule.passengertype.PassengerTypeRuleFactory;

public class CalculateTotalPriceFlight
{
  private PassengerTypeRuleFactory passengerTypeRuleFactory;
  private DestinationDateRule destinationDateRule;

  public CalculateTotalPriceFlight(PassengerTypeRuleFactory passengerTypeRuleFactory,
      DestinationDateRule destinationDateRule)
  {
    this.passengerTypeRuleFactory = passengerTypeRuleFactory;
    this.destinationDateRule = destinationDateRule;
  }

  public Double calculate(SearchCriteria criteria, Flight flight)
  {
    Double departureDatePrice = destinationDateRule.calculatePrice(criteria.getDepartureDate(),
                                                                   flight.getBasePrice());

    return calculateTotalPriceByAllPassenger(criteria.getPassenger(),
                                             flight,
                                             departureDatePrice);
  }

  private Double calculateTotalPriceByAllPassenger(Passengers passenger,
                                                   Flight flight,
                                                   Double departureDatePrice)
  {
    Double totalPrice = 0.0;
    for (PassengerType passangerType : passenger.get().keySet())
    {
      int numPassenger = obtainNumberPassenger(passenger.get(), passangerType);
      Double basePrice = calculateBasePrice(flight, departureDatePrice, passangerType);
      PassengerTypeRule passengerTypeRule = obtainPassengerTypeRule(passangerType);
      totalPrice += passengerTypeRule.calculatePrice(basePrice, numPassenger);
    }
    return totalPrice;
  }

  private Integer obtainNumberPassenger(Map<PassengerType, Integer> passenger, PassengerType passangerType)
  {
    return passenger.get(passangerType);
  }

  private Double calculateBasePrice(Flight flight, Double departureDatePrice, PassengerType passangerType)
  {
    Double basePrice = departureDatePrice;
    basePrice = basePriceWhenIsInfant(flight, passangerType, basePrice);
    return basePrice;
  }

  private Double basePriceWhenIsInfant(Flight flight, PassengerType passangerType, Double basePrice)
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
