package com.flights.domain.rule.destinationdate;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.flights.DateUtil;
import com.flights.domain.model.Price;

public class DestinationDateRule
{
  private static final double PORCENTAJE_MORE_30_DAYS_ADVANCE = 0.8;
  private static final double PORCENTAJE_BETWEEN_3_15_DAYS_ADVANCE = 1.0;
  private static final double PORCENTAJE_BETWEEN_15_30_DAYS_ADVANCE = 1.2;
  private static final double PORCENTAJE_LESS_3_DAYS_ADVANCE = 1.5;

  public Price calculatePrice(Date destinationDate, Price basePrice)
  {
    int diffDays = calculateDaysAdvance(destinationDate);
    Double taxPorcentage = PORCENTAJE_LESS_3_DAYS_ADVANCE;
    if (diffDays > 30)
    {
      taxPorcentage = PORCENTAJE_MORE_30_DAYS_ADVANCE;
    }
    else if (diffDays >= 16 && diffDays <= 30)
    {
      taxPorcentage = PORCENTAJE_BETWEEN_3_15_DAYS_ADVANCE;
    }
    else if (diffDays >= 3 && diffDays <= 15)
    {
      taxPorcentage = PORCENTAJE_BETWEEN_15_30_DAYS_ADVANCE;
    }

    return new Price(basePrice.getValue() * taxPorcentage);
  }

  private int calculateDaysAdvance(Date destinationDate)
  {
    Calendar todayCalendar = new GregorianCalendar();
    Calendar destinationDateCalendar = new GregorianCalendar();
    destinationDateCalendar.setTime(destinationDate);
    return DateUtil.daysBetweenTwoDates(todayCalendar, destinationDateCalendar);
  }
}
