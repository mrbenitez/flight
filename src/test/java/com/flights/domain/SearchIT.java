package com.flights.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.flights.domain.model.Flights;
import com.flights.domain.model.FlightsFixture;
import com.flights.domain.model.SearchCriteriaFixture;

public class SearchIT
{
  private Search search = new Search();

  @Test
  public void searchBcnToMadWith1Ad2ChAnd2DaysAdvance()
  {
    Flights flights = search.search(SearchCriteriaFixture.BCN_MAD_WITH_1AD_2CH_2DAYS);

    verify(flights, FlightsFixture.BCN_MAD_WITH_1AD_2CH_2DAYS);
  }

  @Test
  public void searchLhrToIstdWith2Ad1Ch1InAnd15DaysAdvance()
  {
    Flights flights = search.search(SearchCriteriaFixture.LHR_IST_WITH_2AD_1CH_1IN_15DAYS);

    verify(flights, FlightsFixture.LHR_IST_2AD_1CH_1IN_15_DAYS);
  }

  private void verify(Flights flights, Flights flightsExpected)
  {
    assertThat("The flights are equals", flights, equalTo(flightsExpected));
  }
}
