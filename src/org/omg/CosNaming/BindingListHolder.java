package org.omg.CosNaming;

/**
 * org/omg/CosNaming/BindingListHolder.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/classes/org/omg/CosNaming/nameservice.idl
 * Friday, July 21, 2017 9:58:51 PM PDT
 */

/**
 * List of Bindings.
 */
public final class BindingListHolder implements
        org.omg.CORBA.portable.Streamable {
    public org.omg.CosNaming.Binding value[] = null;

    public BindingListHolder() {}

    public BindingListHolder(org.omg.CosNaming.Binding[] initialValue) {
        value = initialValue;
    }

    public void _read(org.omg.CORBA.portable.InputStream i) {
        value = org.omg.CosNaming.BindingListHelper.read(i);
    }

    public void _write(org.omg.CORBA.portable.OutputStream o) {
        org.omg.CosNaming.BindingListHelper.write(o, value);
    }

    public org.omg.CORBA.TypeCode _type() {
        return org.omg.CosNaming.BindingListHelper.type();
    }

}
