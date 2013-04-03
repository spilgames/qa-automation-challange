package com.spilgames.qa.tester;

public enum PaymentMethod {

  IDEAL, CREDITCARD, PAYPAL;

  public static PaymentMethod fromString(String command){
    for (PaymentMethod c : PaymentMethod.values()) {
      if(c.name().equalsIgnoreCase(command)){
        return c;
      }
    }
    return null;
  }


}
