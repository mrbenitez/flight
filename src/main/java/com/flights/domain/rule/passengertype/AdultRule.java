package com.flights.domain.rule.passengertype;

class AdultRule implements PassengerTypeRule
{
  public Double calculatePrice(Double basePrice, Integer adultsNumber)
  {
    return basePrice * adultsNumber;
  }
}
