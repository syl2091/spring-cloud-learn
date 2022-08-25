package com.lege.javers;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.javers.core.diff.changetype.ValueChange;
import org.junit.Test;

/**
 * @author lege
 * @Description
 * @create 2022-08-25 14:39
 */
public class JaversUnitTest {


    @Test
    public void givenPersonObject_whenApplyModificationOnIt_thenShouldDetectChange(){
        // given
        Javers javers = JaversBuilder.javers().build();
        Person person = new Person(1, "Michael Program");
        Person personAfterModification = new Person(1, "Michael Java");
        // when
        Diff diff = javers.compare(person, personAfterModification);
        // then
        ValueChange change = diff.getChangesByType(ValueChange.class).get(0);


    }

}
