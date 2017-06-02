package com.capgemini.cafex.model.data;

/**
 *
 * @author betrand.ugorji@capgemini.com
 */
public enum MenuItem {

 COLA("Cola", 0, 50, false),
 COFFEE("Coffee", 1, 0, true),
 CHEESE_SANDWICH("Cheese Sandwich", 2, 0, false);

 private final String item;
 private final int pound;
 private final int pence;
 private final boolean isHot;

 MenuItem(String item, int pound, int pence, boolean isHot) {
  this.item = item;
  this.pound = pound;
  this.pence = pence;
  this.isHot = isHot;
 }

 public String getItem() {
  return item;
 }

 public int getPound() {
  return pound;
 }

 public int getPence() {
  return pence;
 }

 public boolean isHot() {
  return isHot;
 }

 @Override
 public String toString() {
  return this.item;
 }
}
