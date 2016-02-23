package com.flights.domain.model;

import java.util.Date;

// REV Responsibility
/*
This class has many responsibilities:
- it represents a scheduled flight (i.e. a flight in the timetable)
- it stores the final price for a search
 */
public class Flight
{
  private Route route;
  private Date departureDate;
  private String flightCode;
  private Price basePrice;
  private Price infantPrice;
  private Price totalPrice;
  private String airline;

  private Flight(Route route, Date departureDate, String flightCode, Price basePrice, Price infantPrice,
      String airline)
  {
    this.route = route;
    this.departureDate = departureDate;
    this.flightCode = flightCode;
    this.basePrice = basePrice;
    this.infantPrice = infantPrice;
    this.airline = airline;
  }

  public Price getTotalPrice()
  {
    return totalPrice;
  }

  public void setTotalPrice(Price totalPrice)
  {
    this.totalPrice = totalPrice;
  }

  public Route getRoute()
  {
    return route;
  }

  public Date getDepartureDate()
  {
    return departureDate;
  }

  public String getFlightCode()
  {
    return flightCode;
  }

  public Price getBasePrice()
  {
    return basePrice;
  }

  public Price getInfantPrice()
  {
    return infantPrice;
  }

  public String getAirline()
  {
    return airline;
  }

  @Override
  public String toString()
  {
    return "Flight [route=" + route + ", departureDate=" + departureDate + ", flightCode=" + flightCode
        + ", basePrice=" + basePrice + ", infantPrice=" + infantPrice + ", totalPrice=" + totalPrice
        + ", airline=" + airline + "]";
  }

  // Java 7/8
  /*
  Use java.util.Objects for generating equals/hashCode.
   */
  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((airline == null) ? 0 : airline.hashCode());
    result = prime * result + ((basePrice == null) ? 0 : basePrice.hashCode());
    result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
    result = prime * result + ((flightCode == null) ? 0 : flightCode.hashCode());
    result = prime * result + ((infantPrice == null) ? 0 : infantPrice.hashCode());
    result = prime * result + ((route == null) ? 0 : route.hashCode());
    result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
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
    if (airline == null)
    {
      if (other.airline != null)
      {
        return false;
      }
    }
    else if (!airline.equals(other.airline))
    {
      return false;
    }
    if (basePrice == null)
    {
      if (other.basePrice != null)
      {
        return false;
      }
    }
    else if (!basePrice.equals(other.basePrice))
    {
      return false;
    }
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
    if (infantPrice == null)
    {
      if (other.infantPrice != null)
      {
        return false;
      }
    }
    else if (!infantPrice.equals(other.infantPrice))
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
    if (totalPrice == null)
    {
      if (other.totalPrice != null)
      {
        return false;
      }
    }
    else if (!totalPrice.equals(other.totalPrice))
    {
      return false;
    }
    return true;
  }

  // REV patterns
  /*
  This builder implementation does the same as the private Flight constructor.
   */
  public static class Builder
  {
    private Route route;
    private Date departureDate;
    private String flightCode;
    private Price basePrice;
    private Price infantPrice;
    private String airline;

    public Builder(Route route, Date departureDate, String flightCode, Price basePrice, Price infantPrice,
        String airline)
    {
      this.route = route;
      this.departureDate = departureDate;
      this.flightCode = flightCode;
      this.basePrice = basePrice;
      this.infantPrice = infantPrice;
      this.airline = airline;
    }

    public Flight build()
    {
      return new Flight(route, departureDate, flightCode, basePrice, infantPrice, airline);
    }
  }
}
