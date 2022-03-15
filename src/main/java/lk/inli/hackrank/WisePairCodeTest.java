package lk.inli.hackrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.*;

class CurrencyComb {
  String fromCurr;
  String toCurr;

  public CurrencyComb(String fromCurr, String toCurr) {
    this.fromCurr = fromCurr;
    this.toCurr = toCurr;
  }
}

interface RateService {
  /** This method should return an exchange rate for two currencies.
   Examples:
   EUR -> GBP == 0.8803456
   GBP -> EUR == 1.14
   GBP -> USD == 1.23
   We pay 0.01 USD for each rate call, and it has 98 % availability.
   */
  BigDecimal getRate(String curr1, String curr2); // enum as well
}


/**
 This is a backend service that should serve TW customers.
 Customer should see what we they'll get if they convert their amount of money to given currency.
 Example:
 Given 100 USD we will get 81.37 GBP.
 This service method is called from outside 1000/sec.
 We would like to be highly available here and service majority of the customers in less than 100 ms.
 */
class CurrencyConverter {
  RateService rateService;  // Injected
  Map<CurrencyComb, BigDecimal> rateMap = new ConcurrentHashMap<>();

  public BigDecimal convert(BigDecimal amount, String fromCurr, String toCurr)  { // enum as well
    CurrencyComb currComb = new CurrencyComb(fromCurr, toCurr);

    //first get the rate

    BigDecimal rate = rateMap.get(currComb);

    if (null == rate) {
      rate = this.rateService.getRate(fromCurr, toCurr);

      //cache the rate for later serve
      this.rateMap.put(currComb, rate);
    }

    //calculate the new amount
    BigDecimal convetedAmount = amount.multiply(rate);

    return convetedAmount;
  }
}