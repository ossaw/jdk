package org.omg.PortableServer.POAPackage;

/**
 * org/omg/PortableServer/POAPackage/ObjectNotActive.java . Generated by the
 * IDL-to-Java compiler (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/org/omg/PortableServer/poa.idl Friday, July 21, 2017 9:58:52 PM PDT
 */

public final class ObjectNotActive extends org.omg.CORBA.UserException {

	public ObjectNotActive() {
		super(ObjectNotActiveHelper.id());
	} // ctor

	public ObjectNotActive(String $reason) {
		super(ObjectNotActiveHelper.id() + "  " + $reason);
	} // ctor

} // class ObjectNotActive
