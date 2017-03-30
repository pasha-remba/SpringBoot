package com.springBoot.project.dao.service.impl;

import com.springBoot.project.dao.entity.UserEntity;
import com.springBoot.project.dao.service.UserService;
import com.springBoot.project.dao.repository.UserRepository;
import com.springBoot.project.rest.controller.data.vo.PaginationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> findByIdAndFirstName(String id, String firstName) {
        return userRepository.findByIdAndFirstName(id,firstName);
    }

    @Override
    public List<UserEntity> findByFirstName(String firstName, PaginationDTO paginationDTO) {
        return userRepository.findByFirstName(firstName, paginationDTO);
    }

    @Override
    public void addUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.delete(userId);
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public long findByIdAndFirstName(String firstName) {
        return userRepository.findByIdAndFirstName(firstName);
    }

}
