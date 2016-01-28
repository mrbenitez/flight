package com.flights.domain.rule.passengertype;

import java.math.BigDecimal;

public interface PassengerTypeRule
{
  BigDecimal calculatePrice(BigDecimal basePrice, Integer numberPassenger);
}
