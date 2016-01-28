package com.flights.domain.rule.passengertype;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class AdultRuleTest
{
  private AdultRule adultRule = new AdultRule();

  @Test
  public void test()
  {
    BigDecimal totalPrice = adultRule.calculatePrice(new BigDecimal(600.5), 5);

    assertThat("The price is equals",
               totalPrice,
               equalTo(new BigDecimal(3002.5)));
  }
}
