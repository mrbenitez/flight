package com.flights.repository.provider;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.flights.domain.model.SearchCriteria;
import com.flights.domain.model.SearchCriteriaFixture;

@RunWith(MockitoJUnitRunner.class)
public class SearchFlightAdapterTest
{
  @Mock
  private ProviderFinder providerFinder;
  @InjectMocks
  private SearchFlightAdapter searchFlightAdapter;

  @Test
  public void search()
  {
    SearchCriteria criteria = SearchCriteriaFixture.CPH_LHR_WITH_2AD_5DAYS;
    when(providerFinder.execute(criteria)).thenReturn(FlightsProviderFixture.CPH_LHR_2AD_2DAYS);

    searchFlightAdapter.search(criteria);

    verify(providerFinder).execute(criteria);
  }
}
