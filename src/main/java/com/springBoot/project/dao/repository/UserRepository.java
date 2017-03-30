package com.springBoot.project.dao.repository;

import com.springBoot.project.dao.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String>, UserRepositoryCustom{

}
