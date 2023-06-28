package com.flipkart.RESTAPI;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.flipkart.bean.*;
import com.flipkart.service.*;

@Path("/v1/authentication")
public class User_API {
    @Path("login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String login(User user){
        UserGMSService authentication = new UserGMSService();
        com.flipkart.bean.User loggedUser = authentication.authenticateUser(user);
        if(loggedUser != null) {
            int role = loggedUser.getRoleId();
            switch (role){
                case 1: return "Welcome Customer";
                case 2: return "Welcome Gym Owner";
                case 3: return "Welcome Admin";
                default:return "Something Unexpected";
            }
        }
        return "User not found!";
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
        userGMSService.registerCustomer(customer);
    }

    @Path("registergymowner")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void registerGymOwner(GymOwner gymOwner){
        UserGMSService userGMSService = new UserGMSService();
        userGMSService.registerGymOwner(gymOwner);
    }
}