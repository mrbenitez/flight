package com.flights.domain.model;

import java.util.Date;

public class FlightFixture
{
  private static Date date = null;
  public static final Flight U2_CPH_LHR = create("CPH", "LHR", 152.0, "U23631");
  public static final Flight BA_CPH_LHR = create("CPH", "LHR", 138.0, "BA7710");

  private static Flight create(String origin,
                               String destination,

                               Double priceBase,
                               String flightCode)
  {
    Route route = new Route(origin, destination);
    Flight flight = new Flight();
    // date.setSeconds(0);
    // date.setMinutes(0);
    // date.setHours(0);
    flight.setDepartureDate(date);
    flight.setFlightCode(flightCode);
    flight.setPriceBase(priceBase);
    flight.setRoute(route);
    return flight;
  }
}
