package com.springBoot.project.dao.service;

import com.springBoot.project.dao.entity.UserEntity;
import com.springBoot.project.rest.controller.data.vo.PaginationDTO;

import java.util.List;

public interface UserService {

    List<UserEntity> findByIdAndFirstName(String id, String firstName);
    List<UserEntity> findByFirstName(String firstName, PaginationDTO paginationDTO);
    void addUser(UserEntity userEntity);
    void deleteUser(String userId);
    UserEntity updateUser(UserEntity userEntity);
    List<UserEntity> getAllUsers();
    UserEntity getUserById(String id);
    long countUsers(String firstName);
    List<UserEntity> findBy(String field, PaginationDTO paginationDTO);

}
