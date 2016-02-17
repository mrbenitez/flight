package com.flights.domain.rule.passengertype;

import com.flights.domain.model.Price;

public abstract class PassengerTypeRule
{
  public abstract Price calculatePrice(Price basePrice, Integer passengersNumber);

  protected Price calculateDefault(Price basePrice, Integer passengerNumber)
  {
    return new Price(basePrice.getValue() * passengerNumber);
  }
}
