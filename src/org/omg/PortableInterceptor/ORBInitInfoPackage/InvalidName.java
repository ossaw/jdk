package org.omg.PortableInterceptor.ORBInitInfoPackage;

/**
 * org/omg/PortableInterceptor/ORBInitInfoPackage/InvalidName.java . Generated
 * by the IDL-to-Java compiler (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/org/omg/PortableInterceptor/Interceptors.idl Friday, July 21, 2017
 * 9:58:52 PM PDT
 */

public final class InvalidName extends org.omg.CORBA.UserException {

	public InvalidName() {
		super(InvalidNameHelper.id());
	} // ctor

	public InvalidName(String $reason) {
		super(InvalidNameHelper.id() + "  " + $reason);
	} // ctor

} // class InvalidName
