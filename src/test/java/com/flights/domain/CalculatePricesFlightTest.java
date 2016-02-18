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
import com.flights.domain.model.MyDate;
import com.flights.domain.model.PassengerType;
import com.flights.domain.model.Price;
import com.flights.domain.model.SearchCriteria;
import com.flights.domain.model.SearchCriteriaFixture;
import com.flights.domain.rule.daysadvancerule.DaysAdvanceRule;
import com.flights.domain.rule.destinationdaterule.DestinationDateRule;
import com.flights.domain.rule.passengertype.PassengerTypeRule;
import com.flights.domain.rule.passengertype.PassengerTypeRuleFactory;

@RunWith(MockitoJUnitRunner.class)
public class CalculatePricesFlightTest
{
  private SearchCriteria criteria = SearchCriteriaFixture.LHR_IST_WITH_2AD_1CH_1IN_15DAYS;
  private Price dateBasePrice = new Price(177.6);
  private Price destinationDatePrice = new Price(204.24);
  private Price infantPrice = new Price(7.0);
  private Price adultTotalPrice = new Price(408.48);
  private Price childTotalPrice = new Price(136.84);
  private Price infantTotalPrice = new Price(7.0);
  private MyDate today = new MyDate(new Date());
  @Mock
  private PassengerTypeRule adultRule;
  @Mock
  private PassengerTypeRule childRule;
  @Mock
  private PassengerTypeRule infantRule;
  @Mock
  private DaysAdvanceRule daysAdvanceRule;
  @Mock
  private DestinationDateRule destinationDateRule;
  @Mock
  private PassengerTypeRuleFactory passengerTypeRuleFactory;
  @InjectMocks
  private CalculatePricesFlight calculatePricesFlight;

  @Test
  public void calculateWhenLHFromLhrToIst2Ad1Ch1InAnd15DaysAdvance()
  {
    createScenario();

    Price totalPrice = calculatePricesFlight.calculate(criteria,
                                                       FlightFixture.LHR_IST_LH_15DAYS,
                                                       today);

    assertThat("The flights are equals",
               totalPrice,
               equalTo(FlightFixture.LHR_IST_LH_WITH_2AD_1CH_1IN_15DAYS.getTotalPrice()));
  }

  private void createScenario()
  {
    inicializePassengerType(adultRule, destinationDatePrice, 2, adultTotalPrice);
    inicializePassengerType(childRule, destinationDatePrice, 1, childTotalPrice);
    inicializePassengerType(infantRule, infantPrice, 1, infantTotalPrice);
    inicializePassengerTypeRuleFactory(PassengerType.ADULT, adultRule);
    inicializePassengerTypeRuleFactory(PassengerType.CHILD, childRule);
    inicializePassengerTypeRuleFactory(PassengerType.INFANT, infantRule);
    inizializeDestinationDateRule(criteria.getDepartureDate(),
                                  FlightFixture.LHR_IST_LH_15DAYS.getBasePrice(),
                                  dateBasePrice);

    when(destinationDateRule.calculatePrice(dateBasePrice, criteria.getDepartureDate()))
        .thenReturn(destinationDatePrice);

  }

  private void inicializePassengerTypeRuleFactory(PassengerType passangerType, PassengerTypeRule rule)
  {
    when(passengerTypeRuleFactory.get(passangerType)).thenReturn(rule);
  }

  private void inizializeDestinationDateRule(MyDate departureDate, Price basePrice, Price totalPrice)
  {
    when(daysAdvanceRule.calculatePrice(today, departureDate, basePrice)).thenReturn(totalPrice);
  }

  private void inicializePassengerType(PassengerTypeRule rule,
                                       Price basePrice,
                                       Integer numberPassenger,
                                       Price totalPrice)
  {
    when(rule.calculatePrice(basePrice, numberPassenger)).thenReturn(totalPrice);
  }
}
