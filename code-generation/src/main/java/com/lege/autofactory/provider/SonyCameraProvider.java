package com.lege.autofactory.provider;

import com.lege.autofactory.model.Camera;
import com.google.inject.Provider;

/**
 * @author aiet
 */
public class SonyCameraProvider implements Provider<Camera> {

    private static int sonyCameraSerial = 1;

    @Override
    public Camera get() {
        return new Camera("Sony", String.format("%03d", sonyCameraSerial++));
    }

}
