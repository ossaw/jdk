package org.omg.IOP.CodecPackage;

/**
 * org/omg/IOP/CodecPackage/TypeMismatch.java . Generated by the IDL-to-Java
 * compiler (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/org/omg/PortableInterceptor/IOP.idl Friday, July 21, 2017 9:58:52 PM
 * PDT
 */

public final class TypeMismatch extends org.omg.CORBA.UserException {

    public TypeMismatch() {
        super(TypeMismatchHelper.id());
    } // ctor

    public TypeMismatch(String $reason) {
        super(TypeMismatchHelper.id() + "  " + $reason);
    } // ctor

} // class TypeMismatch
