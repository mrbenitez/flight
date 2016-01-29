package com.flights.domain.rule.passengertype;

public interface PassengerTypeRule
{
  Double calculatePrice(Double basePrice, Integer passengersNumber);

  default Double calculatePriceBaseByAllPassengers(Double basePrice, Integer passengerNumber)
  {
    return basePrice * passengerNumber;
  }
}
