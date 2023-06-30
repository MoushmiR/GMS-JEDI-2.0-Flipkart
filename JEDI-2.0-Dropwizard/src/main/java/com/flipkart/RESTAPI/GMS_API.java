package com.flipkart.RESTAPI;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class GMS_API extends Application<GMS_API_Configuration> {
    public static void main(String[] args) throws Exception {
        new GMS_API().run(args);
    }
    @Override
    public void run(GMS_API_Configuration configuration, Environment environment) throws Exception {
        environment.jersey().register(User_API.class);
        environment.jersey().register(Admin_API.class);
        environment.jersey().register(Customer_API.class);
        environment.jersey().register(Gym_API.class);
    }
}