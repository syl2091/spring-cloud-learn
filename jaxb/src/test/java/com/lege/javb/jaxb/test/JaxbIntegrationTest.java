package com.lege.javb.jaxb.test;

import com.lege.jaxb.Book;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author lege
 * @Description
 * @create 2022-08-23 16:52
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JaxbIntegrationTest {
    private Book book;
    private JAXBContext context;

    @Before
    public void before() throws JAXBException {
        book = new Book();
        book.setId(1L);
        book.setName("Book1");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        book.setDate(new Date(1481909329718L));
        context = JAXBContext.newInstance(Book.class);
    }

    @Test
    public void marshal() throws JAXBException, IOException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(book, new File(this.getClass().getResource("/").getPath() + "/book.xml"));
        File sampleBookFile = new File("./sample_book.xml");
        File bookFile = new File(this.getClass().getResource("/book.xml").getFile());
        String sampleBookXML = FileUtils.readFileToString(sampleBookFile, "UTF-8");
        String marshallerBookXML = FileUtils.readFileToString(bookFile, "UTF-8");
        Assert.assertEquals(sampleBookXML.replace("\r", "").replace("\n", ""), marshallerBookXML.replace("\r", "").replace("\n", ""));
    }


}
