package com.lege.javasisst;

import javassist.bytecode.AccessFlag;
import javassist.bytecode.ClassFile;
import javassist.bytecode.DuplicateMemberException;
import javassist.bytecode.FieldInfo;
import org.junit.Test;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lege
 * @Description
 * @create 2022-08-25 11:14
 */
public class JavasisstUnitTest {

    @Test
    public void givenJavasisstAPI_whenConstructClass_thenGenerateAClassFile() throws DuplicateMemberException, IOException {
        // given
        String classNameWithPackage = "com.lege.JavassistGeneratedClass";
        ClassFile cf = new ClassFile(false, classNameWithPackage, null);
        cf.setInterfaces(new String[] { "java.lang.Cloneable" });

        FieldInfo f = new FieldInfo(cf.getConstPool(), "id", "I");
        f.setAccessFlags(AccessFlag.PUBLIC);
        cf.addField(f);

        // when
        String className = "JavassistGeneratedClass.class";
        cf.write(new DataOutputStream(new FileOutputStream(className)));
    }
}
