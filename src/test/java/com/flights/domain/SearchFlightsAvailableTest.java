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
import com.flights.repository.provider.SearchFlightsAdapter;

@RunWith(MockitoJUnitRunner.class)
public class SearchFlightsAvailableTest
{
  private SearchCriteria criteria = SearchCriteriaFixture.BCN_MAD_WITH_1AD_2CH_2DAYS;
  @Mock
  private SearchFlightsAdapter searchFlightsAdapter;
  @Mock
  private CalculatePricesFlight calculatePricesFlight;
  @InjectMocks
  private SearchFlightsAvailable search;

  // REV Test on a wrong detail level
  /*
  You just test this sequence:
  - find all flights
  - for each flight, calculate a price
  You don't care about origin/destination, number of passengers etc. You only verify if your class passes correct messages to collaborators.
  */
  @Test
  public void searchBcnToMadWith1Ad2ChAnd2DaysAdvance()
  {
    Flights flights = search.execute(criteria);

    // REV misleading assertion message
    assertThat("The flights are equals", flights, equalTo(FlightsFixture.BCN_MAD_WITH_1AD_2CH_2DAYS));
  }

  // REV Typo
  @Before
  public void inicialize()
  {
    when(searchFlightsAdapter.search(criteria)).thenReturn(FlightsFixture.BCN_MAD_WITH_1AD_2CH_2DAYS);
    when(calculatePricesFlight.calculate(criteria, FlightFixture.BCN_MAD_BA_WITH_1AD_2CH_2DAYS))
        .thenReturn(FlightFixture.BCN_MAD_BA_WITH_1AD_2CH_2DAYS.getTotalPrice());
    when(calculatePricesFlight.calculate(criteria, FlightFixture.BCN_MAD_U2_WITH_1AD_2CH_2DAYS))
        .thenReturn(FlightFixture.BCN_MAD_U2_WITH_1AD_2CH_2DAYS.getTotalPrice());
  }
}
