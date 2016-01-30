package com.flights.domain.rule.passengertype;

public class AdultRule implements PassengerTypeRule
{
  public Double calculatePrice(Double basePrice, Integer adultsNumber)
  {
    return calculatePriceAllPassengers(basePrice, adultsNumber);
  }
}
