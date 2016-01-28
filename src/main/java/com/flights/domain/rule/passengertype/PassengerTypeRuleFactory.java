package com.flights.domain.rule.passengertype;

import java.util.HashMap;
import java.util.Map;

import com.flights.domain.PassangerType;
import com.flights.domain.exception.PassengerTypeException;

public class PassengerTypeRuleFactory
{
  private static final Map<PassangerType, PassengerTypeRule> RULE = new HashMap<PassangerType, PassengerTypeRule>();

  public PassengerTypeRule obtain(PassangerType passangerType)
  {
    if (!RULE.containsKey(passangerType))
    {
      throw new PassengerTypeException();
    }

    return RULE.get(passangerType);
  }
}
