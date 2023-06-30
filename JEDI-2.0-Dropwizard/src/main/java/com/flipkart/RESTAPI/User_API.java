package com.flipkart.RESTAPI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.*;
import com.flipkart.service.*;
@Path("/v1/authentication")
public class User_API {
    @Path("login")
    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response login(User user){
        UserGMSService authentication = new UserGMSService();
        User user1 =authentication.authenticateUser(user);
        if(user1 == null)
        {
            user1.setRoleId(5);
            user1.setEmail("Wrong");
            user1.setPassword("Wrong");
        }
        return Response.ok(user1).build();
    }

    @Path("registeruser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void registerUser(User user){
        UserGMSService userGMSService = new UserGMSService();
        userGMSService.registerUser(user);
    }

    @Path("registercustomer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void registerCustomer(Customer customer){
        UserGMSService userGMSService = new UserGMSService();
        User user =new User();
        user.setEmail(customer.getEmail());
        user.setPassword(customer.getPassword());
        user.setRoleId(1);
        try {
            userGMSService.registerUser(user);
            userGMSService.registerCustomer(customer);
        } catch (Exception e) {
        }

    }

    @Path("registergymowner")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void registerGymOwner(GymOwner gymOwner){
        UserGMSService userGMSService = new UserGMSService();
        userGMSService.registerGymOwner(gymOwner);
    }
}
