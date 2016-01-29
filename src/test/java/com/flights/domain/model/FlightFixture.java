package com.flights.domain.model;

import com.flights.repository.provider.FlightProviderFixture;

public class FlightFixture
{
  public static final Flight LHR_IST_TK_15DAYS = createFlightFinal(FlightProviderFixture.LHR_IST_TK_15DAYS, 806.0);
  public static final Flight LHR_IST_LH_15DAYS = createFlightFinal(FlightProviderFixture.LHR_IST_LH_15DAYS, 481.192);

  public static final Flight BCN_MAD_U2_2DAYS = createFlightFinal(FlightProviderFixture.BCN_MAD_U2_2DAYS,
                                                                  909.0899999999999);
  public static final Flight BCN_MAD_BA_2DAYS = createFlightFinal(FlightProviderFixture.BCN_MAD_BA_2DAYS,
                                                                  1028.4299999999998);

  private static Flight createFlightFinal(Flight flight, Double totalPrice)
  {
    flight.setTotalPrice(totalPrice);
    return flight;
  }
}
