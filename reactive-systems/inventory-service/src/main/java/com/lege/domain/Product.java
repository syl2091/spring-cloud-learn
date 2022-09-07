package com.lege.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lege.serdeser.ObjectIdSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author lege
 * @Description
 * @create 2022-09-06 15:44
 */
@Data
@Document
public class Product {

    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;
    private String name;
    private Long price;
    private Integer stock;

}