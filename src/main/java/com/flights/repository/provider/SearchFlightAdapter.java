package com.flights.repository.provider;

import com.flights.domain.model.Flights;
import com.flights.domain.model.SearchCriteria;
import com.flights.domain.ports.secondary.ProviderRepository;

public class SearchFlightAdapter implements ProviderRepository
{
  private ProviderFinder providerFinder;

  public SearchFlightAdapter(ProviderFinder providerFinder)
  {
    this.providerFinder = providerFinder;
  }

  public Flights search(SearchCriteria criteria)
  {
    return providerFinder.execute(criteria);
  }
}
