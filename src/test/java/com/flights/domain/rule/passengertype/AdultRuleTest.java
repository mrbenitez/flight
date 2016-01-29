package com.flights.domain.rule.passengertype;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class AdultRuleTest
{
  private AdultRule adultRule = new AdultRule();

  @Test
  public void calculatePriceAdults()
  {
    Double totalPrice = adultRule.calculatePrice(600.5, 5);

    assertThat("The price is equals", totalPrice, equalTo(3002.5));
  }
}
