package org.omg.DynamicAny.DynAnyPackage;

/**
 * org/omg/DynamicAny/DynAnyPackage/InvalidValue.java . Generated by the
 * IDL-to-Java compiler (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/org/omg/DynamicAny/DynamicAny.idl Friday, July 21, 2017 9:58:51 PM
 * PDT
 */

public final class InvalidValue extends org.omg.CORBA.UserException {

    public InvalidValue() {
        super(InvalidValueHelper.id());
    } // ctor

    public InvalidValue(String $reason) {
        super(InvalidValueHelper.id() + "  " + $reason);
    } // ctor

} // class InvalidValue
