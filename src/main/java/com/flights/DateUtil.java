package com.flights;

import java.util.Calendar;
import java.util.Date;

// REV Encapsulation
/*
Create your own domain type representing dates.
 */
// REV Java 8 features
/*
Use java.time API.
 */
public class DateUtil
{
  public static Date obtainDateWithDaysAdvance(int daysAdvance)
  {
    long daysAdvanceInMilisecond = daysAdvance * (24 * 60 * 60);
    daysAdvanceInMilisecond = daysAdvanceInMilisecond * 1000;
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(calendar.getTimeInMillis() + daysAdvanceInMilisecond);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.HOUR, 0);
    return calendar.getTime();
  }

  public static int daysBetweenTwoDates(Calendar today, Calendar destination)
  {
    long todayMilisecond = today.getTimeInMillis();
    long destinationMilisecond = destination.getTimeInMillis();
    long diffMilisecond = destinationMilisecond - todayMilisecond;
    return (int) (diffMilisecond / (24 * 60 * 60 * 1000));
  }
}
