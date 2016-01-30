package com.flights.repository.provider;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.flights.domain.model.Flights;
import com.flights.domain.model.SearchCriteriaFixture;

public class ProviderFinderTest
{
  private ProviderFinder providerFinder = new ProviderFinder();

  @Test
  public void executeWhenHaveRouteExist()
  {
    Flights flights = providerFinder.execute(SearchCriteriaFixture.CPH_LHR_WITH_2AD_5DAYS);

    verify(flights, FlightsProviderFixture.CPH_LHR_2AD_2DAYS);
  }

  private void verify(Flights flights, Flights flightsExpected)
  {
    assertThat("The flight is equals", flights, equalTo(flightsExpected));
  }

  @Test
  public void executeWhenHaveRouteNotExist()
  {
    Flights flights = providerFinder.execute(SearchCriteriaFixture.LHR_ROUTE_NOTE_EXIST_2AD_2DAYS);

    verify(flights, FlightsProviderFixture.ROUTE_NOT_EXIST_2AD);
  }
}
