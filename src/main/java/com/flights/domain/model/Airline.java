package com.flights.domain.model;

import java.util.HashMap;
import java.util.Map;

public enum Airline
{
  IB("IB", "Iberia"), BA("BA", "British Airways"), LH("LH", "Lufthansa"), FR("FR", "Ryanair"), VY("VY",
      "Vueling"), TK("TK", "Turkish Airlines"), U2("U2", "Easyjet");
  private static final Map<String, Airline> AIRLINE_MAP = new HashMap<>();
  private String code;
  private String name;

  private Airline(String name, String code)
  {
    this.name = name;
    this.code = code;
  }

  public String getName()
  {
    return name;
  }

  public String getCode()
  {
    return code;
  }

  public static Airline getAirline(String code)
  {
    return AIRLINE_MAP.get(code);
  }

  static
  {
    for (Airline airline : Airline.values())
    {
      AIRLINE_MAP.put(airline.getName(), airline);
    }
  }
}
