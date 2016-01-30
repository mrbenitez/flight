package com.flights.domain.rule.destinationdate;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DestinationDateRuleTest
{
  private static final double BASE_PRICE = 100.0;
  private static final double TOTAL_PRICE_WITH_LESS_3DAYS_ADVANCE = 150.0;
  private static final double TOTAL_PRICE_WITH_BETWEEN_3_15_DAYS_ADVANCE = 120.0;
  private static final double TOTAL_PRICE_WITH_BETWEEN_16_30_DAYS_ADVANCE = 100.0;
  private static final double TOTAL_PRICE_WITH_MORE_30DAYS_ADVANCE = 80.0;
  private DestinationDateRule destinationDateRule = new DestinationDateRule();

  @Test
  public void calculatePriceWithLess3DaysAdvance()
  {
    Double totalPrice = destinationDateRule.calculatePrice(obtainDateWithDaysAdvance(2), BASE_PRICE);

    assertThat("The price is equals", totalPrice, equalTo(TOTAL_PRICE_WITH_LESS_3DAYS_ADVANCE));
  }

  @Test
  public void calculatePriceWithBetween3And15DaysAdvance()
  {
    Double totalPrice = destinationDateRule.calculatePrice(obtainDateWithDaysAdvance(4), BASE_PRICE);

    assertThat("The price is equals", totalPrice, equalTo(TOTAL_PRICE_WITH_BETWEEN_3_15_DAYS_ADVANCE));
  }

  @Test
  public void calculatePriceWithBetween16And30DaysAdvance()
  {
    Double totalPrice = destinationDateRule.calculatePrice(obtainDateWithDaysAdvance(17), BASE_PRICE);

    assertThat("The price is equals", totalPrice, equalTo(TOTAL_PRICE_WITH_BETWEEN_16_30_DAYS_ADVANCE));
  }

  @Test
  public void calculatePriceWithMore30DaysAdvance()
  {
    Double totalPrice = destinationDateRule.calculatePrice(obtainDateWithDaysAdvance(40), BASE_PRICE);

    assertThat("The price is equals", totalPrice, equalTo(TOTAL_PRICE_WITH_MORE_30DAYS_ADVANCE));
  }

  private Date obtainDateWithDaysAdvance(int daysAdvance)
  {
    long daysAdvanceInMilisecond = daysAdvance * (24 * 60 * 60);
    daysAdvanceInMilisecond = daysAdvanceInMilisecond * 1000;
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(calendar.getTimeInMillis() + daysAdvanceInMilisecond);
    return calendar.getTime();
  }
}
