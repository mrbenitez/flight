package com.flights.domain.rule.passengertype;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.flights.domain.model.Price;

public class InfantRuleTest
{
  private static final Price TOTAL_PRICE_EXPECTED = new Price(10.0);
  private static final int INFANTS_NUMBER = 2;
  private static final Price BASE_PRICE = new Price(5.0);
  private InfantRule infantRule = new InfantRule();

  @Test
  public void calculatePriceInfants()
  {
    Price totalPrice = infantRule.calculatePrice(BASE_PRICE, INFANTS_NUMBER);

    assertThat("The price is equals", totalPrice, equalTo(TOTAL_PRICE_EXPECTED));
  }
}
