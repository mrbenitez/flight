package com.flights.domain.model;

public class Price
{
  private Double value;

  public Price(Double value)
  {
    this.value = Math.round(value * 100) / 100D;
  }

  public Double getValue()
  {
    return value;
  }

  @Override
  public String toString()
  {
    return "Price [value=" + value + "]";
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }
    if (obj == null)
    {
      return false;
    }
    if (getClass() != obj.getClass())
    {
      return false;
    }
    Price other = (Price) obj;
    if (value == null)
    {
      if (other.value != null)
      {
        return false;
      }
    }
    else if (!value.equals(other.value))
    {
      return false;
    }
    return true;
  }

}
