package com.spilgames.qa.tester;

public enum Commands {

  AREA, PERIMETER;

  public static Commands fromString(String command){
    for (Commands c : Commands.values()) {
      if(c.name().equalsIgnoreCase(command)){
        return c;
      }
    }
    return null;
  }

}
