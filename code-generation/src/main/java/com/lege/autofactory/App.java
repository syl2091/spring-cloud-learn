package com.lege.autofactory;

import com.lege.autofactory.model.Camera;
import com.lege.autofactory.model.Phone;
import com.lege.autofactory.model.PhoneFactory;
import com.lege.autofactory.modules.SonyCameraModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class App {

    public static void main(String[] args) {
        PhoneFactory phoneFactory = new PhoneFactory(() -> new Camera("Unknown", "XXX"));
        Phone simplePhone = phoneFactory.create("other parts");

        Injector injector = Guice.createInjector(new SonyCameraModule());
        PhoneFactory injectedFactory = injector.getInstance(PhoneFactory.class);
        Phone xperia = injectedFactory.create("Xperia");
    }

}
