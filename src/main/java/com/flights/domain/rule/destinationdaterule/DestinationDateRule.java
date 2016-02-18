package com.flights.domain.rule.destinationdaterule;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import com.flights.domain.model.MyDate;
import com.flights.domain.model.Price;

public class DestinationDateRule
{
  private Map<Integer, Double> mapIncreasePrice = new HashMap<>();

  public DestinationDateRule()
  {
    mapIncreasePrice.put(Calendar.SUNDAY, 1.15);
    mapIncreasePrice.put(Calendar.MONDAY, 1.0);
    mapIncreasePrice.put(Calendar.TUESDAY, 1.10);
    mapIncreasePrice.put(Calendar.WEDNESDAY, 1.10);
    mapIncreasePrice.put(Calendar.THURSDAY, 1.0);
    mapIncreasePrice.put(Calendar.FRIDAY, 1.15);
    mapIncreasePrice.put(Calendar.SATURDAY, 1.0);
  }

  public Price calculatePrice(Price basePrice, MyDate deapartureDate)
  {
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(deapartureDate.getDate());

    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    double increasePrice = mapIncreasePrice.get(dayOfWeek);

    return new Price(basePrice.getValue() * increasePrice);
  }
}
