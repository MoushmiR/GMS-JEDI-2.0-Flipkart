package com.flipkart.RESTAPI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.*;
import com.flipkart.dao.CustomerGMSDao;
import com.flipkart.dao.CustomerGMSDaoImpl;
import com.flipkart.service.*;
@Path("/v1/gyms")

public class Gym_API {
    @Path("gyminfo")
    @GET
    @Produces("application/json")
    public static Response fetchGymInfo(@QueryParam("gymId") int gymId){
        GymOwnerGMSInterface gymOwnerService = new GymOwnerGMSService();
        try{
            return Response.ok(gymOwnerService.getGymInfo(gymId)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
}
