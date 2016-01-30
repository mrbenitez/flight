package com.flights.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.flights.domain.model.FlightFixture;
import com.flights.domain.model.Flights;
import com.flights.domain.model.FlightsFixture;
import com.flights.domain.model.SearchCriteria;
import com.flights.domain.model.SearchCriteriaFixture;
import com.flights.repository.provider.SearchFlightAdapter;

@RunWith(MockitoJUnitRunner.class)
public class SearchAvailableFlightTest
{
  private SearchCriteria criteria = SearchCriteriaFixture.BCN_MAD_WITH_1AD_2CH_2DAYS;
  @Mock
  private SearchFlightAdapter searchFlightAdapter;
  @Mock
  private CalculateTotalPriceFlight calculateTotalPriceFlight;
  @InjectMocks
  private SearchAvailableFlight search;

  @Test
  public void searchBcnToMadWith1Ad2ChAnd2DaysAdvance()
  {
    Flights flights = search.execute(criteria);

    assertThat("The flights are equals", flights, equalTo(FlightsFixture.BCN_MAD_WITH_1AD_2CH_2DAYS));
  }

  @Before
  public void inicialize()
  {
    when(searchFlightAdapter.search(criteria)).thenReturn(FlightsFixture.BCN_MAD_WITH_1AD_2CH_2DAYS);
    when(calculateTotalPriceFlight.calculate(criteria, FlightFixture.BCN_MAD_BA_WITH_1AD_2CH_2DAYS))
        .thenReturn(FlightFixture.BCN_MAD_BA_WITH_1AD_2CH_2DAYS.getTotalPrice());
    when(calculateTotalPriceFlight.calculate(criteria, FlightFixture.BCN_MAD_U2_WITH_1AD_2CH_2DAYS))
        .thenReturn(FlightFixture.BCN_MAD_U2_WITH_1AD_2CH_2DAYS.getTotalPrice());
  }
}
