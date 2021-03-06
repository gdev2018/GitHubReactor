package org.gdev2018.githubreactor;

/**
 * Created by Miroslaw Stanek on 28.09.15.
 * 2017-11-30 Updated by gdev2018
 */
public class HeavyExternalLibrary {

    private boolean initialized = false;

    public HeavyExternalLibrary() {
    }

    public void init() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        initialized = true;
    }

    public void callMethod() {
        if (!initialized) throw new RuntimeException("Call init() before you use this library");
    }
}