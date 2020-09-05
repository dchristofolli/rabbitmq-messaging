package com.dchristofolli.messagingrabbitmq.repository;

import com.dchristofolli.messagingrabbitmq.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
}
