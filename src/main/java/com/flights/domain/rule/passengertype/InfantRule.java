package com.flights.domain.rule.passengertype;

public class InfantRule extends PassengerTypeRule
{
  public Double calculatePrice(Double basePrice, Integer infantsNumber)
  {
    return calculateDefault(basePrice, infantsNumber);
  }
}
