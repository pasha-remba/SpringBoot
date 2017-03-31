package com.springBoot.project.dao.repository;

import com.springBoot.project.dao.entity.UserEntity;
import com.springBoot.project.rest.controller.data.vo.PaginationDTO;

import java.util.List;

public interface UserRepositoryCustom {

    List<UserEntity> findByFirstName(String firstName, PaginationDTO paginationDTO);
    List<UserEntity> findByIdAndFirstName(String id, String firstName);
    List<UserEntity> findBy(String field, PaginationDTO paginationDTO);
    long countUsers(String field);


}
