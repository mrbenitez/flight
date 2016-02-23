package com.flights.domain.rule.passengertype;

import com.flights.domain.model.Price;

// REV naming
/*
Class name prefixed with the package name.
*/
// REV Java 8
/*
The hierarchy PassengerTypeRule-*Rule could be reduced to two classes with Java 8 default methods:

@FunctionalInterface
public interface PassengerTypeRule {
    Price calculatePrice(Price basePrice, Integer passengersNumber);

    default Price calculateDefault(Price basePrice, Integer passengerNumber) {
        return new Price(basePrice.getValue() * passengerNumber);
    }

    static PassengerTypeRule defaultRule()
        return new PassengerTypeRule() {
            @Override
            public Price calculatePrice(Price basePrice, Integer passengersNumber) {
                return calculateDefault(basePrice, passengersNumber);
            }
        };
    }
}
*/
public abstract class PassengerTypeRule
{
  public abstract Price calculatePrice(Price basePrice, Integer passengersNumber);

  protected Price calculateDefault(Price basePrice, Integer passengerNumber)
  {
    return new Price(basePrice.getValue() * passengerNumber);
  }
}
