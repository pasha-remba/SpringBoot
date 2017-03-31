package com.springBoot.project.rest.controller;

import com.springBoot.project.dao.entity.UserEntity;
import com.springBoot.project.dao.service.UserService;
import com.springBoot.project.mapper.UserMapper;
import com.springBoot.project.rest.controller.data.vo.CountDTO;
import com.springBoot.project.rest.controller.data.vo.PaginationDTO;
import com.springBoot.project.rest.controller.data.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public UserVO getUserByUserId(@PathVariable String userId){
        UserEntity userEntity = userService.getUserById(userId);
        return userMapper.userToVO(userEntity);
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
    }

    @RequestMapping(value = "/users/count", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public CountDTO getCountUsers(@RequestBody PaginationDTO paginationDTO){
        long users = userService.countUsers(paginationDTO.getFindBy());
        CountDTO countDTO = new CountDTO();
        countDTO.setCount(users);
        return countDTO;
    }

    @RequestMapping(value = "/users/{firstName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<UserVO> getUsersByFirstName(@PathVariable String firstName, @RequestBody PaginationDTO paginationDTO){
        List<UserEntity> userEntity = userService.findByFirstName(firstName, paginationDTO);
        return userMapper.usersToVOs(userEntity);
    }

    @RequestMapping(value = "/users/{field}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<UserVO> getUsersBy(@PathVariable String firstName, @RequestBody PaginationDTO paginationDTO){
        List<UserEntity> userEntity = userService.findBy(firstName, paginationDTO);
        return userMapper.usersToVOs(userEntity);
    }
}
