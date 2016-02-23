package com.flights.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Flights
{
  private List<Flight> flights = new ArrayList<Flight>();

  // REV information hiding
  /*
  You return flights that can be modified from outside. Return an immutable list.
   */
  public List<Flight> getFlights()
  {
    return flights;
  }

  public void add(Flight flight)
  {
    this.flights.add(flight);
  }

  public void addAll(List<Flight> flights)
  {
    this.flights.addAll(flights);
  }

  @Override
  public String toString()
  {
    return "Flights [flights=" + flights + "]";
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((flights == null) ? 0 : flights.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }
    if (obj == null)
    {
      return false;
    }
    if (getClass() != obj.getClass())
    {
      return false;
    }
    Flights other = (Flights) obj;
    if (flights == null)
    {
      if (other.flights != null)
      {
        return false;
      }
    }
    else if (!flights.equals(other.flights))
    {
      return false;
    }
    return true;
  }

}
