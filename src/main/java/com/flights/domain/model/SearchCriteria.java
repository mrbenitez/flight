package com.flights.domain.model;

import java.util.Date;

public class SearchCriteria
{
  private Route route;
  private MyDate departureDate;
  private Passengers passengers;

  public SearchCriteria(Route route, Date departureDate, Passengers passengers)
  {
    super();
    this.route = route;
    this.departureDate = new MyDate(departureDate);
    this.passengers = passengers;
  }

  public Route getRoute()
  {
    return route;
  }

  public MyDate getDepartureDate()
  {
    return departureDate;
  }

  public Passengers getPassenger()
  {
    return passengers;
  }
}
