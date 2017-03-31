package com.springBoot.project.dao.repository.impl;

import com.springBoot.project.dao.entity.UserEntity;
import com.springBoot.project.dao.repository.UserRepositoryCustom;
import com.springBoot.project.enumeration.SortOrder;
import com.springBoot.project.rest.controller.data.vo.PaginationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<UserEntity> findByFirstName(String firstName, PaginationDTO paginationDTO) {
        Query query = Query.query(Criteria.where("firstName").is(firstName));
        return mongoTemplate.find(getListResults(query, firstName, paginationDTO), UserEntity.class);
    }

    @Override
    public List<UserEntity> findByIdAndFirstName(String id, String firstName) {
        Criteria criteria = new Criteria();

        List<Criteria> params = new ArrayList<>();
        params.add(Criteria.where("id").is(id));
        params.add(Criteria.where("firstName").is(firstName));

        if(params.size() != 0){
            criteria.andOperator(params.toArray(new Criteria[params.size()]));
        }

        Query query = Query.query(criteria);
        return mongoTemplate.find(query, UserEntity.class);
    }

    @Override
    public List<UserEntity> findBy(String field, PaginationDTO paginationDTO) {
        Query query = Query.query(Criteria.where("field").is(field));
        return mongoTemplate.find(getListResults(query, field, paginationDTO), UserEntity.class);
    }

    @Override
    public long countUsers(String field) {
        Query query = Query.query(Criteria.where(field).is(field));
        return mongoTemplate.find(query, UserEntity.class).size();
    }

    private Query getListResults(Query query, String field, PaginationDTO paginationDTO){

        String sortBy = (field != null && !field.isEmpty()) ? field : "id";

        query.with(getSort(sortBy, paginationDTO.getSortOrder()));

        if(paginationDTO.getStartPage() != null && paginationDTO.getStartPage() >= 0){
            query.skip(paginationDTO.getStartPage());
        }

        if(paginationDTO.getEndPage() != null && paginationDTO.getStartPage() >= 0){
            query.limit(paginationDTO.getEndPage());
        }

        return query;
    }

    private Sort getSort(String field, SortOrder sortOrder) {
        return new Sort(sortOrder.toString().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, field);
    }
}
