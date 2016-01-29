package com.flights.repository.provider;

import com.flights.domain.model.Flights;
import com.flights.domain.model.SearchCriteria;
import com.flights.domain.ports.secondary.ProviderRepository;

public class SearchFlightAdapter implements ProviderRepository
{
  private ProviderFinder providerFinder = new ProviderFinder();

  public Flights search(SearchCriteria criteria)
  {
    return providerFinder.execute(criteria);
  }
}
