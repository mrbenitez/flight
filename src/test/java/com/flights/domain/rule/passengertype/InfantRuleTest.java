package com.flights.domain.rule.passengertype;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class InfantRuleTest
{
  private static final double TOTAL_PRICE_EXPECTED = 10.0;
  private static final int INFANTS_NUMBER = 2;
  private static final double BASE_PRICE = 5.0;
  private InfantRule infantRule = new InfantRule();

  @Test
  public void calculatePriceInfants()
  {
    Double totalPrice = infantRule.calculatePrice(BASE_PRICE, INFANTS_NUMBER);

    assertThat("The price is equals", totalPrice, equalTo(TOTAL_PRICE_EXPECTED));
  }
}
