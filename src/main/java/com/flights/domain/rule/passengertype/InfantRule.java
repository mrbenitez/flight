package com.flights.domain.rule.passengertype;

import java.math.BigDecimal;

public class InfantRule implements PassengerTypeRule
{
  public BigDecimal calculatePrice(BigDecimal basePrice, Integer numberPassenger)
  {
    return basePrice.multiply(new BigDecimal(numberPassenger));
  }
}
