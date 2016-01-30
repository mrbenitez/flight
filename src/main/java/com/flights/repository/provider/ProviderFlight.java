package com.flights.repository.provider;

public class ProviderFlight
{
  private String origin;
  private String destination;
  private String flightCode;
  private Double basePrice;

  public ProviderFlight(String origin, String destination, String flightCode, Double basePrice)
  {
    this.origin = origin;
    this.destination = destination;
    this.flightCode = flightCode;
    this.basePrice = basePrice;
  }

  public String getOrigin()
  {
    return origin;
  }

  public String getDestination()
  {
    return destination;
  }

  public String getFlightCode()
  {
    return flightCode;
  }

  public Double getBasePrice()
  {
    return basePrice;
  }
}
