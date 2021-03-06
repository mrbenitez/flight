package com.flights.repository.provider;

import com.flights.domain.model.Flights;
import com.flights.domain.model.SearchCriteria;
import com.flights.domain.ports.secondary.ProviderRepository;

// REV Responsibility
/*
This class does nothing, only it delegates to the providerFinder.
 */
public class SearchFlightsAdapter implements ProviderRepository
{
  private ProviderFinder providerFinder;

  public SearchFlightsAdapter(ProviderFinder providerFinder)
  {
    this.providerFinder = providerFinder;
  }

  public Flights search(SearchCriteria criteria)
  {
    return providerFinder.execute(criteria);
  }
}
