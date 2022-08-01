package org.hsmak;

/**
 * Links:
 *  - https://www.baeldung.com/jni
 *  -
 * commands:
 *  - `javac -h ./native  src/main/java/org/hsmak/HelloWorldJNI.java`
 */
public class HelloWorldJNI {

    static {
        System.loadLibrary("native");
    }

    public static void main(String[] args) {
        new HelloWorldJNI().sayHello();
    }

    // Declare a native method sayHello() that receives no arguments and returns void
    private native void sayHello();
}