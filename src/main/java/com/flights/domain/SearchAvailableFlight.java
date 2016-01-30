package com.flights.domain;

import com.flights.domain.model.Flight;
import com.flights.domain.model.Flights;
import com.flights.domain.model.SearchCriteria;
import com.flights.repository.provider.SearchFlightAdapter;

public class SearchAvailableFlight
{
  private SearchFlightAdapter searchFlightAdapter;
  private CalculateTotalPriceFlight calculateTotalPriceFlight;

  public SearchAvailableFlight(SearchFlightAdapter searchFlightAdapter,
      CalculateTotalPriceFlight calculateTotalPriceFlight)
  {
    this.searchFlightAdapter = searchFlightAdapter;
    this.calculateTotalPriceFlight = calculateTotalPriceFlight;
  }

  public Flights execute(SearchCriteria criteria)
  {
    Flights flights = searchFlightAdapter.search(criteria);
    fillTotalPrice(criteria, flights);
    return flights;
  }

  private void fillTotalPrice(SearchCriteria criteria, Flights flights)
  {
    for (Flight flight : flights.getFlights())
    {
      Double totalPrice = calculateTotalPriceFlight.calculate(criteria, flight);
      flight.setTotalPrice(totalPrice);// TODO VER SI USAR OTRO OBJETO price para no devolver ni usar double
    }
  }
}
