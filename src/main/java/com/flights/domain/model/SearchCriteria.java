package com.flights.domain.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SearchCriteria
{
  private Route route;
  private Date departureDate;
  private Map<PassangerType, Integer> passenger = new HashMap<PassangerType, Integer>();

  public SearchCriteria(Route route, Date departureDate, Map<PassangerType, Integer> passenger)
  {
    super();
    this.route = route;
    this.departureDate = departureDate;
    this.passenger = passenger;
  }

  public Route getRoute()
  {
    return route;
  }

  public Date getDepartureDate()
  {
    return departureDate;
  }

  public Map<PassangerType, Integer> getPassenger()
  {
    return passenger;
  }
}
