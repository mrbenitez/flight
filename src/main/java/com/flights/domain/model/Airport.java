package com.flights.domain.model;

import java.util.HashMap;
import java.util.Map;

public enum Airport
{
  MAD("MAD", "Madrid"), BCN("BCN", "Barcelona"), LHR("LHR", "London"), CDG("CDG", "Paris"), FRA("FRA",
      "Frakfurt"), IST("IST", "Istanbul"), AMS("AMS", "Amsterdam"), FCO("FCO", "Rome"), CPH("CPH",
          "Copenhagen"), XXX("XXX", "Unknow");
  private static final Map<String, Airport> AIRPORT_MAP = new HashMap<>();
  private String code;
  private String name;

  private Airport(String code, String name)
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

  public static Airport getAirport(String code)
  {
    return AIRPORT_MAP.get(code);
  }

  static
  {
    for (Airport airport : Airport.values())
    {
      AIRPORT_MAP.put(airport.getCode(), airport);
    }
  }
}
