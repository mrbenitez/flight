package com.flights.domain.rule.passengertype;

import java.util.HashMap;
import java.util.Map;

import com.flights.domain.model.PassengerType;

public class PassengerTypeRuleFactory
{
  private Map<PassengerType, PassengerTypeRule> rules = new HashMap<PassengerType, PassengerTypeRule>();

  public PassengerTypeRuleFactory()
  {
    rules.put(PassengerType.ADULT, new AdultRule());
    rules.put(PassengerType.CHILD, new ChildRule());
    rules.put(PassengerType.INFANT, new InfantRule());
  }

  public PassengerTypeRule get(PassengerType passangerType)
  {
    return rules.get(passangerType);
  }
}
