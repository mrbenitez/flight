package com.flights.domain.rule.passengertype;

import java.util.HashMap;
import java.util.Map;

import com.flights.domain.model.PassangerType;

public class PassengerTypeRuleFactory
{
  private Map<PassangerType, PassengerTypeRule> rules = new HashMap<PassangerType, PassengerTypeRule>();

  public PassengerTypeRuleFactory()
  {
    rules.put(PassangerType.ADULT, new AdultRule());
    rules.put(PassangerType.CHILD, new ChildRule());
    rules.put(PassangerType.INFANT, new InfantRule());
  }

  public PassengerTypeRule get(PassangerType passangerType)
  {
    return rules.get(passangerType);
  }
}
