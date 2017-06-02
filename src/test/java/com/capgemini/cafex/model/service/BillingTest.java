package com.capgemini.cafex.model.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author betrand.ugorji@capgemini.com
 */
public class BillingTest {

 /**
  * Testing that an empty String list returns Zero
  *
  */
 @Test
 public void testGetBillEmptyList() {
  String[] purchaseItems = new String[0];
  String expResult = "0p";
  String result = Billing.getBill(purchaseItems);
  assertEquals(expResult, result);
 }

 /**
  * Testing that a String list containing an Unknown Item returns Invalid Item
  *
  */
 @Test
 public void testGetStandardBillForUnknownItem() {
  String[] purchaseItems = {"Red Bull"};
  String expResult = "Invalid Item";
  String result = Billing.getBill(purchaseItems);
  assertEquals(expResult, result);
 }

 /**
  * Test that passing multiple Items to the getBill Method calculates and
  * returns correct Total Bill £1.50.
  *
  */
 @Test
 public void testGetStandardBill_() {
  String[] purchaseItems = {"Cola", "Coffee"};
  String expResult = "£1.50";
  String result = Billing.getBill(purchaseItems);
  assertEquals(expResult, result);
 }

 /**
  * Test that passing more Items to the getBill Method calculates and returns
  * correct Total Bill £3.50.
  *
  */
 @Test
 public void testGetStandardBill() {
  String[] purchaseItems = {"Cola", "Coffee", "Cheese Sandwich"};
  String expResult = "£3.50";
  String result = Billing.getBill(purchaseItems);
  assertEquals(expResult, result);
 }
}
