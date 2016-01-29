package com.flights.domain.model;

import java.util.Date;

public class Flight
{
  private Route route;
  private Date departureDate;
  private Double priceBase;
  private String flightCode;

  public String getFlightCode()
  {
    return flightCode;
  }

  public void setFlightCode(String flightCode)
  {
    this.flightCode = flightCode;
  }

  public Route getRoute()
  {
    return route;
  }

  public void setRoute(Route route)
  {
    this.route = route;
  }

  public Date getDepartureDate()
  {
    return departureDate;
  }

  public void setDepartureDate(Date departureDate)
  {
    this.departureDate = departureDate;
  }

  public Double getPriceBase()
  {
    return priceBase;
  }

  public void setPriceBase(Double priceBase)
  {
    this.priceBase = priceBase;
  }

  @Override
  public String toString()
  {
    return "Flight [route=" + route + ", departureDate=" + departureDate + ", priceBase=" + priceBase
        + ", flightCode=" + flightCode + "]";
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
    result = prime * result + ((flightCode == null) ? 0 : flightCode.hashCode());
    result = prime * result + ((priceBase == null) ? 0 : priceBase.hashCode());
    result = prime * result + ((route == null) ? 0 : route.hashCode());
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
    Flight other = (Flight) obj;
    if (departureDate == null)
    {
      if (other.departureDate != null)
      {
        return false;
      }
    }
    else if (!departureDate.equals(other.departureDate))
    {
      return false;
    }
    if (flightCode == null)
    {
      if (other.flightCode != null)
      {
        return false;
      }
    }
    else if (!flightCode.equals(other.flightCode))
    {
      return false;
    }
    if (priceBase == null)
    {
      if (other.priceBase != null)
      {
        return false;
      }
    }
    else if (!priceBase.equals(other.priceBase))
    {
      return false;
    }
    if (route == null)
    {
      if (other.route != null)
      {
        return false;
      }
    }
    else if (!route.equals(other.route))
    {
      return false;
    }
    return true;
  }

}
