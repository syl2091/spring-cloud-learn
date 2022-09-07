package com.lege.serdeser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author lege
 * @Description
 * @create 2022-09-06 15:45
 */
@Component
public class ObjectIdSerializer extends JsonSerializer<ObjectId> {

    @Override
    public void serialize(ObjectId value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeString(value.toString());
    }
}
