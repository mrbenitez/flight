package com.flights.domain.rule.passengertype;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.flights.domain.model.PassangerType;

public class PassengerRuleFactoryTest
{
  private PassengerTypeRuleFactory factory = new PassengerTypeRuleFactory();

  @Test
  public void getAdultRule()
  {
    PassengerTypeRule rule = factory.get(PassangerType.ADULT);

    assertThat("The flight is equals", rule, instanceOf(AdultRule.class));
  }

  @Test
  public void getChildRule()
  {
    PassengerTypeRule rule = factory.get(PassangerType.CHILD);

    assertThat("The flight is equals", rule, instanceOf(ChildRule.class));
  }

  @Test
  public void getInfantRule()
  {
    PassengerTypeRule rule = factory.get(PassangerType.INFANT);

    assertThat("The flight is equals", rule, instanceOf(InfantRule.class));
  }
}
