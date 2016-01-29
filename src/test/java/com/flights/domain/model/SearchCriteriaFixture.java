package com.flights.domain.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SearchCriteriaFixture
{
  public static final SearchCriteria CPH_LHR_WITH_2AD = create("CPH", "LHR");
  public static final SearchCriteria LHR_ROUTE_NOTE_EXIST_2AD = create("XXX", "LHR");

  private static SearchCriteria create(String origin, String destination)
  {
    Route route = new Route(origin, destination);
    Date departureDate = null;
    // departureDate.setSeconds(0);
    // departureDate.setMinutes(0);
    // departureDate.setHours(0);
    Map<PassangerType, Integer> passenger = new HashMap<PassangerType, Integer>();
    passenger.put(PassangerType.ADULT, 2);
    SearchCriteria searchCriteria = new SearchCriteria(route, departureDate, passenger);
    return searchCriteria;
  }
}
