package org.omg.IOP;

/**
 * org/omg/IOP/IORHolder.java . Generated by the IDL-to-Java compiler
 * (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/org/omg/PortableInterceptor/IOP.idl Friday, July 21, 2017 9:58:52 PM
 * PDT
 */

public final class IORHolder implements org.omg.CORBA.portable.Streamable {
    public org.omg.IOP.IOR value = null;

    public IORHolder() {}

    public IORHolder(org.omg.IOP.IOR initialValue) {
        value = initialValue;
    }

    public void _read(org.omg.CORBA.portable.InputStream i) {
        value = org.omg.IOP.IORHelper.read(i);
    }

    public void _write(org.omg.CORBA.portable.OutputStream o) {
        org.omg.IOP.IORHelper.write(o, value);
    }

    public org.omg.CORBA.TypeCode _type() {
        return org.omg.IOP.IORHelper.type();
    }

}
