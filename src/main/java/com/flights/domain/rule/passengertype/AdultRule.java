package com.flights.domain.rule.passengertype;

import com.flights.domain.model.Price;

public class AdultRule extends PassengerTypeRule
{
  public Price calculatePrice(Price basePrice, Integer adultsNumber)
  {
    return calculateDefault(basePrice, adultsNumber);
  }
}
