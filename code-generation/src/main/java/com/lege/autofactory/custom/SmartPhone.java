package com.lege.autofactory.custom;

import com.lege.autofactory.CustomStorage;
import com.google.auto.factory.AutoFactory;

/**
 * @author aiet
 */
@AutoFactory(className = "SamsungFactory", allowSubclasses = true, implementing = CustomStorage.class)
public class SmartPhone {

    private int romSize;

    public SmartPhone(int romSize) {
        this.romSize = romSize;
    }

}
