package com.lege.reactive.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.lege.domain.Order;

public interface OrderRepository extends ReactiveMongoRepository<Order, ObjectId> {

}
