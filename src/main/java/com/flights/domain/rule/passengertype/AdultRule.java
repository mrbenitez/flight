package com.flights.domain.rule.passengertype;

public class AdultRule extends PassengerTypeRule
{
  public Double calculatePrice(Double basePrice, Integer adultsNumber)
  {
    return calculateDefault(basePrice, adultsNumber);
  }
}
