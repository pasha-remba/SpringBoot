package com.springBoot.project.rest.controller;

import com.springBoot.project.dao.entity.UserEntity;
import com.springBoot.project.dao.service.UserService;
import com.springBoot.project.mapper.UserMapper;
import com.springBoot.project.rest.controller.data.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserVO userVO){
        UserEntity userEntity = userMapper.voToUser(userVO);
        userService.addUser(userEntity);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public UserVO getUser(@PathVariable String userId){
        UserEntity userEntity = userService.getUserById(userId);
        return userMapper.userToVO(userEntity);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
    }
}
