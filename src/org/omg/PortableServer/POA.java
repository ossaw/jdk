package org.omg.PortableServer;

/**
 * org/omg/PortableServer/POA.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/classes/org/omg/PortableServer/poa.idl
 * Friday, July 21, 2017 9:58:52 PM PDT
 */

/**
 * A POA object manages the implementation of a collection of objects. The POA
 * supports a name space for the objects, which are identified by Object Ids. A
 * POA also provides a name space for POAs. A POA is created as a child of an
 * existing POA, which forms a hierarchy starting with the root POA. A POA
 * object must not be exported to other processes, or externalized with
 * ORB::object_to_string.
 */
public interface POA extends POAOperations, org.omg.CORBA.Object,
        org.omg.CORBA.portable.IDLEntity {} // interface POA
