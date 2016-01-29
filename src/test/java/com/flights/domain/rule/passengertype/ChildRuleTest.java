package com.flights.domain.rule.passengertype;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ChildRuleTest
{
  private ChildRule childRule = new ChildRule();

  @Test
  public void calculatePriceChildren()
  {
    Double totalPrice = childRule.calculatePrice(5.0, 5);

    assertThat("The price is equals", totalPrice, equalTo(16.75));
  }
}
