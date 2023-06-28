package com.flipkart.RESTAPI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.*;
import com.flipkart.service.*;

@Path("/v1/customer")
public class Customer_API {
    @Path("allgyms")
    @GET
    @Produces("application/json")
    public static Response fetchAllGyms(){
        CustomerGMSInterface customerService = new CustomerGMSService();
        try{
            return Response.ok(customerService.fetchGymList()).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
}