package com.flights.domain.rule.passengertype;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.flights.domain.model.Price;

public class ChildRuleTest
{
  private static final Price TOTAL_PRICE_EXPECTED = new Price(16.75);
  private static final int CHILDREN_NUMBER = 5;
  private static final Price BASE_PRICE = new Price(5.0);
  private ChildRule childRule = new ChildRule();

  @Test
  public void calculatePriceChildren()
  {
    Price totalPrice = childRule.calculatePrice(BASE_PRICE, CHILDREN_NUMBER);

    assertThat("The price is equals", totalPrice, equalTo(TOTAL_PRICE_EXPECTED));
  }
}
