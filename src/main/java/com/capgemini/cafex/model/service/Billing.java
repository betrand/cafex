package com.capgemini.cafex.model.service;

import com.capgemini.cafex.model.data.MenuItem;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author betrand.ugorji@capgemini.com
 */
public class Billing {

 /**
  *
  * @param list - A String Array of Purchase Items
  * @return the total bill for the purchase Items or 0p if list is Empty
  */
 public static String getBill(String[] list) {
  List<String> items = Arrays.asList(list);

  if (items.isEmpty()) {
   return "0p";
  }

  int pound = 0;
  int pence = 0;

  for (String purchaseItem : items) {
   MenuItem item = getItem(purchaseItem);

   if (item == null) {
    return "Invalid Item";
   }

   pound += item.getPound();
   pence += item.getPence();

   if (pence > 99) {
    pound += pence / 100;
    pence = pence % 100;
   }
  }

  return pound < 1 ? new StringBuilder().append(pence).append("p").toString()
          : new StringBuilder().append("£").append(pound).append(".").append(pence)
          .toString();
 }

 private static MenuItem getItem(String itemName) {
  for (MenuItem item : MenuItem.values()) {
   if ((itemName).equals(item.getItem())) {
    return item;
   }
  }
  return null;
 }

}
