package org.omg.PortableInterceptor.ORBInitInfoPackage;

/**
 * org/omg/PortableInterceptor/ORBInitInfoPackage/DuplicateName.java . Generated
 * by the IDL-to-Java compiler (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/org/omg/PortableInterceptor/Interceptors.idl Friday, July 21, 2017
 * 9:58:52 PM PDT
 */

public final class DuplicateName extends org.omg.CORBA.UserException {

    /**
     * The name for which there was already an interceptor registered.
     */
    public String name = null;

    public DuplicateName() {
        super(DuplicateNameHelper.id());
    } // ctor

    public DuplicateName(String _name) {
        super(DuplicateNameHelper.id());
        name = _name;
    } // ctor

    public DuplicateName(String $reason, String _name) {
        super(DuplicateNameHelper.id() + "  " + $reason);
        name = _name;
    } // ctor

} // class DuplicateName
