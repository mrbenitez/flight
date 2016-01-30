package com.flights.domain.rule.passengertype;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.flights.domain.model.PassengerType;

public class PassengerTypeRuleFactoryTest
{
  private PassengerTypeRuleFactory factory = new PassengerTypeRuleFactory();

  @Test
  public void getAdultRule()
  {
    PassengerTypeRule rule = factory.get(PassengerType.ADULT);

    assertThat("The rule is equals", rule, instanceOf(AdultRule.class));
  }

  @Test
  public void getChildRule()
  {
    PassengerTypeRule rule = factory.get(PassengerType.CHILD);

    assertThat("The rule is equals", rule, instanceOf(ChildRule.class));
  }

  @Test
  public void getInfantRule()
  {
    PassengerTypeRule rule = factory.get(PassengerType.INFANT);

    assertThat("The rule is equals", rule, instanceOf(InfantRule.class));
  }
}
