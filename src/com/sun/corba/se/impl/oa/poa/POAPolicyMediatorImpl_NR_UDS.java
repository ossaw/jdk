/*
 * Copyright (c) 2002, 2003, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.corba.se.impl.oa.poa;

import java.util.Enumeration;

import org.omg.PortableServer.Servant;
import org.omg.PortableServer.ServantManager;
import org.omg.PortableServer.ForwardRequest;
import org.omg.PortableServer.POAPackage.WrongPolicy;
import org.omg.PortableServer.POAPackage.ObjectNotActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.ObjectAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.NoServant;

import com.sun.corba.se.impl.orbutil.concurrent.SyncUtil;
import com.sun.corba.se.impl.orbutil.ORBUtility;
import com.sun.corba.se.impl.orbutil.ORBConstants;

/**
 * Implementation of POAPolicyMediator that provides policy specific operations
 * on the POA.
 */
public class POAPolicyMediatorImpl_NR_UDS extends POAPolicyMediatorBase {
    private Servant defaultServant;

    POAPolicyMediatorImpl_NR_UDS(Policies policies, POAImpl poa) {
        super(policies, poa);

        // assert !policies.retainServants() && policies.useDefaultServant()
        if (policies.retainServants())
            throw poa.invocationWrapper().policyMediatorBadPolicyInFactory();

        if (!policies.useDefaultServant())
            throw poa.invocationWrapper().policyMediatorBadPolicyInFactory();

        defaultServant = null;
    }

    protected java.lang.Object internalGetServant(byte[] id, String operation) throws ForwardRequest {
        if (defaultServant == null)
            throw poa.invocationWrapper().poaNoDefaultServant();

        return defaultServant;
    }

    public void returnServant() {
        // NO-OP
    }

    public void etherealizeAll() {
        // NO-OP
    }

    public void clearAOM() {
        // NO-OP
    }

    public ServantManager getServantManager() throws WrongPolicy {
        throw new WrongPolicy();
    }

    public void setServantManager(ServantManager servantManager) throws WrongPolicy {
        throw new WrongPolicy();
    }

    public Servant getDefaultServant() throws NoServant, WrongPolicy {
        if (defaultServant == null)
            throw new NoServant();
        return defaultServant;
    }

    public void setDefaultServant(Servant servant) throws WrongPolicy {
        this.defaultServant = servant;
        setDelegate(defaultServant, "DefaultServant".getBytes());
    }

    public final void activateObject(byte[] id, Servant servant) throws WrongPolicy, ServantAlreadyActive,
            ObjectAlreadyActive {
        throw new WrongPolicy();
    }

    public Servant deactivateObject(byte[] id) throws ObjectNotActive, WrongPolicy {
        throw new WrongPolicy();
    }

    public byte[] servantToId(Servant servant) throws ServantNotActive, WrongPolicy {
        throw new WrongPolicy();
    }

    public Servant idToServant(byte[] id) throws WrongPolicy, ObjectNotActive {
        if (defaultServant != null)
            return defaultServant;

        throw new ObjectNotActive();
    }
}
