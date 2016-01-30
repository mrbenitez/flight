package com.flights.domain.model;

import java.util.Map;

public class Passengers
{
  private Map<PassengerType, Integer> passenger;

  public Passengers(Map<PassengerType, Integer> passenger)
  {
    this.passenger = passenger;
  }

  public Map<PassengerType, Integer> get()
  {
    return passenger;
  }
}
