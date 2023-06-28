package com.flipkart.RESTAPI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.*;
import com.flipkart.service.*;

@Path("/v1/admin")
public class Admin_API {
    @Path("allgyms")
    @GET
    @Produces("application/json")
    public static Response seeAllGyms(){
        AdminGMSInterface adminSer = new AdminGMSService();
        try{
            return Response.ok(adminSer.seeAllGyms()).build();
        }
        // unauthorized admin should not be able to hit the API - edit the code here.
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("seeallgymowner")
    @GET
    @Produces("application/json")
    public static Response seeAllGymOwner(){
        AdminGMSInterface adminSer = new AdminGMSService();
        try{
            return Response.ok(adminSer.seeAllGymOwner()).build();
        }
        // unauthorized admin should not be able to hit the API - edit the code here.
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("seeppendinggymowner")
    @GET
    @Produces("application/json")
    public static Response seePendingGymOwnerRequest(){
        AdminGMSInterface adminSer = new AdminGMSService();
        try{
            return Response.ok(adminSer.seePendingGymOwnerRequest()).build();
        }
        // unauthorized admin should not be able to hit the API - edit the code here.
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("seependinggym")
    @GET
    @Produces("application/json")
    public static Response seePendingGymRequest(){
        AdminGMSInterface adminSer = new AdminGMSService();
        try{
            return Response.ok(adminSer.seePendingGymRequest()).build();
        }
        // unauthorized admin should not be able to hit the API - edit the code here.
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("approveallowner")
    @PUT
    public static String approveAllOwnerRequest(){
        try {
            AdminGMSInterface adminSer = new AdminGMSService();
            adminSer.approveAllOwnerRequest();
            return "Approved!";
        }catch(Exception exception){
            return exception.getMessage();
        }
    }


    @Path("approveallgym")
    @PUT
    public static String approveAllGymRequest(){
        try {
            AdminGMSInterface adminSer = new AdminGMSService();
            adminSer.approveAllGymRequest();
            return "Approved!";
        }catch(Exception exception){
            return exception.getMessage();
        }
    }

    @Path("approvesingleowner")
    @PUT
    public static String approveSingleOwnerRequest(@QueryParam("email") String email){
//        System.out.println("Email is:"+email);
        try {
            AdminGMSInterface adminSer = new AdminGMSService();
            adminSer.approveSingleOwnerRequest(email);
            return "Approved!";
        }catch(Exception exception){
            return exception.getMessage();
        }
    }

    @Path("approvesinglegym")
    @PUT
    public static String approveSingleGymRequest(@QueryParam("gymId") int gymId){
//        System.out.println("Email is:"+email);
        try{
            AdminGMSInterface adminSer = new AdminGMSService();
            adminSer.approveSingleGymRequest(gymId);
            return "Approved!";
        }catch(Exception exception){
            return  exception.getMessage();
        }
    }
}