package com.flights.domain.model;

import static com.flights.domain.model.Airport.BCN;
import static com.flights.domain.model.Airport.CPH;
import static com.flights.domain.model.Airport.IST;
import static com.flights.domain.model.Airport.LHR;
import static com.flights.domain.model.Airport.MAD;
import static com.flights.domain.model.Airport.XXX;
import static com.flights.domain.model.PassengersFixture.ONE_AD_TWO_CH;
import static com.flights.domain.model.PassengersFixture.TWO_AD;
import static com.flights.domain.model.PassengersFixture.TWO_AD_ONE_CH_ONE_IN;

import java.util.Date;

import com.flights.DateUtil;

public class SearchCriteriaFixture
{
  public static final SearchCriteria CPH_LHR_WITH_2AD_5DAYS = create(CPH, LHR, 5, TWO_AD);
  public static final SearchCriteria XXX_LHR_2AD_2DAYS = create(XXX, LHR, 2, TWO_AD);
  public static final SearchCriteria BCN_MAD_WITH_1AD_2CH_2DAYS = create(BCN, MAD, 2, ONE_AD_TWO_CH);
  public static final SearchCriteria LHR_IST_WITH_2AD_1CH_1IN_15DAYS = create(LHR,
                                                                              IST,
                                                                              15,
                                                                              TWO_AD_ONE_CH_ONE_IN);

  private static SearchCriteria
          create(Airport origin, Airport destination, int daysAdvance, Passengers passengers)
  {
    Route route = new Route(origin, destination);
    Date departureDate = DateUtil.obtainDateWithDaysAdvance(daysAdvance);
    SearchCriteria searchCriteria = new SearchCriteria(route, departureDate, passengers);
    return searchCriteria;
  }
}
