package com.flights.domain.model;

import static com.flights.domain.model.FlightFixture.BCN_MAD_BA_WITH_1AD_2CH_2DAYS;
import static com.flights.domain.model.FlightFixture.BCN_MAD_U2_WITH_1AD_2CH_2DAYS;
import static com.flights.domain.model.FlightFixture.CPH_LHR_BA_5DAYS;
import static com.flights.domain.model.FlightFixture.CPH_LHR_U2_5DAYS;
import static com.flights.domain.model.FlightFixture.LHR_IST_LH_WITH_2AD_1CH_1IN_15DAYS;
import static com.flights.domain.model.FlightFixture.LHR_IST_TK_WITH_2AD_1CH_1IN_15DAYS;
import static java.util.Arrays.asList;

import java.util.List;

public class FlightsFixture
{
  public static final Flights CPH_LHR_2AD_5DAYS = create(asList(CPH_LHR_U2_5DAYS,
                                                                CPH_LHR_BA_5DAYS));

  public static final Flights ROUTE_NOT_EXIST_2AD = new Flights();

  public static final Flights LHR_IST_WITH_2AD_1CH_1IN_15DAYS = create(asList(LHR_IST_TK_WITH_2AD_1CH_1IN_15DAYS,
                                                                              LHR_IST_LH_WITH_2AD_1CH_1IN_15DAYS));
  public static final Flights BCN_MAD_WITH_1AD_2CH_2DAYS = create(asList(BCN_MAD_U2_WITH_1AD_2CH_2DAYS,
                                                                         BCN_MAD_BA_WITH_1AD_2CH_2DAYS));

  private static Flights create(List<Flight> flight)
  {
    Flights flights = new Flights();
    flights.addAll(flight);
    return flights;
  }
}
