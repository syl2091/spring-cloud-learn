package com.lege.illegalcharacter;

import com.google.gdata.util.io.base.UnicodeReader;
import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.input.BOMInputStream;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author lege
 * @Description
 * @create 2022-08-16 13:41
 */
public class IllegalCharacterUnitTest {
    final String RESOURCE_FILE_NAME = "bom-file.txt";
    final InputStream ioStream = this.getClass()
            .getClassLoader()
            .getResourceAsStream(RESOURCE_FILE_NAME);
    final String expected = "Hello world with BOM.";


    @Test
    public void whenInputFileHasBOM_thenUseInputStream() throws IOException {
        String line;
        String actual = "";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(ioStream))) {
            while ((line = br.readLine()) != null) {
                actual += line;
                System.out.println(actual);
            }
        }

        assertNotEquals(expected, actual);
    }


    @Test
    public void whenInputFileHasBOM_thenUseInputStreamWithReplace() throws IOException {
        String line;
        String actual = "";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(ioStream), StandardCharsets.UTF_8))) {
            while ((line = br.readLine()) != null) {
                actual += line.replace("\uFEFF", "");
                System.out.println(actual);
            }
        }

        assertEquals(expected, actual);
    }


    @Test
    public void whenInputFileHasBOM_thenUseBOMInputStream() throws IOException {
        String line;
        String actual = "";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new BOMInputStream(ioStream, false, ByteOrderMark.UTF_8, ByteOrderMark.UTF_16BE, ByteOrderMark.UTF_16LE, ByteOrderMark.UTF_32BE, ByteOrderMark.UTF_32LE)))) {
            while ((line = br.readLine()) != null) {
                actual += line;
            }
        }

        assertEquals(expected, actual);
    }



    @Test
    public void whenInputFileHasBOM_thenUseGoogleGdata() throws IOException {
        char[] actual = new char[21];

        try (Reader r = new UnicodeReader(ioStream, null)) {
            r.read(actual);
        }

        assertEquals(expected, String.valueOf(actual));
    }
}
