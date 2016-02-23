package com.flights.domain.model;

import java.util.Map;

// REV responsibility
/*
This class wraps a map of passengers but it doesn't provide any additional behaviour.
 */
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
