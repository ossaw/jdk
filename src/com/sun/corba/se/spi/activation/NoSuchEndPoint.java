package com.sun.corba.se.spi.activation;

/**
 * com/sun/corba/se/spi/activation/NoSuchEndPoint.java . Generated by the
 * IDL-to-Java compiler (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/com/sun/corba/se/spi/activation/activation.idl Friday, July 21, 2017
 * 9:58:51 PM PDT
 */

public final class NoSuchEndPoint extends org.omg.CORBA.UserException {

	public NoSuchEndPoint() {
		super(NoSuchEndPointHelper.id());
	} // ctor

	public NoSuchEndPoint(String $reason) {
		super(NoSuchEndPointHelper.id() + "  " + $reason);
	} // ctor

} // class NoSuchEndPoint
