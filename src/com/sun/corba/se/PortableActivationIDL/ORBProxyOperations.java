package com.sun.corba.se.PortableActivationIDL;

/**
* com/sun/corba/se/PortableActivationIDL/ORBProxyOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/classes/com/sun/corba/se/PortableActivationIDL/activation.idl
* Friday, July 21, 2017 9:58:51 PM PDT
*/

/**
 * ORB callback interface, passed to Activator in registerORB method.
 */
public interface ORBProxyOperations {

	/**
	 * Method used to cause ORB to activate the named adapter, if possible. This
	 * will cause the named POA to register itself with the activator as a side
	 * effect. This should always happen before this call can complete. This
	 * method returns true if adapter activation succeeded, otherwise it returns
	 * false.
	 */
	boolean activate_adapter(String[] name);
} // interface ORBProxyOperations
