package com.sun.corba.se.PortableActivationIDL;

/**
 * com/sun/corba/se/PortableActivationIDL/NoSuchEndPointHolder.java . Generated
 * by the IDL-to-Java compiler (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/com/sun/corba/se/PortableActivationIDL/activation.idl Friday, July
 * 21, 2017 9:58:51 PM PDT
 */

public final class NoSuchEndPointHolder implements
        org.omg.CORBA.portable.Streamable {
    public com.sun.corba.se.PortableActivationIDL.NoSuchEndPoint value = null;

    public NoSuchEndPointHolder() {}

    public NoSuchEndPointHolder(
            com.sun.corba.se.PortableActivationIDL.NoSuchEndPoint initialValue) {
        value = initialValue;
    }

    public void _read(org.omg.CORBA.portable.InputStream i) {
        value = com.sun.corba.se.PortableActivationIDL.NoSuchEndPointHelper
                .read(i);
    }

    public void _write(org.omg.CORBA.portable.OutputStream o) {
        com.sun.corba.se.PortableActivationIDL.NoSuchEndPointHelper.write(o,
                value);
    }

    public org.omg.CORBA.TypeCode _type() {
        return com.sun.corba.se.PortableActivationIDL.NoSuchEndPointHelper
                .type();
    }

}
