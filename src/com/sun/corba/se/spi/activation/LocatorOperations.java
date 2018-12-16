package com.sun.corba.se.spi.activation;

/**
 * com/sun/corba/se/spi/activation/LocatorOperations.java . Generated by the
 * IDL-to-Java compiler (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/com/sun/corba/se/spi/activation/activation.idl Friday, July 21, 2017
 * 9:58:51 PM PDT
 */

public interface LocatorOperations {

    // Starts the server if it is not already running.
    com.sun.corba.se.spi.activation.LocatorPackage.ServerLocation locateServer(
            int serverId, String endPoint)
            throws com.sun.corba.se.spi.activation.NoSuchEndPoint,
            com.sun.corba.se.spi.activation.ServerNotRegistered,
            com.sun.corba.se.spi.activation.ServerHeldDown;

    // Starts the server if it is not already running.
    com.sun.corba.se.spi.activation.LocatorPackage.ServerLocationPerORB locateServerForORB(
            int serverId, String orbId)
            throws com.sun.corba.se.spi.activation.InvalidORBid,
            com.sun.corba.se.spi.activation.ServerNotRegistered,
            com.sun.corba.se.spi.activation.ServerHeldDown;

    // get the port for the endpoint of the locator
    int getEndpoint(String endPointType)
            throws com.sun.corba.se.spi.activation.NoSuchEndPoint;

    // to pick a particular port type.
    int getServerPortForType(
            com.sun.corba.se.spi.activation.LocatorPackage.ServerLocationPerORB location,
            String endPointType)
            throws com.sun.corba.se.spi.activation.NoSuchEndPoint;
} // interface LocatorOperations
