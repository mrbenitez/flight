package com.flights.repository.provider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import com.flights.domain.model.Airline;
import com.flights.domain.model.Airport;
import com.flights.domain.model.Flight;
import com.flights.domain.model.Flights;
import com.flights.domain.model.Price;
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

            Route route = new Route(Airport.getAirport(origin), Airport.getAirport(destination));
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
    Price basePrice = new Price(Double.valueOf(priceBase.trim()));
    String airlineCode = flightCode.substring(0, 2);
    Airline airline = Airline.getAirline(airlineCode);
    Price infantPrice = InfantPriceFinder.obtainPrice(airline);
    Flight.Builder builder = new Flight.Builder(route, criteria.getDepartureDate(), flightCode,
        basePrice, infantPrice, airline.getName());
    return builder.build();
  }
}
