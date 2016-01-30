package com.flights.domain;

import com.flights.domain.model.Flight;
import com.flights.domain.model.Flights;
import com.flights.domain.model.PassangerType;
import com.flights.domain.model.SearchCriteria;
import com.flights.domain.rule.destinationdate.DestinationDateRule;
import com.flights.domain.rule.passengertype.PassengerTypeRule;
import com.flights.domain.rule.passengertype.PassengerTypeRuleFactory;
import com.flights.repository.provider.ProviderFinder;
import com.flights.repository.provider.SearchFlightAdapter;

public class Search
{
  private SearchFlightAdapter searchFlightAdapter = new SearchFlightAdapter(new ProviderFinder());
  private PassengerTypeRuleFactory passengerTypeRuleFactory = new PassengerTypeRuleFactory();
  private DestinationDateRule destinationDateRule = new DestinationDateRule();

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
      Double totalPrice = 0.0;
      Double departureDatePrice = destinationDateRule.calculatePrice(criteria.getDepartureDate(),
                                                                     flight.getBasePrice());

      totalPrice = calculatePriceByAllPassenger(criteria, flight, totalPrice, departureDatePrice);

      flight.setTotalPrice(totalPrice);// TODO VER SI USAR OTRO OBJETO price para no devolver ni usar double
    }
  }

  private Double calculatePriceByAllPassenger(SearchCriteria criteria,
                                              Flight flight,
                                              Double totalPrice,
                                              Double departureDatePrice)
  {
    PassengerTypeRule passengerTypeRule;
    for (PassangerType passangerType : criteria.getPassenger().keySet())
    {
      passengerTypeRule = passengerTypeRuleFactory.get(passangerType);
      int numPassenger = criteria.getPassenger().get(passangerType);

      if (PassangerType.INFANT.equals(passangerType))
      {
        totalPrice += passengerTypeRule.calculatePrice(flight.getInfantPrice(), numPassenger);
      }
      else
      {
        totalPrice += passengerTypeRule.calculatePrice(departureDatePrice, numPassenger);
      }
    }
    return totalPrice;
  }
}