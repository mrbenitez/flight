package com.flights.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.flights.domain.model.Flights;
import com.flights.domain.model.FlightsFixture;
import com.flights.domain.model.SearchCriteriaFixture;
import com.flights.domain.rule.destinationdate.DestinationDateRule;
import com.flights.domain.rule.passengertype.PassengerTypeRuleFactory;
import com.flights.repository.provider.ProviderFinder;
import com.flights.repository.provider.SearchFlightAdapter;

public class SearchAvailableFlightIT
{
  private SearchFlightAdapter searchFlightAdapter = new SearchFlightAdapter(new ProviderFinder());
  private PassengerTypeRuleFactory passengerTypeRuleFactory = new PassengerTypeRuleFactory();
  private DestinationDateRule destinationDateRule = new DestinationDateRule();
  private CalculateTotalPriceFlight calculateTotalPriceFlight = new CalculateTotalPriceFlight(
      passengerTypeRuleFactory, destinationDateRule);
  private SearchAvailableFlight search = new SearchAvailableFlight(searchFlightAdapter,
      calculateTotalPriceFlight);

  @Test
  public void searchBcnToMadWith1Ad2ChAnd2DaysAdvance()
  {
    Flights flights = search.execute(SearchCriteriaFixture.BCN_MAD_WITH_1AD_2CH_2DAYS);

    verify(flights, FlightsFixture.BCN_MAD_WITH_1AD_2CH_2DAYS);
  }

  @Test
  public void searchLhrToIstdWith2Ad1Ch1InAnd15DaysAdvance()
  {
    Flights flights = search.execute(SearchCriteriaFixture.LHR_IST_WITH_2AD_1CH_1IN_15DAYS);

    verify(flights, FlightsFixture.LHR_IST_WITH_2AD_1CH_1IN_15DAYS);
  }

  private void verify(Flights flights, Flights flightsExpected)
  {
    assertThat("The flights are equals", flights, equalTo(flightsExpected));
  }
}
