package com.springBoot.project.mapper;

import com.springBoot.project.dao.entity.UserEntity;
import com.springBoot.project.rest.controller.data.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    UserEntity voToUser(UserVO userVO);
    UserVO userToVO(UserEntity userEntity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    List<UserEntity> vosToUsers(List<UserVO> userVO);
    List<UserVO> usersToVOs(List<UserEntity> userEntity);

}
