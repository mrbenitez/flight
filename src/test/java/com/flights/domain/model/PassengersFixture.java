package com.flights.domain.model;

import java.util.HashMap;
import java.util.Map;

public class PassengersFixture
{
  public static final Passengers TWO_AD = create(2, 0, 0);
  public static final Passengers ONE_AD_TWO_CH = create(1, 2, 0);
  public static final Passengers TWO_AD_ONE_CH_ONE_IN = create(2, 1, 1);

  private static Passengers create(Integer adults, Integer children, Integer infants)
  {
    Map<PassengerType, Integer> map = new HashMap<>();
    add(map, adults, PassengerType.ADULT);
    add(map, children, PassengerType.CHILD);
    add(map, infants, PassengerType.INFANT);
    return new Passengers(map);
  }

  private static void add(Map<PassengerType, Integer> map, Integer numPassenger, PassengerType passengerType)
  {
    if (numPassenger > 0)
    {
      map.put(passengerType, numPassenger);
    }
  }
}
