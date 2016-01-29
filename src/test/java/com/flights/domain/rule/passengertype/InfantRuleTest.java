package com.flights.domain.rule.passengertype;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class InfantRuleTest
{
  private InfantRule infantRule = new InfantRule();

  @Test
  public void calculatePriceInfants()
  {
    Double totalPrice = infantRule.calculatePrice(5.0, 5);

    assertThat("The price is equals", totalPrice, equalTo(25.0));
  }
}
