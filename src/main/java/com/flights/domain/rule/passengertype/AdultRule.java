package com.flights.domain.rule.passengertype;

import java.math.BigDecimal;

public class AdultRule implements PassengerTypeRule
{
  public BigDecimal calculatePrice(BigDecimal basePrice, Integer numberPassenger)
  {
    return basePrice.multiply(new BigDecimal(numberPassenger));
  }
}
