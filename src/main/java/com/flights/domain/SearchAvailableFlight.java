package com.flights.domain;

import java.util.Map;

import com.flights.domain.model.Flight;
import com.flights.domain.model.Flights;
import com.flights.domain.model.PassangerType;
import com.flights.domain.model.SearchCriteria;
import com.flights.domain.rule.destinationdate.DestinationDateRule;
import com.flights.domain.rule.passengertype.PassengerTypeRule;
import com.flights.domain.rule.passengertype.PassengerTypeRuleFactory;
import com.flights.repository.provider.SearchFlightAdapter;

public class SearchAvailableFlight
{
  private SearchFlightAdapter searchFlightAdapter;
  private PassengerTypeRuleFactory passengerTypeRuleFactory;
  private DestinationDateRule destinationDateRule;

  public SearchAvailableFlight(SearchFlightAdapter searchFlightAdapter,
      PassengerTypeRuleFactory passengerTypeRuleFactory,
      DestinationDateRule destinationDateRule)
  {
    this.searchFlightAdapter = searchFlightAdapter;
    this.passengerTypeRuleFactory = passengerTypeRuleFactory;
    this.destinationDateRule = destinationDateRule;
  }

  public Flights execute(SearchCriteria criteria)
  {
    Flights flights = searchFlightAdapter.search(criteria);
    fillTotalPrice(criteria, flights);
    return flights;
  }

  private void fillTotalPrice(SearchCriteria criteria, Flights flights)
  {
    for (Flight flight : flights.getFlights())
    {
      Double departureDatePrice = destinationDateRule.calculatePrice(criteria.getDepartureDate(),
                                                                     flight.getBasePrice());

      Double totalPrice = calculateTotalPriceByAllPassenger(criteria.getPassenger(),
                                                            flight,
                                                            departureDatePrice);

      flight.setTotalPrice(totalPrice);// TODO VER SI USAR OTRO OBJETO price para no devolver ni usar double
    }
  }

  private Double calculateTotalPriceByAllPassenger(Map<PassangerType, Integer> passenger,
                                                   Flight flight,
                                                   Double departureDatePrice)
  {
    Double totalPrice = 0.0;
    for (PassangerType passangerType : passenger.keySet())
    {
      PassengerTypeRule passengerTypeRule = passengerTypeRuleFactory.get(passangerType);
      int numPassenger = extracted(passenger, passangerType);

      Double basePrice = calculateBasePrice(flight, departureDatePrice, passangerType);
      totalPrice += passengerTypeRule.calculatePrice(basePrice, numPassenger);
    }
    return totalPrice;
  }

  private Integer extracted(Map<PassangerType, Integer> passenger, PassangerType passangerType)
  {
    return passenger.get(passangerType);
  }

  private Double calculateBasePrice(Flight flight, Double departureDatePrice, PassangerType passangerType)
  {
    Double basePrice = departureDatePrice;
    basePrice = basePriceWhenIsInfant(flight, passangerType, basePrice);
    return basePrice;
  }

  private Double basePriceWhenIsInfant(Flight flight, PassangerType passangerType, Double basePrice)
  {
    if (PassangerType.INFANT.equals(passangerType))
    {
      basePrice = flight.getInfantPrice();
    }
    return basePrice;
  }
}
