package com.flights.repository.provider;

import com.flights.DateUtil;
import com.flights.domain.model.Airline;
import com.flights.domain.model.Flight;
import com.flights.domain.model.Route;

public class FlightProviderFixture
{
  public static final Flight BCN_MAD_U2_2DAYS = createFlightProvider("BCN", "MAD", 259.0, "IB2171", Airline.IB, 2);
  public static final Flight BCN_MAD_BA_2DAYS = createFlightProvider("BCN", "MAD", 293.0, "LH5496", Airline.LH, 2);

  public static final Flight CPH_LHR_U2 = createFlightProvider("CPH", "LHR", 152.0, "U23631", Airline.U2, 5);
  public static final Flight CPH_LHR_BA = createFlightProvider("CPH", "LHR", 138.0, "BA7710", Airline.BA, 5);

  public static final Flight LHR_IST_TK_15DAYS = createFlightProvider("LHR", "IST", 250.0, "TK8891", Airline.TK, 15);
  public static final Flight LHR_IST_LH_15DAYS = createFlightProvider("LHR", "IST", 148.0, "LH1085", Airline.LH, 15);

  private static Flight createFlightProvider(String origin,
                                             String destination,
                                             Double priceBase,
                                             String flightCode,
                                             Airline airline,
                                             int daysAdvance)
  {
    Route route = new Route(origin, destination);
    Flight flight = new Flight();
    flight.setDepartureDate(DateUtil.obtainDateWithDaysAdvance(daysAdvance));
    flight.setFlightCode(flightCode);
    flight.setBasePrice(priceBase);
    flight.setRoute(route);
    flight.setAirline(airline.getName());
    flight.setInfantPrice(InfantPriceFinder.obtainPrice(airline));
    return flight;
  }
}
