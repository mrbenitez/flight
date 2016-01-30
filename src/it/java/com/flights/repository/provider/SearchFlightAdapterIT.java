package com.flights.repository.provider;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.flights.domain.model.Flights;
import com.flights.domain.model.FlightsFixture;
import com.flights.domain.model.SearchCriteria;
import com.flights.domain.model.SearchCriteriaFixture;

public class SearchFlightAdapterIT
{
  private SearchFlightAdapter searchFlightAdapter = new SearchFlightAdapter(new ProviderFinder());

  @Test
  public void searchCphToLhrWith2AdAnd2DaysAdvacne()
  {
    SearchCriteria criteria = SearchCriteriaFixture.CPH_LHR_WITH_2AD_5DAYS;

    Flights flights = searchFlightAdapter.search(criteria);

    assertThat("The flights are equals", flights, equalTo(FlightsFixture.CPH_LHR_2AD_5DAYS));
  }
}
