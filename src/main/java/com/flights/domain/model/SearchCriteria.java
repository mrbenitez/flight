package com.flights.domain.model;

import java.util.Date;

public class SearchCriteria
{
  private Route route;
  private Date departureDate;
  private Passengers passengers;

  public SearchCriteria(Route route, Date departureDate, Passengers passengers)
  {
    super();
    this.route = route;
    this.departureDate = departureDate;
    this.passengers = passengers;
  }

  public Route getRoute()
  {
    return route;
  }

  public Date getDepartureDate()
  {
    return departureDate;
  }

  public Passengers getPassenger()
  {
    return passengers;
  }
}
