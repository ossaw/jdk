package org.omg.Dynamic;

/**
 * org/omg/Dynamic/Parameter.java . Generated by the IDL-to-Java compiler
 * (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/org/omg/PortableInterceptor/Interceptors.idl Friday, July 21, 2017
 * 9:58:52 PM PDT
 */

public final class Parameter implements org.omg.CORBA.portable.IDLEntity {
    public org.omg.CORBA.Any argument = null;
    public org.omg.CORBA.ParameterMode mode = null;

    public Parameter() {} // ctor

    public Parameter(org.omg.CORBA.Any _argument, org.omg.CORBA.ParameterMode _mode) {
        argument = _argument;
        mode = _mode;
    } // ctor

} // class Parameter
