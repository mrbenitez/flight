package com.flights.domain.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyDate
{
  private Date date;

  public MyDate(Date date)
  {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.HOUR, 0);
    this.date = calendar.getTime();
  }

  public Date getDate()
  {
    return date;
  }

  public int daysBetweenTwoDates(MyDate departureDate)
  {
    Calendar today = new GregorianCalendar();
    today.setTime(getDate());
    long todayMilisecond = today.getTimeInMillis();
    Calendar departureDateCalendar = new GregorianCalendar();
    departureDateCalendar.setTime(departureDate.getDate());
    long destinationMilisecond = departureDateCalendar.getTimeInMillis();
    long diffMilisecond = destinationMilisecond - todayMilisecond;
    return (int) (diffMilisecond / (24 * 60 * 60 * 1000));
  }

  public Date obtainDateWithDaysAdvance(int daysAdvance)
  {
    long daysAdvanceInMilisecond = daysAdvance * (24 * 60 * 60);
    daysAdvanceInMilisecond = daysAdvanceInMilisecond * 1000;
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(date.getTime() + daysAdvanceInMilisecond);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.HOUR, 0);
    return calendar.getTime();
  }
}
