package com.flights.domain;

import java.util.Map;

import com.flights.domain.model.Flight;
import com.flights.domain.model.PassengerType;
import com.flights.domain.model.Passengers;
import com.flights.domain.model.Price;
import com.flights.domain.model.SearchCriteria;
import com.flights.domain.rule.destinationdate.DestinationDateRule;
import com.flights.domain.rule.passengertype.PassengerTypeRule;
import com.flights.domain.rule.passengertype.PassengerTypeRuleFactory;

// REV Naming
// REV Typos
public class CalculatePricesFlight
{
  private PassengerTypeRuleFactory passengerTypeRuleFactory;
  private DestinationDateRule destinationDateRule;

  public CalculatePricesFlight(PassengerTypeRuleFactory passengerTypeRuleFactory,
      DestinationDateRule destinationDateRule)
  {
    this.passengerTypeRuleFactory = passengerTypeRuleFactory;
    this.destinationDateRule = destinationDateRule;
  }

  // REV Hard to follow algorithm.
  /*
   First, you calculate the price based on departure date for a generic passenger.
   Then you loop through passenger types and for each passenger type you calculate the total price for this pax group.
   The input price is the previously calculated departure date price EXCEPT for infants.
   Then you apply the rule depending on the passenger type.
   */
  public Price calculate(SearchCriteria criteria, Flight flight)
  {
    Price departureDatePrice = destinationDateRule.calculatePrice(criteria.getDepartureDate(),
                                                                  flight.getBasePrice());

    return calculateTotalPriceByAllPassenger(criteria.getPassenger(),
                                             flight,
                                             departureDatePrice);
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

  // REV Misplaced responsibility
  /*
  Flight object could be responsible for calculating the base price.
   */
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
