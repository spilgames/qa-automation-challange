package com.spilgames.qa.tester;

import com.sun.jersey.api.view.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

@Path("/pay")
public class Payment {

  @GET
  @Produces("text/plain")
  public Response command(
      @QueryParam("method") PaymentMethod method,
      @QueryParam("amount") int amount) {

    Map<String, Object> data = new HashMap<String, Object>();
    try {
      data.put("amount", calculatePayment(method, amount));
    } catch (InvalidInputException e) {
      data.put("error", e.getMessage());
    }
    return Response.ok(new Viewable("/payment", data)).build();

  }

  private Double calculatePayment(PaymentMethod method, int amount) throws InvalidInputException {
    switch (method) {
      case CREDITCARD:
        if(amount<100){
          return amount*1.02;
        }
        break;
      case IDEAL:
        if(amount<50){
          return (double) (amount+1);
        }
        break;
      case PAYPAL:
        if(amount<20){
          throw new InvalidInputException("Your amount is too low");
        }
        break;
    }
    return (double) amount;
  }

}
