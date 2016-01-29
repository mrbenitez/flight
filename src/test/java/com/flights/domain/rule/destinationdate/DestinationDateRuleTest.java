package com.flights.domain.rule.destinationdate;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DestinationDateRuleTest
{
  private DestinationDateRule destinationDateRule = new DestinationDateRule();

  @Test
  public void calculatePriceWith0daysAdvance()
  {
    Double totalPrice = destinationDateRule.calculatePrice(obtainDateWithDaysAdvance(2), 100.0);

    assertThat("The price is equals", totalPrice, equalTo(150.0));
  }

  @Test
  public void calculatePriceWith4daysAdvance()
  {
    Double totalPrice = destinationDateRule.calculatePrice(obtainDateWithDaysAdvance(4), 100.0);

    assertThat("The price is equals", totalPrice, equalTo(120.0));
  }

  @Test
  public void calculatePriceWith17daysAdvance()
  {
    Double totalPrice = destinationDateRule.calculatePrice(obtainDateWithDaysAdvance(17), 100.0);

    assertThat("The price is equals", totalPrice, equalTo(100.0));
  }

  @Test
  public void calculatePriceWith40daysAdvance()
  {
    Double totalPrice = destinationDateRule.calculatePrice(obtainDateWithDaysAdvance(40), 100.0);

    assertThat("The price is equals", totalPrice, equalTo(80.0));
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
