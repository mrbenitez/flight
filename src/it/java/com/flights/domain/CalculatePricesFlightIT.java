package com.flights.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

import com.flights.domain.model.FlightFixture;
import com.flights.domain.model.MyDate;
import com.flights.domain.model.Price;
import com.flights.domain.model.SearchCriteriaFixture;
import com.flights.domain.rule.daysadvancerule.DaysAdvanceRule;
import com.flights.domain.rule.destinationdaterule.DestinationDateRule;
import com.flights.domain.rule.passengertype.PassengerTypeRuleFactory;

public class CalculatePricesFlightIT
{
  private PassengerTypeRuleFactory passengerTypeRuleFactory = new PassengerTypeRuleFactory();
  private DaysAdvanceRule daysAdvanceRule = new DaysAdvanceRule();
  private DestinationDateRule destinationDateRule = new DestinationDateRule();
  private CalculatePricesFlight calculatePricesFlight = new CalculatePricesFlight(
      passengerTypeRuleFactory, daysAdvanceRule, destinationDateRule);
  private MyDate today = new MyDate(new Date());

  @Test
  public void searchBcnToMadWith1Ad2ChAnd2DaysAdvance()
  {
    Price totalPrice = calculatePricesFlight.calculate(SearchCriteriaFixture.BCN_MAD_WITH_1AD_2CH_2DAYS,
                                                       FlightFixture.BCN_MAD_LH_2DAYS,
                                                       today);

    assertThat("The price is equals",
               totalPrice,
               equalTo(FlightFixture.BCN_MAD_BA_WITH_1AD_2CH_2DAYS.getTotalPrice()));
  }

  @Test
  public void searchLhrToIstdWith2Ad1Ch1InAnd15DaysAdvance()
  {
    Price totalPrice = calculatePricesFlight
        .calculate(SearchCriteriaFixture.LHR_IST_WITH_2AD_1CH_1IN_15DAYS,
                   FlightFixture.LHR_IST_LH_15DAYS,
                   today);

    assertThat("The price is equals",
               totalPrice,
               equalTo(FlightFixture.LHR_IST_LH_WITH_2AD_1CH_1IN_15DAYS.getTotalPrice()));
  }
}
