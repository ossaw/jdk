package com.sun.corba.se.spi.activation;

/**
 * com/sun/corba/se/spi/activation/InitialNameServiceOperations.java . Generated
 * by the IDL-to-Java compiler (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/com/sun/corba/se/spi/activation/activation.idl Friday, July 21, 2017
 * 9:58:51 PM PDT
 */

public interface InitialNameServiceOperations {

    // bind initial name
    void bind(String name, org.omg.CORBA.Object obj, boolean isPersistant)
            throws com.sun.corba.se.spi.activation.InitialNameServicePackage.NameAlreadyBound;
} // interface InitialNameServiceOperations
