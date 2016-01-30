package com.flights.domain.rule.passengertype;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AdultRuleTest
{
  private static final double TOTAL_PRICE_EXPECTED = 3002.5;
  private static final int ADULTS_NUMBER = 5;
  private static final double BASE_PRICE = 600.5;
  private AdultRule adultRule = new AdultRule();

  @Test
  public void calculatePriceAdults()
  {
    Double totalPrice = adultRule.calculatePrice(BASE_PRICE, ADULTS_NUMBER);

    assertThat("The price is equals", totalPrice, equalTo(TOTAL_PRICE_EXPECTED));
  }
}
