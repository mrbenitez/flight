package com.flights.domain.rule.passengertype;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ChildRuleTest
{
  private static final double TOTAL_PRICE_EXPECTED = 16.75;
  private static final int CHILDREN_NUMBER = 5;
  private static final double BASE_PRICE = 5.0;
  private ChildRule childRule = new ChildRule();

  @Test
  public void calculatePriceChildren()
  {
    Double totalPrice = childRule.calculatePrice(BASE_PRICE, CHILDREN_NUMBER);

    assertThat("The price is equals", totalPrice, equalTo(TOTAL_PRICE_EXPECTED));
  }
}
