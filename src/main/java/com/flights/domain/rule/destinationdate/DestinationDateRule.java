package com.flights.domain.rule.destinationdate;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.flights.DateUtil;

public class DestinationDateRule
{

  public Double calculatePrice(Date destinationDate, Double basePrice)
  {
    Double price = null;
    int diffDays = calculateDaysAdvance(destinationDate);

    if (diffDays > 30)
    {
      price = basePrice * 0.8;
    }
    else if (diffDays >= 16 && diffDays <= 30)
    {
      price = basePrice;
    }
    else if (diffDays >= 3 && diffDays <= 15)
    {
      price = basePrice * 1.2;
    }
    else
    {
      price = basePrice * 1.5;
    }

    return price;
  }

  private int calculateDaysAdvance(Date destinationDate)
  {
    Calendar todayCalendar = new GregorianCalendar();
    Calendar destinationDateCalendar = new GregorianCalendar();
    destinationDateCalendar.setTime(destinationDate);
    return DateUtil.daysBetweenTwoDates(todayCalendar, destinationDateCalendar);
  }
}
