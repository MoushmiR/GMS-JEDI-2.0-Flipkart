package com.flipkart.RESTAPI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.*;
import com.flipkart.dao.CustomerGMSDao;
import com.flipkart.dao.CustomerGMSDaoImpl;
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

    @Path("allslots")
    @GET
    @Produces("application/json")
    public static Response fetchAllSlots(@QueryParam("gymId") int gymId){
        CustomerGMSInterface customerService = new CustomerGMSService();
        try{
            return Response.ok(customerService.fetchAvailableSlots(gymId)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("cancelbooking")
    @DELETE
    @Produces("application/json")
    public static Response cancelBooking(@QueryParam("bookingId") int bookingId){

        CustomerGMSInterface customerService = new CustomerGMSService();
        try{
            return Response.ok(customerService.cancelBookedSlots(bookingId)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("createbooking")
    @POST
    @Produces("application/json")
    public static Response createBooking(@QueryParam("gymId") int gymId, @QueryParam("slotId") String slotId, @QueryParam("email") String email, @QueryParam("date") String date){
        CustomerGMSDao customerGMSDao = new CustomerGMSDaoImpl();
        try{
            return Response.ok(customerGMSDao.bookSlots(gymId,slotId,email,date)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("mybookings")
    @GET
    @Produces("application/json")
    public static Response getBookings(@QueryParam("email") String email){
        CustomerGMSDao customerGMSDao = new CustomerGMSDaoImpl();
        try{
            return Response.ok(customerGMSDao.fetchBookedSlots(email)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("mybookingsdate")
    @GET
    @Produces("application/json")
    public static Response getBookingsNDate(@QueryParam("email") String email, @QueryParam("date") String date){
        CustomerGMSDao customerGMSDao = new CustomerGMSDaoImpl();
        try{
            return Response.ok(customerGMSDao.fetchBookedSlotsNDate(email, date)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("findavailability")
    @GET
    @Produces("application/json")
    public static Response findAvailability(@QueryParam("gymId") int gymId, @QueryParam("date") String date){
        CustomerGMSDao customerGMSDao = new CustomerGMSDaoImpl();
        try{
            return Response.ok(customerGMSDao.allAvailableSlots(gymId, date)).build();
        }
        catch(Exception exception){
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }

    @Path("bookslots")
    @POST
    @Produces("application/json")
    public static Response bookGymSlots(@QueryParam("gymId") int gymId, @QueryParam("slotId") String slotId, @QueryParam("email") String email, @QueryParam("date") String date) {
        CustomerGMSInterface customerGMSService = new CustomerGMSService();
        try {
            return Response.ok(customerGMSService.bookSlots(gymId, slotId, email, date)).build();
        } catch (Exception exception) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).build();
        }
    }
}