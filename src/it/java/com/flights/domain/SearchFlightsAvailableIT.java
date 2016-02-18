package com.flights.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.flights.domain.model.Flights;
import com.flights.domain.model.FlightsFixture;
import com.flights.domain.model.SearchCriteriaFixture;
import com.flights.domain.rule.daysadvancerule.DaysAdvanceRule;
import com.flights.domain.rule.destinationdaterule.DestinationDateRule;
import com.flights.domain.rule.passengertype.PassengerTypeRuleFactory;
import com.flights.repository.provider.ProviderFinder;
import com.flights.repository.provider.SearchFlightsAdapter;

public class SearchFlightsAvailableIT
{
  private SearchFlightsAdapter searchFlightsAdapter = new SearchFlightsAdapter(new ProviderFinder());
  private CalculatePricesFlight calculatePricesFlight = new CalculatePricesFlight(
      new PassengerTypeRuleFactory(), new DaysAdvanceRule(), new DestinationDateRule());
  private SearchFlightsAvailable search = new SearchFlightsAvailable(searchFlightsAdapter,
      calculatePricesFlight);

  @Test
  public void searchBcnToMadWith1Ad2ChAnd2DaysAdvance()
  {
    Flights flights = search.execute(SearchCriteriaFixture.BCN_MAD_WITH_1AD_2CH_2DAYS);

    assertFlights(flights, FlightsFixture.BCN_MAD_WITH_1AD_2CH_2DAYS);
  }

  @Test
  public void searchLhrToIstdWith2Ad1Ch1InAnd15DaysAdvance()
  {
    Flights flights = search.execute(SearchCriteriaFixture.LHR_IST_WITH_2AD_1CH_1IN_15DAYS);

    assertFlights(flights, FlightsFixture.LHR_IST_WITH_2AD_1CH_1IN_15DAYS);
  }

  @Test
  public void searchRouteNotExist()
  {
    Flights flights = search.execute(SearchCriteriaFixture.XXX_LHR_2AD_2DAYS);

    assertFlights(flights, FlightsFixture.ROUTE_NOT_EXIST);
  }

  private void assertFlights(Flights flights, Flights flightsExpected)
  {
    assertThat("The flights are equals", flights, equalTo(flightsExpected));
  }
}
