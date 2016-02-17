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

import com.flights.domain.model.FlightFixture;
import com.flights.domain.model.PassengerType;
import com.flights.domain.model.Price;
import com.flights.domain.model.SearchCriteria;
import com.flights.domain.model.SearchCriteriaFixture;
import com.flights.domain.rule.destinationdate.DestinationDateRule;
import com.flights.domain.rule.passengertype.AdultRule;
import com.flights.domain.rule.passengertype.ChildRule;
import com.flights.domain.rule.passengertype.PassengerTypeRule;
import com.flights.domain.rule.passengertype.PassengerTypeRuleFactory;

@RunWith(MockitoJUnitRunner.class)
public class CalculateTotalPriceFlightTest
{
  @Mock
  private DestinationDateRule destinationDateRule;
  @Mock
  private PassengerTypeRuleFactory passengerTypeRuleFactory;
  @InjectMocks
  private CalculateTotalPriceFlight calculateTotalPriceFlight;

  @Test
  public void calculateWhenBAFromBcnToMad1Ad2ChAnd2DaysAdvance()
  {
    SearchCriteria criteria = SearchCriteriaFixture.BCN_MAD_WITH_1AD_2CH_2DAYS;
    inizializeDestinationDateRule(criteria.getDepartureDate(), new Price(259.0), new Price(388.5));
    inizializeDestinationDateRule(criteria.getDepartureDate(), new Price(293.0), new Price(439.5));
    inicializePassengerTypeRuleFactory(PassengerType.ADULT, new AdultRule());
    inicializePassengerTypeRuleFactory(PassengerType.CHILD, new ChildRule());

    Price totalPrice = calculateTotalPriceFlight.calculate(criteria, FlightFixture.BCN_MAD_LH_2DAYS);

    assertThat("The flights are equals",
               totalPrice,
               equalTo(FlightFixture.BCN_MAD_BA_WITH_1AD_2CH_2DAYS.getTotalPrice()));
  }

  private void inicializePassengerTypeRuleFactory(PassengerType passangerType, PassengerTypeRule rule)
  {
    when(passengerTypeRuleFactory.get(passangerType)).thenReturn(rule);
  }

  private void inizializeDestinationDateRule(Date departureDate, Price basePrice, Price totalPrice)
  {
    when(destinationDateRule.calculatePrice(departureDate, basePrice)).thenReturn(totalPrice);
  }
}
