package com.flights.domain.rule.passengertype;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.flights.domain.model.PassangerType;

public class PassengerRuleFactoryTest
{
  private PassengerTypeRuleFactory factory = new PassengerTypeRuleFactory();

  @Test
  public void getAdultsRule()
  {
    PassengerTypeRule adultRule = factory.get(PassangerType.ADULT);

    assertThat("The flight is equals", adultRule, instanceOf(AdultRule.class));
  }
}
