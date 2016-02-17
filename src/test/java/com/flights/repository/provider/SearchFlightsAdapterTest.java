package com.flights.repository.provider;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.flights.domain.model.FlightsFixture;
import com.flights.domain.model.SearchCriteria;
import com.flights.domain.model.SearchCriteriaFixture;

@RunWith(MockitoJUnitRunner.class)
public class SearchFlightsAdapterTest
{
  @Mock
  private ProviderFinder providerFinder;
  @InjectMocks
  private SearchFlightsAdapter searchFlightsAdapter;

  @Test
  public void search()
  {
    SearchCriteria criteria = SearchCriteriaFixture.CPH_LHR_WITH_2AD_5DAYS;
    when(providerFinder.execute(criteria)).thenReturn(FlightsFixture.CPH_LHR_2AD_5DAYS);

    searchFlightsAdapter.search(criteria);

    verify(providerFinder).execute(criteria);
  }
}
