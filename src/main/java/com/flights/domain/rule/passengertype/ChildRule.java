package com.flights.domain.rule.passengertype;

import com.flights.domain.model.Price;

public class ChildRule extends PassengerTypeRule
{
  private static final Double DISCOUNT = 0.33;

  public Price calculatePrice(Price basePrice, Integer childrenNumber)
  {
    Price base = calculateDefault(basePrice, childrenNumber);

    return calculatePriceWithDisocunt(base);
  }

  private Price calculatePriceWithDisocunt(Price base)
  {
    return new Price(base.getValue() * (1 - DISCOUNT));
  }
}
