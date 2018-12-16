package com.sun.corba.se.spi.activation;

/**
 * com/sun/corba/se/spi/activation/ServerOperations.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/classes/com/sun/corba/se/spi/activation/activation.idl
 * Friday, July 21, 2017 9:58:51 PM PDT
 */

/**
 * Server callback API, passed to Activator in active method.
 */
public interface ServerOperations {

    /**
     * Shutdown this server. Returns after orb.shutdown() completes.
     */
    void shutdown();

    /**
     * Install the server. Returns after the install hook completes execution in
     * the server.
     */
    void install();

    /**
     * Uninstall the server. Returns after the uninstall hook completes
     * execution.
     */
    void uninstall();
} // interface ServerOperations
