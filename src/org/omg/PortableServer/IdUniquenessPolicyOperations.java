package org.omg.PortableServer;

/**
 * org/omg/PortableServer/IdUniquenessPolicyOperations.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/classes/org/omg/PortableServer/poa.idl
 * Friday, July 21, 2017 9:58:52 PM PDT
 */

/**
 * The IdUniquenessPolicy specifies whether the servants activated in the
 * created POA must have unique object i identities. The default is UNIQUE_ID.
 */
public interface IdUniquenessPolicyOperations extends
        org.omg.CORBA.PolicyOperations {

    /**
     * specifies the policy value
     */
    org.omg.PortableServer.IdUniquenessPolicyValue value();
} // interface IdUniquenessPolicyOperations
