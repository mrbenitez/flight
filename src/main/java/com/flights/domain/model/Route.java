package com.flights.domain.model;

public class Route
{
  private String origin;
  private String destination;

  public Route(String origin, String destination)
  {
    this.origin = origin;
    this.destination = destination;
  }

  public String getOrigin()
  {
    return origin;
  }

  public String getDestination()
  {
    return destination;
  }

  @Override
  public String toString()
  {
    return "Route [origin=" + origin + ", destination=" + destination + "]";
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((destination == null) ? 0 : destination.hashCode());
    result = prime * result + ((origin == null) ? 0 : origin.hashCode());
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
    Route other = (Route) obj;
    if (destination == null)
    {
      if (other.destination != null)
      {
        return false;
      }
    }
    else if (!destination.equals(other.destination))
    {
      return false;
    }
    if (origin == null)
    {
      if (other.origin != null)
      {
        return false;
      }
    }
    else if (!origin.equals(other.origin))
    {
      return false;
    }
    return true;
  }
}
