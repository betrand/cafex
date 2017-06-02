package com.capgemini.cafex.model.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author betrand.ugorji@capgemini.com
 */
public class Amount {

 private int pound;
 private int pence;

 private static final String FOOD_SERVICE_CHARGE = "0.10";
 private static final String HOT_FOOD_SERVICE_CHARGE = "0.20";
 private static final int MAX_HOT_FOOD_SERVICE_CHARGE = 20;

 public Amount(int pound, int pence) {
  this.pound = pound;
  this.pence = pence;
 }

 public int getPound() {
  return pound;
 }

 public int getPence() {
  return pence;
 }

 public Amount plus(int pound, int pence) {
  this.pound += pound;
  this.pence += pence;

  if (this.pence > 99) {
   this.pound += this.pence / 100;
   this.pence = this.pence % 100;
  }
  return this;
 }

 private String amount() {
  String amt = new StringBuilder().append(pound).append(".").append(pence).toString();
  return amt;
 }

 public Amount getFoodServiceCharge() {
  BigDecimal total = new BigDecimal(amount());
  total = total.add(total.multiply(new BigDecimal(FOOD_SERVICE_CHARGE))
          .setScale(2, RoundingMode.HALF_EVEN));
  format(total.toPlainString());
  return this;
 }

 public Amount getHotFoodServiceCharge() {
  BigDecimal total = new BigDecimal(amount());
  BigDecimal totalServiceCharge = total.add(total.multiply(new BigDecimal(HOT_FOOD_SERVICE_CHARGE))
          .setScale(2, RoundingMode.HALF_EVEN));

  if (new BigDecimal(MAX_HOT_FOOD_SERVICE_CHARGE).compareTo(totalServiceCharge) < 1) {
   totalServiceCharge = total.add(new BigDecimal(MAX_HOT_FOOD_SERVICE_CHARGE))
           .setScale(2, RoundingMode.HALF_EVEN);
  }
  format(totalServiceCharge.toPlainString());
  return this;
 }

 private void format(String serviceCharge) throws NumberFormatException {
  this.pound = Integer.parseInt(serviceCharge.substring(0, serviceCharge.indexOf(".")));
  this.pence = Integer.parseInt(serviceCharge.substring(serviceCharge.indexOf(".") + 1, serviceCharge.length()));
 }

 public String toMoney() {
  return pound < 1 ? new StringBuilder().append(pence).append("p").toString()
          : new StringBuilder().append("£").append(pound).append(".").append(pence)
          .toString();
 }

}
