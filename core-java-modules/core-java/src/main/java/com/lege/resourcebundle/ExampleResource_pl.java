package com.lege.resourcebundle;

import java.util.ListResourceBundle;

public class ExampleResource_pl extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] { 
            { "greeting", "cześć" }, 
            { "language", "polish" }, 
        };
    }

}
