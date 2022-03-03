package com.ggs.resource;

import com.ggs.mapper.UserMapper;
import com.ggs.model.User;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UserResource {

    @Inject
    UserMapper userMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return userMapper.findAllUsers();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/builder")
    public List<User> getUsersUsingSqlBuilder() {
        return userMapper.findAllUsersUsingBuilder();
    }
}