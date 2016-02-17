package com.flights.domain.rule.passengertype;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.flights.domain.model.Price;

public class AdultRuleTest
{
  private static final Price TOTAL_PRICE_EXPECTED = new Price(3002.5);
  private static final int ADULTS_NUMBER = 5;
  private static final Price BASE_PRICE = new Price(600.5);
  private AdultRule adultRule = new AdultRule();

  @Test
  public void calculatePriceAdults()
  {
    Price totalPrice = adultRule.calculatePrice(BASE_PRICE, ADULTS_NUMBER);

    assertThat("The price is equals", totalPrice, equalTo(TOTAL_PRICE_EXPECTED));
  }
}
