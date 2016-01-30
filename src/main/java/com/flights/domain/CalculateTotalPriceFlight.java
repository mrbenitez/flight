package com.flights.domain;

import java.util.Map;

import com.flights.domain.model.Flight;
import com.flights.domain.model.PassangerType;
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

  private Double calculateTotalPriceByAllPassenger(Map<PassangerType, Integer> passenger,
                                                   Flight flight,
                                                   Double departureDatePrice)
  {
    Double totalPrice = 0.0;
    for (PassangerType passangerType : passenger.keySet())
    {
      PassengerTypeRule passengerTypeRule = obtainPassengerTypeRule(passangerType);
      int numPassenger = obtainNumberPassenger(passenger, passangerType);
      Double basePrice = calculateBasePrice(flight, departureDatePrice, passangerType);
      totalPrice += passengerTypeRule.calculatePrice(basePrice, numPassenger);
    }
    return totalPrice;
  }

  private PassengerTypeRule obtainPassengerTypeRule(PassangerType passangerType)
  {
    return passengerTypeRuleFactory.get(passangerType);
  }

  private Integer obtainNumberPassenger(Map<PassangerType, Integer> passenger, PassangerType passangerType)
  {
    return passenger.get(passangerType);
  }

  private Double calculateBasePrice(Flight flight, Double departureDatePrice, PassangerType passangerType)
  {
    Double basePrice = departureDatePrice;
    basePrice = basePriceWhenIsInfant(flight, passangerType, basePrice);
    return basePrice;
  }

  private Double basePriceWhenIsInfant(Flight flight, PassangerType passangerType, Double basePrice)
  {
    if (PassangerType.INFANT.equals(passangerType))
    {
      basePrice = flight.getInfantPrice();
    }
    return basePrice;
  }
}
