package org.omg.CosNaming.NamingContextPackage;

/**
 * org/omg/CosNaming/NamingContextPackage/NotEmpty.java . Generated by the
 * IDL-to-Java compiler (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/org/omg/CosNaming/nameservice.idl Friday, July 21, 2017 9:58:51 PM
 * PDT
 */

public final class NotEmpty extends org.omg.CORBA.UserException {

	public NotEmpty() {
		super(NotEmptyHelper.id());
	} // ctor

	public NotEmpty(String $reason) {
		super(NotEmptyHelper.id() + "  " + $reason);
	} // ctor

} // class NotEmpty
