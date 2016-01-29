package com.flights.repository.provider;

import java.util.Arrays;
import java.util.List;

import com.flights.domain.model.Flight;
import com.flights.domain.model.Flights;

public class FlightsProviderFixture
{
  public static final Flights CPH_LHR_2AD_2DAYS = create(Arrays.asList(FlightProviderFixture.CPH_LHR_U2,
                                                                         FlightProviderFixture.CPH_LHR_BA));

  public static final Flights ROUTE_NOT_EXIST_2AD = new Flights();

  private static Flights create(List<Flight> flight)
  {
    Flights flights = new Flights();
    flights.addAll(flight);
    return flights;
  }
}
