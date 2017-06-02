package com.capgemini.cafex.control;

import com.capgemini.cafex.model.service.Billing;

/**
 *
 * @author betrand.ugorji@capgemini.com
 */
public class Main {

 public static void main(String[] args) {
  System.out.println(Billing.getBill(args));
 }
}
