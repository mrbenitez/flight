package com.flights.domain.rule.daysadvancerule;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.flights.domain.model.MyDate;
import com.flights.domain.model.Price;

public class DaysAdvanceRuleTest
{
  private static final Price BASE_PRICE = new Price(100.0);
  private static final Price TOTAL_PRICE_WITH_LESS_3DAYS_ADVANCE = new Price(150.0);
  private static final Price TOTAL_PRICE_WITH_BETWEEN_3_15_DAYS_ADVANCE = new Price(120.0);
  private static final Price TOTAL_PRICE_WITH_BETWEEN_16_30_DAYS_ADVANCE = new Price(100.0);
  private static final Price TOTAL_PRICE_WITH_MORE_30DAYS_ADVANCE = new Price(80.0);
  private DaysAdvanceRule destinationDateRule = new DaysAdvanceRule();
  private MyDate today = new MyDate(new Date());

  public static class TestingDate extends MyDate
  {
    private int differenceToAnotherDate;

    public TestingDate(int differenceToAnotherDate)
    {
      super(new Date());
      this.differenceToAnotherDate = differenceToAnotherDate;
    }

    @Override
    public int daysBetweenTwoDates(MyDate other)
    {
      return differenceToAnotherDate;
    }
  }

  @Test
  public void calculatePriceWithLess3DaysAdvance()
  {
    today = new TestingDate(2);
    Price totalPrice = destinationDateRule.calculatePrice(today, null, BASE_PRICE);

    assertThat("The price is equals", totalPrice, equalTo(TOTAL_PRICE_WITH_LESS_3DAYS_ADVANCE));
  }

  @Test
  public void calculatePriceWithBetween3And15DaysAdvance()
  {
    Price totalPrice = destinationDateRule.calculatePrice(today, obtainDateWithDaysAdvance(4), BASE_PRICE);

    assertThat("The price is equals", totalPrice, equalTo(TOTAL_PRICE_WITH_BETWEEN_3_15_DAYS_ADVANCE));
  }

  @Test
  public void calculatePriceWithBetween16And30DaysAdvance()
  {
    Price totalPrice = destinationDateRule.calculatePrice(today, obtainDateWithDaysAdvance(17), BASE_PRICE);

    assertThat("The price is equals", totalPrice, equalTo(TOTAL_PRICE_WITH_BETWEEN_16_30_DAYS_ADVANCE));
  }

  @Test
  public void calculatePriceWithMore30DaysAdvance()
  {
    Price totalPrice = destinationDateRule.calculatePrice(today, obtainDateWithDaysAdvance(40), BASE_PRICE);

    assertThat("The price is equals", totalPrice, equalTo(TOTAL_PRICE_WITH_MORE_30DAYS_ADVANCE));
  }

  private MyDate obtainDateWithDaysAdvance(int daysAdvance)
  {
    long daysAdvanceInMilisecond = daysAdvance * (24 * 60 * 60);
    daysAdvanceInMilisecond = daysAdvanceInMilisecond * 1000;
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(calendar.getTimeInMillis() + daysAdvanceInMilisecond);
    return new MyDate(calendar.getTime());
  }
}
