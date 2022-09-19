package com.epam.javalab32.maintenance_service.controller.assembler;

import com.epam.javalab32.maintenance_service.controller.UserController;
import com.epam.javalab32.maintenance_service.controller.model.UserModel;
import com.epam.javalab32.maintenance_service.dto.UserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserAssembler extends RepresentationModelAssemblerSupport<UserDto, UserModel> {
    public static final String GET_USER = "get_user";
    public static final String GET_ALL_USERS = "get_users";
    public static final String CREATE_USER = "create_user";
    public static final String UPDATE_USER = "update_user";
    public static final String DELETE_USER = "delete_user";

    public UserAssembler() {
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(UserDto entity) {
        UserModel userModel = new UserModel(entity);

        Link get = linkTo(methodOn(UserController.class).getUser(entity.getEmail())).withRel(GET_USER);
        Link create = linkTo(methodOn(UserController.class).createUser(entity)).withRel(CREATE_USER);
        Link update = linkTo(methodOn(UserController.class).updateUser(entity)).withRel(UPDATE_USER);
        Link delete = linkTo(methodOn(UserController.class).deleteUser(entity.getEmail())).withRel(DELETE_USER);

        userModel.add(get, create, update, delete);
        return userModel;
    }

    @Override
    public CollectionModel<UserModel> toCollectionModel(Iterable<? extends UserDto> entities)
    {
        CollectionModel<UserModel> userModels = super.toCollectionModel(entities);

        Link getAll = linkTo(methodOn(UserController.class).getAllUsers()).withRel(GET_ALL_USERS);

        userModels.add(getAll);
        return userModels;
    }
}
