package com.flights.domain.model;

import static java.util.Arrays.asList;

import java.util.List;

public class FlightsFixture
{
  public static final Flights LHR_IST_2AD_1CH_1IN_15_DAYS = create(asList(FlightFixture.LHR_IST_TK_15DAYS,
                                                                          FlightFixture.LHR_IST_LH_15DAYS));

  public static final Flights BCN_MAD_WITH_1AD_2CH_2DAYS = create(asList(FlightFixture.BCN_MAD_U2_2DAYS,
                                                                         FlightFixture.BCN_MAD_BA_2DAYS));

  private static Flights create(List<Flight> flight)
  {
    Flights flights = new Flights();
    flights.addAll(flight);
    return flights;
  }
}
