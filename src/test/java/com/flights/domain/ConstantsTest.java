package com.flights.domain;

import com.flights.domain.model.Price;

// REV Naming
/*
Does this class tests some constants? Or is a fixture for prices?
 */
public class ConstantsTest
{
  public static final Price BCN_MAD_IB_BASE_PRICE = new Price(259.0);
  public static final Price BCN_MAD_LH_BASE_PRICE = new Price(293.0);
  public static final Price BCN_MAD_IB_WITH_1AD_2CH_2DAYS_TOTAL_PRICE = new Price(909.09);
  public static final Price BCN_MAD_LH_WITH_1AD_2CH_2DAYS_TOTAL_PRICE = new Price(1028.43);

  public static final Price CPH_LHR_U2_BASE_PRICE = new Price(152.0);
  public static final Price CPH_LHR_BA_BASE_PRICE = new Price(138.0);

  public static final Price LHR_IST_TK_BASE_PRICE = new Price(250.0);
  public static final Price LHR_IST_LH_BASE_PRICE = new Price(148.0);
  public static final Price LHR_IST_TK_WITH_2AD_1CH_1IN_15DAYS_TOTAL_PRICE = new Price(806.0);
  public static final Price LHR_IST_LH_WITH_2AD_1CH_1IN_15DAYS_TOTAL_PRICE = new Price(481.19);
}
