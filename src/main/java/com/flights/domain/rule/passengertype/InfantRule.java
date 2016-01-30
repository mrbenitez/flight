package com.flights.domain.rule.passengertype;

public class InfantRule implements PassengerTypeRule
{
  public Double calculatePrice(Double basePrice, Integer infantsNumber)
  {
    return calculatePriceAllPassengers(basePrice, infantsNumber);
  }
}
