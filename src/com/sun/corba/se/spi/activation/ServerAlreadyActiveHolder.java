package com.sun.corba.se.spi.activation;

/**
 * com/sun/corba/se/spi/activation/ServerAlreadyActiveHolder.java . Generated by
 * the IDL-to-Java compiler (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/com/sun/corba/se/spi/activation/activation.idl Friday, July 21, 2017
 * 9:58:51 PM PDT
 */

public final class ServerAlreadyActiveHolder implements
		org.omg.CORBA.portable.Streamable {
	public com.sun.corba.se.spi.activation.ServerAlreadyActive value = null;

	public ServerAlreadyActiveHolder() {}

	public ServerAlreadyActiveHolder(
			com.sun.corba.se.spi.activation.ServerAlreadyActive initialValue) {
		value = initialValue;
	}

	public void _read(org.omg.CORBA.portable.InputStream i) {
		value = com.sun.corba.se.spi.activation.ServerAlreadyActiveHelper.read(
				i);
	}

	public void _write(org.omg.CORBA.portable.OutputStream o) {
		com.sun.corba.se.spi.activation.ServerAlreadyActiveHelper.write(o,
				value);
	}

	public org.omg.CORBA.TypeCode _type() {
		return com.sun.corba.se.spi.activation.ServerAlreadyActiveHelper.type();
	}

}
