package com.flights.domain.model;

import java.util.HashMap;
import java.util.Map;

public enum Airport
{
  MAD("MAD", "Madrid"), BCN("BCN", "Barcelona"), LHR("LHR", "London"), CDG("CDG", "Paris"), FRA("FRA",
      "Frakfurt"), IST("IST", "Istanbul"), AMS("AMS", "Amsterdam"), FCO("FCO", "Rome"), CPH("CPH",
          "Copenhagen"), XXX("XXX", "Unknow");
  private static final Map<String, Airport> AIRPORT_MAP = new HashMap<>();
  // REV Duplication
  /*
  Enum value is already a code.
   */
  private String iata;
  private String name;

  private Airport(String iata, String name)
  {
    this.name = name;
    this.iata = iata;
  }

  public String getName()
  {
    return name;
  }

  public String getIata()
  {
    return iata;
  }

  public static Airport getAirport(String iata)
  {
    return AIRPORT_MAP.get(iata);
  }

  static
  {
    for (Airport airport : Airport.values())
    {
      AIRPORT_MAP.put(airport.getIata(), airport);
    }
  }
}
