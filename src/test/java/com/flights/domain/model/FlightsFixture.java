package com.flights.domain.model;

import java.util.Arrays;
import java.util.List;

public class FlightsFixture
{
  public static final Flights FLIGHTS_CPH_LHR_2AD = create(Arrays.asList(FlightFixture.U2_CPH_LHR,
                                                                         FlightFixture.BA_CPH_LHR));

  public static final Flights FLIGHTS_ROUTE_NOTE_EXIST_2AD = new Flights();

  private static Flights create(List<Flight> flight)
  {
    Flights flights = new Flights();
    flights.addAll(flight);
    return flights;
  }
}
