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
    Flights flights = providerFinder.execute(SearchCriteriaFixture.CPH_LHR_WITH_2AD_5DAYS);

    assertFlights(flights, FlightsFixture.CPH_LHR_2AD_5DAYS);
  }

  @Test
  public void executeWhenHaveRouteNotExist()
  {
    Flights flights = providerFinder.execute(SearchCriteriaFixture.XXX_LHR_2AD_2DAYS);

    assertFlights(flights, FlightsFixture.ROUTE_NOT_EXIST);
  }

  private void assertFlights(Flights flights, Flights flightsExpected)
  {
    assertThat("The flights is equals", flights, equalTo(flightsExpected));
  }
}
