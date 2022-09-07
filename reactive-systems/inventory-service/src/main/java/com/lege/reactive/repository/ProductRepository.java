package com.lege.reactive.repository;

import com.lege.domain.Product;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author lege
 * @Description
 * @create 2022-09-06 15:47
 */
public interface ProductRepository extends ReactiveMongoRepository<Product, ObjectId> {

}
