package com.flights.domain.rule.passengertype;

class ChildRule implements PassengerTypeRule
{
  private static final Double DISCOUNT = 0.33;

  public Double calculatePrice(Double basePrice, Integer childrenNumber)
  {
    Double base = calculatePriceAllPassengers(basePrice, childrenNumber);

    return calculatePriceWithDisocunt(base);
  }

  private Double calculatePriceWithDisocunt(Double base)
  {
    return base * (1 - DISCOUNT);
  }
}
