package com.flights.domain.rule.daysadvancerule;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.flights.domain.model.Price;
import com.flights.domain.rule.daysadvancerule.DaysAdvanceRule;

public class DaysAdvanceRuleTest
{
  private static final Price BASE_PRICE = new Price(100.0);
  private static final Price TOTAL_PRICE_WITH_LESS_3DAYS_ADVANCE = new Price(150.0);
  private static final Price TOTAL_PRICE_WITH_BETWEEN_3_15_DAYS_ADVANCE = new Price(120.0);
  private static final Price TOTAL_PRICE_WITH_BETWEEN_16_30_DAYS_ADVANCE = new Price(100.0);
  private static final Price TOTAL_PRICE_WITH_MORE_30DAYS_ADVANCE = new Price(80.0);
  private DaysAdvanceRule destinationDateRule = new DaysAdvanceRule();

  @Test
  public void calculatePriceWithLess3DaysAdvance()
  {
    Price totalPrice = destinationDateRule.calculatePrice(obtainDateWithDaysAdvance(2), BASE_PRICE);

    assertThat("The price is equals", totalPrice, equalTo(TOTAL_PRICE_WITH_LESS_3DAYS_ADVANCE));
  }

  @Test
  public void calculatePriceWithBetween3And15DaysAdvance()
  {
    Price totalPrice = destinationDateRule.calculatePrice(obtainDateWithDaysAdvance(4), BASE_PRICE);

    assertThat("The price is equals", totalPrice, equalTo(TOTAL_PRICE_WITH_BETWEEN_3_15_DAYS_ADVANCE));
  }

  @Test
  public void calculatePriceWithBetween16And30DaysAdvance()
  {
    Price totalPrice = destinationDateRule.calculatePrice(obtainDateWithDaysAdvance(17), BASE_PRICE);

    assertThat("The price is equals", totalPrice, equalTo(TOTAL_PRICE_WITH_BETWEEN_16_30_DAYS_ADVANCE));
  }

  @Test
  public void calculatePriceWithMore30DaysAdvance()
  {
    Price totalPrice = destinationDateRule.calculatePrice(obtainDateWithDaysAdvance(40), BASE_PRICE);

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
