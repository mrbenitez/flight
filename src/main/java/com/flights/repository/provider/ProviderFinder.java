package com.flights.repository.provider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import com.flights.domain.model.Airline;
import com.flights.domain.model.Flight;
import com.flights.domain.model.Flights;
import com.flights.domain.model.Route;
import com.flights.domain.model.SearchCriteria;

public class ProviderFinder
{
  private static final String DELIM = ",";
  private String fileName = "src/main/resources/flights.csv";

  public Flights execute(SearchCriteria criteria)
  {
    Flights flights = new Flights();

    BufferedReader br;
    try
    {
      br = new BufferedReader(new FileReader(fileName));
      StringTokenizer st = null;
      boolean firstLine = true;
      while ((fileName = br.readLine()) != null)
      {
        st = new StringTokenizer(fileName, DELIM);
        if (!firstLine)
        {
          while (st.hasMoreTokens())
          {
            String origin = st.nextToken();
            String destination = st.nextToken();
            String flightCode = st.nextToken();
            String priceBase = st.nextToken();

            Route route = new Route(origin, destination);
            if (route.equals(criteria.getRoute()))
            {
              Flight flight = createFlight(criteria, flightCode, priceBase, route);
              flights.add(flight);
            }
          }
        }
        firstLine = false;
      }
      br.close();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return flights;
  }

  private Flight createFlight(SearchCriteria criteria, String flightCode, String priceBase, Route route)
  {
    Flight flight = new Flight();
    flight.setRoute(route);
    flight.setFlightCode(flightCode);
    flight.setBasePrice(Double.valueOf(priceBase.trim()));

    String airlineCode = flightCode.substring(0, 2);
    Airline airline = Airline.getAirline(airlineCode);
    flight.setAirline(airline.getName());
    Double infantPrice = InfantPriceFinder.obtainPrice(airline);
    flight.setInfantPrice(infantPrice);
    flight.setDepartureDate(criteria.getDepartureDate());
    return flight;
  }

  // Map<Route, Flight> mapFlights = new HashMap<Route, Flight>();
  //
  // public Flights search(SearchCriteria criteria)
  // {
  // Flights flights = new Flights();
  //
  // if (mapFlights.containsKey(criteria.getRoute()))
  // {
  // flights.add(mapFlights.get(criteria.getRoute()));
  // }
  //
  // return flights;
  // }
}
