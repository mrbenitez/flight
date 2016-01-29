package com.flights.domain.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.flights.DateUtil;

public class SearchCriteriaFixture
{
  public static final SearchCriteria CPH_LHR_WITH_2AD_5DAYS = create("CPH", "LHR", 5, passenger2ad());
  public static final SearchCriteria LHR_ROUTE_NOTE_EXIST_2AD_2DAYS = create("XXX", "LHR", 2, passenger2ad());
  public static final SearchCriteria BCN_MAD_WITH_1AD_2CH_2DAYS = create("BCN", "MAD", 2, passenger1ad2ch());
  public static final SearchCriteria LHR_IST_WITH_2AD_1CH_1IN_15DAYS = create("LHR",
                                                                              "IST",
                                                                              15,
                                                                              passenger2ad1ch1in());

  private static SearchCriteria
          create(String origin, String destination, int daysAdvance, Map<PassangerType, Integer> passenger)
  {
    Route route = new Route(origin, destination);
    Date departureDate = DateUtil.obtainDateWithDaysAdvance(daysAdvance);
    SearchCriteria searchCriteria = new SearchCriteria(route, departureDate, passenger);
    return searchCriteria;
  }

  private static Map<PassangerType, Integer> passenger2ad()
  {
    Map<PassangerType, Integer> passenger = new HashMap<PassangerType, Integer>();
    passenger.put(PassangerType.ADULT, 2);
    return passenger;
  }

  private static Map<PassangerType, Integer> passenger1ad2ch()
  {
    Map<PassangerType, Integer> passenger = new HashMap<PassangerType, Integer>();
    passenger.put(PassangerType.ADULT, 1);
    passenger.put(PassangerType.CHILD, 2);
    return passenger;
  }

  private static Map<PassangerType, Integer> passenger2ad1ch1in()
  {
    Map<PassangerType, Integer> passenger = new HashMap<PassangerType, Integer>();
    passenger.put(PassangerType.ADULT, 2);
    passenger.put(PassangerType.CHILD, 1);
    passenger.put(PassangerType.INFANT, 1);
    return passenger;
  }
}
