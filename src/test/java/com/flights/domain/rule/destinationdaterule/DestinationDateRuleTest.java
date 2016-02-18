package com.flights.domain.rule.destinationdaterule;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.flights.domain.model.Price;

@RunWith(Parameterized.class)
public class DestinationDateRuleTest
{
  private DestinationDateRule destinationDateRule = new DestinationDateRule();
  private Price basePrice = new Price(100.0);

  private Price priceExpected;
  private Date departureDate;

  public DestinationDateRuleTest(Price priceExpected, Date departureDate)
  {
    this.priceExpected = priceExpected;
    this.departureDate = departureDate;
  }

  @Parameters
  public static Collection operationTypeValues()
  {
    return Arrays.asList(new Object[][] {
        { new Price(115.0), obtainDate(Calendar.SUNDAY)},
        { new Price(100.0), obtainDate(Calendar.MONDAY)},
        { new Price(110.0), obtainDate(Calendar.TUESDAY)},
        { new Price(110.0), obtainDate(Calendar.WEDNESDAY)},
        { new Price(100.0), obtainDate(Calendar.THURSDAY)},
        { new Price(115.0), obtainDate(Calendar.FRIDAY)},
        { new Price(100.0), obtainDate(Calendar.SATURDAY)}
    });
  }

  @Test
  public void pricekWhenDestinationDayIsSunday()
  {
    execute(basePrice, priceExpected, departureDate);
  }

  private void execute(Price basePrice, Price priceExpected, Date departureDate)
  {
    Price destinationDayPrice = destinationDateRule.calculatePrice(basePrice, departureDate);

    assertThat("destinationDayPrice", destinationDayPrice, equalTo(priceExpected));
  }

  private static Date obtainDate(int dayOfWeek)
  {
    Calendar calendar = new GregorianCalendar();
    calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
    return calendar.getTime();
  }
}
