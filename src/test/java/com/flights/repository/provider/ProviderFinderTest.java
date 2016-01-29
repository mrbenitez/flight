package com.flights.repository.provider;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.flights.domain.model.Flights;
import com.flights.domain.model.FlightsFixture;
import com.flights.domain.model.SearchCriteriaFixture;

public class ProviderFinderTest
{
  private ProviderFinder providerFinder = new ProviderFinder();

  @Test
  public void executeWhenHaveRouteExist()
  {
    Flights flights = providerFinder.execute(SearchCriteriaFixture.CPH_LHR_WITH_2AD);
    Flights flightsExpected = FlightsFixture.FLIGHTS_CPH_LHR_2AD;
    assertThat("The flight is equals", flights, equalTo(flightsExpected));
  }

  @Test
  public void executeWhenHaveRouteNotExist()
  {
    Flights flights = providerFinder.execute(SearchCriteriaFixture.LHR_ROUTE_NOTE_EXIST_2AD);
    Flights flightsExpected = FlightsFixture.FLIGHTS_ROUTE_NOTE_EXIST_2AD;
    assertThat("The flight is equals", flights, equalTo(flightsExpected));
  }
}
