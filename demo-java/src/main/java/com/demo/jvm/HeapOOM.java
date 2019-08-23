package com.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * a
 */
public class HeapOOM {
    static class OOMObject {

    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
