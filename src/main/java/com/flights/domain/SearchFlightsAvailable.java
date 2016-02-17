package com.flights.domain;

import com.flights.domain.model.Flight;
import com.flights.domain.model.Flights;
import com.flights.domain.model.SearchCriteria;
import com.flights.repository.provider.SearchFlightsAdapter;

public class SearchFlightsAvailable
{
  private SearchFlightsAdapter searchFlightsAdapter;
  private CalculatePricesFlight calculatePricesFlight;

  public SearchFlightsAvailable(SearchFlightsAdapter searchFlightsAdapter,
      CalculatePricesFlight calculateTotalPriceFlight)
  {
    this.searchFlightsAdapter = searchFlightsAdapter;
    this.calculatePricesFlight = calculateTotalPriceFlight;
  }

  public Flights execute(SearchCriteria criteria)
  {
    Flights flights = searchFlights(criteria);
    fillTotalPrice(criteria, flights);
    return flights;
  }

  private Flights searchFlights(SearchCriteria criteria)
  {
    return searchFlightsAdapter.search(criteria);
  }

  private void fillTotalPrice(SearchCriteria criteria, Flights flights)
  {
    for (Flight flight : flights.getFlights())
    {
      flight.setTotalPrice(calculatePricesFlight.calculate(criteria, flight));
    }
  }
}
