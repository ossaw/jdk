/*
 * Copyright (c) 2000, 2012, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/* Generated By:JJTree: Do not edit this line. JDMInformBlock.java */

package com.sun.jmx.snmp.IPAcl;

import java.net.InetAddress;
import java.util.Hashtable;
import java.util.Vector;

class JDMInformBlock extends SimpleNode {
    JDMInformBlock(int id) {
        super(id);
    }

    JDMInformBlock(Parser p, int id) {
        super(p, id);
    }

    public static Node jjtCreate(int id) {
        return new JDMInformBlock(id);
    }

    public static Node jjtCreate(Parser p, int id) {
        return new JDMInformBlock(p, id);
    }

    /**
     * Do no need to go through this part of the tree for building AclEntry.
     */
    @Override
    public void buildAclEntries(PrincipalImpl owner, AclImpl acl) {}

    /**
     * Do no need to go through this part of the tree for building TrapEntry.
     */
    @Override
    public void buildTrapEntries(Hashtable<InetAddress, Vector<String>> dest) {}
}
