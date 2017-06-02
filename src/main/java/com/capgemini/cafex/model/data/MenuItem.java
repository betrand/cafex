package com.capgemini.cafex.model.data;

/**
 *
 * @author betrand.ugorji@capgemini.com
 */
public enum MenuItem {

 COLA("Cola", 0, 50, false, false),
 COFFEE("Coffee", 1, 0, true, false),
 CHEESE_SANDWICH("Cheese Sandwich", 2, 0, false, true),
 STEAK_SANDWICH("Steak Sandwich", 4, 50, true, true);

 private final String item;
 private final int pound;
 private final int pence;
 private final boolean isHot;
 private final boolean isFood;

 MenuItem(String item, int pound, int pence, boolean isHot, boolean isFood) {
  this.item = item;
  this.pound = pound;
  this.pence = pence;
  this.isHot = isHot;
  this.isFood = isFood;
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

 public boolean isFood() {
  return isFood;
 }

 @Override
 public String toString() {
  return this.item;
 }
}
