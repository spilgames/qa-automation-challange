package com.spilgames.qa.tester;

import com.sun.jersey.api.view.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

@Path("/triangle/{command}")
public class Triangle {

  @GET
  @Produces("text/plain")
  public Response command(@PathParam("command") Commands command,
      @QueryParam("a") int a,
      @QueryParam("b") int b,
      @QueryParam("c") int c) {
    Map<String, String> data = new HashMap<String, String>();
    switch (command) {
      case AREA:
        data.put("area", area(a,b,c));
        break;
      case PERIMETER:
        data.put("perimeter", perimeter(a,b,c));
        break;
    }
    return generateResponse(data);
  }

  private Response generateResponse(Map<String, String> data) {
    return Response.ok(new Viewable("/triangle", data)).build();
  }

  private String perimeter(int a, int b, int c) {
    return String.valueOf(a+b+c);
  }

  private String area(int a, int b, int c) {
    double s = (a+b+c)/2.0;
    return String.valueOf(Math.sqrt(s*(s-a)*(s-b)*(s-c)));
  }

}
