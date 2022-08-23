package com.lege.jaxb.dateunmarshalling;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author lege
 * @Description
 * @create 2022-08-23 16:38
 */
@XmlRootElement(name = "book")
public class Book {

    @XmlElement(name = "title", required = true)
    private String title;

    @XmlElement(name = "published", required = true)
    private XMLGregorianCalendar published;

    public XMLGregorianCalendar getPublished() {
        return published;
    }

    @Override
    public String toString() {
        return "[title: " + title + "; published: " + published.toString() + "]";
    }

}
