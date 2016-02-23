package com.flights.repository.provider;

import java.util.HashMap;
import java.util.Map;

import com.flights.domain.model.Airline;
import com.flights.domain.model.Price;

public class InfantPriceFinder
{
  // REV Naming
  /*
  Hungarian notation. Don't encode the variable type in the variable name.
   */
  private static Map<Airline, Double> infantPriceMap = new HashMap<>();

  static
  {
    infantPriceMap.put(Airline.IB, 10.0);
    infantPriceMap.put(Airline.BA, 15.0);
    infantPriceMap.put(Airline.LH, 7.0);
    infantPriceMap.put(Airline.FR, 20.0);
    infantPriceMap.put(Airline.VY, 10.0);
    infantPriceMap.put(Airline.TK, 5.0);
    infantPriceMap.put(Airline.U2, 19.9);
  }

  public static Price obtainPrice(Airline airline)
  {
    Double price = 0.0;
    if (infantPriceMap.containsKey(airline))
    {
      price = infantPriceMap.get(airline);
    }
    return new Price(price);
  }
}
