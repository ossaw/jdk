package com.sun.corba.se.PortableActivationIDL;

/**
 * com/sun/corba/se/PortableActivationIDL/ServerHeldDownHolder.java . Generated
 * by the IDL-to-Java compiler (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/com/sun/corba/se/PortableActivationIDL/activation.idl Friday, July
 * 21, 2017 9:58:51 PM PDT
 */

public final class ServerHeldDownHolder implements org.omg.CORBA.portable.Streamable {
	public com.sun.corba.se.PortableActivationIDL.ServerHeldDown value = null;

	public ServerHeldDownHolder() {
	}

	public ServerHeldDownHolder(
			com.sun.corba.se.PortableActivationIDL.ServerHeldDown initialValue) {
		value = initialValue;
	}

	public void _read(org.omg.CORBA.portable.InputStream i) {
		value = com.sun.corba.se.PortableActivationIDL.ServerHeldDownHelper.read(i);
	}

	public void _write(org.omg.CORBA.portable.OutputStream o) {
		com.sun.corba.se.PortableActivationIDL.ServerHeldDownHelper.write(o, value);
	}

	public org.omg.CORBA.TypeCode _type() {
		return com.sun.corba.se.PortableActivationIDL.ServerHeldDownHelper.type();
	}

}