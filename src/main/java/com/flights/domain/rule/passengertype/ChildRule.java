package com.flights.domain.rule.passengertype;

import java.math.BigDecimal;

public class ChildRule implements PassengerTypeRule
{
  private static final Double DISCOUNT = 0.2;

  public BigDecimal calculatePrice(BigDecimal basePrice, Integer numberPassenger)
  {
    return basePrice.multiply(new BigDecimal(numberPassenger)).multiply(new BigDecimal(DISCOUNT));
  }
}
