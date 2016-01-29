package com.flights.domain.ports.secondary;

import com.flights.domain.model.Flights;
import com.flights.domain.model.SearchCriteria;

public interface ProviderRepository
{
  Flights search(SearchCriteria criteria);
}
