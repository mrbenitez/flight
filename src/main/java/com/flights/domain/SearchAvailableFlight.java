package com.flights.domain;

import com.flights.domain.model.Flight;
import com.flights.domain.model.Flights;
import com.flights.domain.model.Price;
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
    Flights flights = searchFlights(criteria);
    fillTotalPrice(criteria, flights);
    return flights;
  }

  private Flights searchFlights(SearchCriteria criteria)
  {
    return searchFlightAdapter.search(criteria);
  }

  private void fillTotalPrice(SearchCriteria criteria, Flights flights)
  {
    for (Flight flight : flights.getFlights())
    {
      Price totalPrice = calculateTotalPriceFlight.calculate(criteria, flight);
      flight.setTotalPrice(totalPrice);
    }
  }
}
