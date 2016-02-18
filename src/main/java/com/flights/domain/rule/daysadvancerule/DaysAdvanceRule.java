package com.flights.domain.rule.daysadvancerule;

import com.flights.domain.model.MyDate;
import com.flights.domain.model.Price;

public class DaysAdvanceRule
{
  private static final double PERCENTAGE_MORE_30_DAYS_ADVANCE = 0.8;
  private static final double PERCENTAGE_BETWEEN_16_30_DAYS_ADVANCE = 1.0;
  private static final double PERCENTAGE_BETWEEN_3_15_DAYS_ADVANCE = 1.2;
  private static final double PERCENTAGE_LESS_3_DAYS_ADVANCE = 1.5;

  public Price calculatePrice(MyDate today, MyDate departureDate, Price basePrice)
  {
    int diffDays = today.daysBetweenTwoDates(departureDate);
    Double taxPorcentage = PERCENTAGE_LESS_3_DAYS_ADVANCE;
    if (diffDays > 30)
    {
      taxPorcentage = PERCENTAGE_MORE_30_DAYS_ADVANCE;
    }
    else if (diffDays >= 16 && diffDays <= 30)
    {
      taxPorcentage = PERCENTAGE_BETWEEN_16_30_DAYS_ADVANCE;
    }
    else if (diffDays >= 3 && diffDays <= 15)
    {
      taxPorcentage = PERCENTAGE_BETWEEN_3_15_DAYS_ADVANCE;
    }

    return new Price(basePrice.getValue() * taxPorcentage);
  }
}
