package org.omg.DynamicAny.DynAnyFactoryPackage;

/**
 * org/omg/DynamicAny/DynAnyFactoryPackage/InconsistentTypeCode.java . Generated
 * by the IDL-to-Java compiler (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/org/omg/DynamicAny/DynamicAny.idl Friday, July 21, 2017 9:58:51 PM
 * PDT
 */

public final class InconsistentTypeCode extends org.omg.CORBA.UserException {

	public InconsistentTypeCode() {
		super(InconsistentTypeCodeHelper.id());
	} // ctor

	public InconsistentTypeCode(String $reason) {
		super(InconsistentTypeCodeHelper.id() + "  " + $reason);
	} // ctor

} // class InconsistentTypeCode
