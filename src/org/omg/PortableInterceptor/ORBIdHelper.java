package org.omg.PortableInterceptor;

/**
 * org/omg/PortableInterceptor/ORBIdHelper.java . Generated by the IDL-to-Java
 * compiler (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/org/omg/PortableInterceptor/Interceptors.idl Friday, July 21, 2017
 * 9:58:52 PM PDT
 */

// This should actually be the CORBA::ORBid type once that is available
abstract public class ORBIdHelper {
    private static String _id = "IDL:omg.org/PortableInterceptor/ORBId:1.0";

    public static void insert(org.omg.CORBA.Any a, String that) {
        org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
        a.type(type());
        write(out, that);
        a.read_value(out.create_input_stream(), type());
    }

    public static String extract(org.omg.CORBA.Any a) {
        return read(a.create_input_stream());
    }

    private static org.omg.CORBA.TypeCode __typeCode = null;

    synchronized public static org.omg.CORBA.TypeCode type() {
        if (__typeCode == null) {
            __typeCode = org.omg.CORBA.ORB.init().create_string_tc(0);
            __typeCode = org.omg.CORBA.ORB.init().create_alias_tc(
                    org.omg.PortableInterceptor.ORBIdHelper.id(), "ORBId",
                    __typeCode);
        }
        return __typeCode;
    }

    public static String id() {
        return _id;
    }

    public static String read(org.omg.CORBA.portable.InputStream istream) {
        String value = null;
        value = istream.read_string();
        return value;
    }

    public static void write(org.omg.CORBA.portable.OutputStream ostream,
            String value) {
        ostream.write_string(value);
    }

}
