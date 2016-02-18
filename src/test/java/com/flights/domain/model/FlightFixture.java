package com.flights.domain.model;

import static com.flights.domain.ConstantsTest.BCN_MAD_IB_BASE_PRICE;
import static com.flights.domain.ConstantsTest.BCN_MAD_IB_WITH_1AD_2CH_2DAYS_TOTAL_PRICE;
import static com.flights.domain.ConstantsTest.BCN_MAD_LH_BASE_PRICE;
import static com.flights.domain.ConstantsTest.BCN_MAD_LH_WITH_1AD_2CH_2DAYS_TOTAL_PRICE;
import static com.flights.domain.ConstantsTest.CPH_LHR_BA_BASE_PRICE;
import static com.flights.domain.ConstantsTest.CPH_LHR_U2_BASE_PRICE;
import static com.flights.domain.ConstantsTest.LHR_IST_LH_BASE_PRICE;
import static com.flights.domain.ConstantsTest.LHR_IST_LH_WITH_2AD_1CH_1IN_15DAYS_TOTAL_PRICE;
import static com.flights.domain.ConstantsTest.LHR_IST_TK_BASE_PRICE;
import static com.flights.domain.ConstantsTest.LHR_IST_TK_WITH_2AD_1CH_1IN_15DAYS_TOTAL_PRICE;
import static com.flights.domain.model.Airline.BA;
import static com.flights.domain.model.Airline.IB;
import static com.flights.domain.model.Airline.LH;
import static com.flights.domain.model.Airline.TK;
import static com.flights.domain.model.Airline.U2;
import static com.flights.domain.model.Airport.BCN;
import static com.flights.domain.model.Airport.CPH;
import static com.flights.domain.model.Airport.IST;
import static com.flights.domain.model.Airport.LHR;
import static com.flights.domain.model.Airport.MAD;

import java.util.Date;

import com.flights.repository.provider.InfantPriceFinder;

public class FlightFixture
{
  public static final Flight BCN_MAD_IB_2DAYS = createFlightProvider(BCN,
                                                                     MAD,
                                                                     BCN_MAD_IB_BASE_PRICE,
                                                                     "IB2171",
                                                                     IB,
                                                                     2);
  public static final Flight BCN_MAD_LH_2DAYS = createFlightProvider(BCN,
                                                                     MAD,
                                                                     BCN_MAD_LH_BASE_PRICE,
                                                                     "LH5496",
                                                                     LH,
                                                                     2);

  public static final Flight CPH_LHR_U2_5DAYS = createFlightProvider(CPH,
                                                                     LHR,
                                                                     CPH_LHR_U2_BASE_PRICE,
                                                                     "U23631",
                                                                     U2,
                                                                     5);
  public static final Flight CPH_LHR_BA_5DAYS = createFlightProvider(CPH,
                                                                     LHR,
                                                                     CPH_LHR_BA_BASE_PRICE,
                                                                     "BA7710",
                                                                     BA,
                                                                     5);

  public static final Flight LHR_IST_TK_15DAYS = createFlightProvider(LHR,
                                                                      IST,
                                                                      LHR_IST_TK_BASE_PRICE,
                                                                      "TK8891",
                                                                      TK,
                                                                      15);
  public static final Flight LHR_IST_LH_15DAYS = createFlightProvider(LHR,
                                                                      IST,
                                                                      LHR_IST_LH_BASE_PRICE,
                                                                      "LH1085",
                                                                      LH,
                                                                      15);

  public static final Flight LHR_IST_TK_WITH_2AD_1CH_1IN_15DAYS = createFlightFinal(LHR_IST_TK_15DAYS,
                                                                                    LHR_IST_TK_WITH_2AD_1CH_1IN_15DAYS_TOTAL_PRICE);
  public static final Flight LHR_IST_LH_WITH_2AD_1CH_1IN_15DAYS = createFlightFinal(LHR_IST_LH_15DAYS,
                                                                                    LHR_IST_LH_WITH_2AD_1CH_1IN_15DAYS_TOTAL_PRICE);

  public static final Flight BCN_MAD_U2_WITH_1AD_2CH_2DAYS = createFlightFinal(BCN_MAD_IB_2DAYS,
                                                                               BCN_MAD_IB_WITH_1AD_2CH_2DAYS_TOTAL_PRICE);
  public static final Flight BCN_MAD_BA_WITH_1AD_2CH_2DAYS = createFlightFinal(BCN_MAD_LH_2DAYS,
                                                                               BCN_MAD_LH_WITH_1AD_2CH_2DAYS_TOTAL_PRICE);

  private static Flight createFlightProvider(Airport origin,
                                             Airport destination,
                                             Price basePrice,
                                             String flightCode,
                                             Airline airline,
                                             int daysAdvance)
  {

    MyDate today = new MyDate(new Date());
    Route route = new Route(origin, destination);
    Flight.Builder builder = new Flight.Builder(route, today.obtainDateWithDaysAdvance(daysAdvance),
        flightCode, basePrice, InfantPriceFinder.obtainPrice(airline), airline.getName());
    return builder.build();
  }

  private static Flight createFlightFinal(Flight flight, Price totalPrice)
  {
    flight.setTotalPrice(totalPrice);
    return flight;
  }
}
