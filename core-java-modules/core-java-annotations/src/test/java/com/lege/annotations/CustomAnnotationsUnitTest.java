package com.lege.annotations;

import com.lege.customannotations.JsonSerializationException;
import com.lege.customannotations.ObjectToJsonConverter;
import com.lege.customannotations.Person;
import org.junit.Test;

/**
 * @author lege
 * @Description
 * @create 2022-08-17 14:06
 */
public class CustomAnnotationsUnitTest {

    @Test
    public void givenObjectSerializedThenTrueReturned() throws JsonSerializationException {
        Person person = new Person("shen", "lege", "24");
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        String jsonString = serializer.convertToJson(person);
        System.out.println(jsonString);
    }
}
