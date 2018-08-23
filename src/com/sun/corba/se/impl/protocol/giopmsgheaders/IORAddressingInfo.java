/*
 * Copyright (c) 2000, 2003, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.corba.se.impl.protocol.giopmsgheaders;

/**
 * com/sun/corba/se/impl/protocol/giopmsgheaders/IORAddressingInfo.java
 * Generated by the IDL-to-Java compiler (portable), version "3.0" from
 * ../../../../../../../src/share/classes/com/sun/corba/se/GiopIDL/g.idl Sunday,
 * June 4, 2000 5:18:54 PM PDT
 */

public final class IORAddressingInfo implements org.omg.CORBA.portable.IDLEntity {
	public int selected_profile_index = (int) 0;
	public org.omg.IOP.IOR ior = null;

	public IORAddressingInfo() {
	} // ctor

	public IORAddressingInfo(int _selected_profile_index, org.omg.IOP.IOR _ior) {
		selected_profile_index = _selected_profile_index;
		ior = _ior;
	} // ctor

} // class IORAddressingInfo
