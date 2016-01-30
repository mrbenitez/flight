package com.flights.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.flights.domain.model.Flights;
import com.flights.domain.model.FlightsFixture;
import com.flights.domain.model.PassangerType;
import com.flights.domain.model.SearchCriteria;
import com.flights.domain.model.SearchCriteriaFixture;
import com.flights.domain.rule.destinationdate.DestinationDateRule;
import com.flights.domain.rule.passengertype.AdultRule;
import com.flights.domain.rule.passengertype.ChildRule;
import com.flights.domain.rule.passengertype.PassengerTypeRule;
import com.flights.domain.rule.passengertype.PassengerTypeRuleFactory;
import com.flights.repository.provider.SearchFlightAdapter;

@RunWith(MockitoJUnitRunner.class)
public class SearchAvailableFlightTest
{
  @Mock
  private SearchFlightAdapter searchFlightAdapter;
  @Mock
  private PassengerTypeRuleFactory passengerTypeRuleFactory;
  @Mock
  private DestinationDateRule destinationDateRule;
  @InjectMocks
  private SearchAvailableFlight search;

  @Test
  public void searchBcnToMadWith1Ad2ChAnd2DaysAdvance()
  {
    SearchCriteria criteria = SearchCriteriaFixture.BCN_MAD_WITH_1AD_2CH_2DAYS;
    inicialize(criteria);

    Flights flights = search.execute(criteria);

    verify(flights, FlightsFixture.BCN_MAD_WITH_1AD_2CH_2DAYS);
  }

  private void inicialize(SearchCriteria criteria)
  {
    when(searchFlightAdapter.search(criteria)).thenReturn(FlightsFixture.BCN_MAD_WITH_1AD_2CH_2DAYS);
    inizializeDestinationDateRule(criteria.getDepartureDate(), 259.0, 388.5);
    inizializeDestinationDateRule(criteria.getDepartureDate(), 293.0, 439.5);
    inicializePassengerTypeRuleFactory(PassangerType.ADULT, new AdultRule());
    inicializePassengerTypeRuleFactory(PassangerType.CHILD, new ChildRule());
  }

  private void inicializePassengerTypeRuleFactory(PassangerType passangerType, PassengerTypeRule rule)
  {
    when(passengerTypeRuleFactory.get(passangerType)).thenReturn(rule);
  }

  private void inizializeDestinationDateRule(Date departureDate, Double basePrice, Double totalPrice)
  {
    when(destinationDateRule.calculatePrice(departureDate, basePrice)).thenReturn(totalPrice);
  }

  private void verify(Flights flights, Flights flightsExpected)
  {
    assertThat("The flights are equals", flights, equalTo(flightsExpected));
  }
}
