package com.flights.domain.rule.passengertype;

public abstract class PassengerTypeRule
{
  public abstract Double calculatePrice(Double basePrice, Integer passengersNumber);

  protected Double calculateDefault(Double basePrice, Integer passengerNumber)
  {
    return basePrice * passengerNumber;
  }
}
