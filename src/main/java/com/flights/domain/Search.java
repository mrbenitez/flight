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

  public Flights search(SearchCriteria criteria)
  {
    Flights flights = searchFlightAdapter.search(criteria);
    PassengerTypeRule passengerTypeRule = null;

    for (Flight flight : flights.getFlights())
    {
      Double totalPrice = 0.0;
      Double departureDatePrice = destinationDateRule.calculatePrice(criteria.getDepartureDate(),
                                                                     flight.getBasePrice());

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

      flight.setTotalPrice(totalPrice);// TODO VER SI USAR OTRO OBJETO
    }

    return flights;
  }
}
