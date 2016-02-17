package com.flights.domain.rule.passengertype;

import com.flights.domain.model.Price;

public class InfantRule extends PassengerTypeRule
{
  public Price calculatePrice(Price basePrice, Integer infantsNumber)
  {
    return calculateDefault(basePrice, infantsNumber);
  }
}
