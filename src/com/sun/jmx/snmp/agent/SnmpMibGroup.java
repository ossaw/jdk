/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.sun.jmx.snmp.agent;

// java imports
//
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Vector;

// jmx imports
//
import com.sun.jmx.snmp.SnmpVarBind;
import com.sun.jmx.snmp.SnmpStatusException;

/**
 * Represents a node in an SNMP MIB which corresponds to a group. This class
 * allows subnodes to be registered below a group, providing support for nested
 * groups. The subnodes are registered at run time when registering the nested
 * groups in the global MIB OID tree.
 * <P>
 * This class is used by the class generated by <CODE>mibgen</CODE>. You should
 * not need to use this class directly.
 *
 * <p>
 * <b>This API is a Sun Microsystems internal API and is subject to change
 * without notice.</b>
 * </p>
 */

public abstract class SnmpMibGroup extends SnmpMibOid implements Serializable {

    // We will register the OID arcs leading to subgroups in this hashtable.
    // So for each arc in varList, if the arc is also in subgroups, it leads
    // to a subgroup, if it is not in subgroup, it leads either to a table
    // or to a variable.
    protected Hashtable<Long, Long> subgroups = null;

    /**
     * Tells whether the given arc identifies a table in this group.
     *
     * @param arc
     *            An OID arc.
     *
     * @return <CODE>true</CODE> if `arc' leads to a table.
     */
    public abstract boolean isTable(long arc);

    /**
     * Tells whether the given arc identifies a variable (scalar object) in this
     * group.
     *
     * @param arc
     *            An OID arc.
     *
     * @return <CODE>true</CODE> if `arc' leads to a variable.
     */
    public abstract boolean isVariable(long arc);

    /**
     * Tells whether the given arc identifies a readable scalar object in this
     * group.
     *
     * @param arc
     *            An OID arc.
     *
     * @return <CODE>true</CODE> if `arc' leads to a readable variable.
     */
    public abstract boolean isReadable(long arc);

    /**
     * Gets the table identified by the given `arc'.
     *
     * @param arc
     *            An OID arc.
     *
     * @return The <CODE>SnmpMibTable</CODE> identified by `arc', or
     *         <CODE>null</CODE> if `arc' does not identify any table.
     */
    public abstract SnmpMibTable getTable(long arc);

    /**
     * Checks whether the given OID arc identifies a variable (scalar object).
     *
     * @exception If
     *               the given `arc' does not identify any variable in this
     *               group, throws an SnmpStatusException.
     */
    public void validateVarId(long arc, Object userData)
            throws SnmpStatusException {
        if (isVariable(arc) == false) {
            throw new SnmpStatusException(SnmpStatusException.noSuchObject);
        }
    }

    // -------------------------------------------------------------------
    // We use a hashtable (subgroup) in order to determine whether an
    // OID arc leads to a subgroup. This implementation can be changed if
    // needed...
    // For instance, the subclass could provide a generated isNestedArc()
    // method in which the subgroup OID arcs would be hardcoded.
    // However, the generic approach was preferred because at this time
    // groups and subgroups are dynamically registered in the MIB.
    //
    /**
     * Tell whether the given OID arc identifies a sub-tree leading to a nested
     * SNMP sub-group. This method is used internally. You shouldn't need to
     * call it directly.
     *
     * @param arc
     *            An OID arc.
     *
     * @return <CODE>true</CODE> if the given OID arc identifies a subtree
     *         leading to a nested SNMP sub-group.
     *
     */
    public boolean isNestedArc(long arc) {
        if (subgroups == null)
            return false;
        Object obj = subgroups.get(new Long(arc));
        // if the arc is registered in the hashtable,
        // it leads to a subgroup.
        return (obj != null);
    }

    /**
     * Generic handling of the <CODE>get</CODE> operation.
     * <p>
     * The actual implementation of this method will be generated by mibgen.
     * Usually, this implementation only delegates the job to some other
     * provided runtime class, which knows how to access the MBean. The current
     * toolkit thus provides two implementations:
     * <ul>
     * <li>The standard implementation will directly access the MBean through a
     * java reference,</li>
     * <li>The generic implementation will access the MBean through the MBean
     * server.</li>
     * </ul>
     * <p>
     * Both implementations rely upon specific - and distinct, set of mibgen
     * generated methods.
     * <p>
     * You can override this method if you need to implement some specific
     * policies for minimizing the accesses made to some remote underlying
     * resources.
     * <p>
     *
     * @param req
     *              The sub-request that must be handled by this node.
     *
     * @param depth
     *              The depth reached in the OID tree.
     *
     * @exception SnmpStatusException
     *                                An error occurred while accessing the MIB
     *                                node.
     */
    @Override
    abstract public void get(SnmpMibSubRequest req, int depth)
            throws SnmpStatusException;

    /**
     * Generic handling of the <CODE>set</CODE> operation.
     * <p>
     * The actual implementation of this method will be generated by mibgen.
     * Usually, this implementation only delegates the job to some other
     * provided runtime class, which knows how to access the MBean. The current
     * toolkit thus provides two implementations:
     * <ul>
     * <li>The standard implementation will directly access the MBean through a
     * java reference,</li>
     * <li>The generic implementation will access the MBean through the MBean
     * server.</li>
     * </ul>
     * <p>
     * Both implementations rely upon specific - and distinct, set of mibgen
     * generated methods.
     * <p>
     * You can override this method if you need to implement some specific
     * policies for minimizing the accesses made to some remote underlying
     * resources.
     * <p>
     *
     * @param req
     *              The sub-request that must be handled by this node.
     *
     * @param depth
     *              The depth reached in the OID tree.
     *
     * @exception SnmpStatusException
     *                                An error occurred while accessing the MIB
     *                                node.
     */
    @Override
    abstract public void set(SnmpMibSubRequest req, int depth)
            throws SnmpStatusException;

    /**
     * Generic handling of the <CODE>check</CODE> operation.
     *
     * <p>
     * The actual implementation of this method will be generated by mibgen.
     * Usually, this implementation only delegates the job to some other
     * provided runtime class, which knows how to access the MBean. The current
     * toolkit thus provides two implementations:
     * <ul>
     * <li>The standard implementation will directly access the MBean through a
     * java reference,</li>
     * <li>The generic implementation will access the MBean through the MBean
     * server.</li>
     * </ul>
     * <p>
     * Both implementations rely upon specific - and distinct, set of mibgen
     * generated methods.
     * <p>
     * You can override this method if you need to implement some specific
     * policies for minimizing the accesses made to some remote underlying
     * resources, or if you need to implement some consistency checks between
     * the different values provided in the varbind list.
     * <p>
     *
     * @param req
     *              The sub-request that must be handled by this node.
     *
     * @param depth
     *              The depth reached in the OID tree.
     *
     * @exception SnmpStatusException
     *                                An error occurred while accessing the MIB
     *                                node.
     */
    @Override
    abstract public void check(SnmpMibSubRequest req, int depth)
            throws SnmpStatusException;

    // --------------------------------------------------------------------
    // If we reach this node, we are below the root OID, so we just
    // return.
    // --------------------------------------------------------------------
    @Override
    public void getRootOid(Vector<Integer> result) {}

    // -------------------------------------------------------------------
    // PACKAGE METHODS
    // -------------------------------------------------------------------

    // -------------------------------------------------------------------
    // This method can also be overriden in a subclass to provide a
    // different implementation of the isNestedArc() method.
    // => if isNestedArc() is hardcoded, then registerSubArc() becomes
    // useless and can become empty.
    /**
     * Register an OID arc that identifies a sub-tree leading to a nested SNMP
     * sub-group. This method is used internally. You shouldn't ever call it
     * directly.
     *
     * @param arc
     *            An OID arc.
     *
     */
    void registerNestedArc(long arc) {
        Long obj = new Long(arc);
        if (subgroups == null)
            subgroups = new Hashtable<>();
        // registers the arc in the hashtable.
        subgroups.put(obj, obj);
    }

    // -------------------------------------------------------------------
    // The SnmpMibOid algorithm relies on the fact that for every arc
    // registered in varList, there is a corresponding node at the same
    // position in children.
    // So the trick is to register a null node in children for each variable
    // in varList, so that the real subgroup nodes can be inserted at the
    // correct location.
    // registerObject() should be called for each scalar object and each
    // table arc by the generated subclass.
    /**
     * Register an OID arc that identifies a scalar object or a table. This
     * method is used internally. You shouldn't ever call it directly.
     *
     * @param arc
     *            An OID arc.
     *
     */
    protected void registerObject(long arc) throws IllegalAccessException {

        // this will register the variable in both varList and children
        // The node registered in children will be null, so that the parent
        // algorithm will behave as if no node were registered. This is a
        // trick that makes the parent algorithm behave as if only subgroups
        // were registered in varList and children.
        long[] oid = new long[1];
        oid[0] = arc;
        super.registerNode(oid, 0, null);
    }

    // -------------------------------------------------------------------
    // registerNode() will be called at runtime when nested groups are
    // registered in the MIB. So we do know that this method will only
    // be called to register nested-groups.
    // We trap registerNode() in order to call registerSubArc()
    /**
     * Register a child node of this node in the OID tree. This method is used
     * internally. You shouldn't ever call it directly.
     *
     * @param oid
     *               The oid of the node being registered.
     * @param cursor
     *               The position reached in the oid.
     * @param node
     *               The node being registered.
     *
     */
    @Override
    void registerNode(long[] oid, int cursor, SnmpMibNode node)
            throws IllegalAccessException {
        super.registerNode(oid, cursor, node);
        if (cursor < 0)
            return;
        if (cursor >= oid.length)
            return;
        // if we get here, then it means we are registering a subgroup.
        // We will thus register the sub arc in the subgroups hashtable.
        registerNestedArc(oid[cursor]);
    }

    // -------------------------------------------------------------------
    // see comments in SnmpMibNode
    // -------------------------------------------------------------------
    @Override
    void findHandlingNode(SnmpVarBind varbind, long[] oid, int depth,
            SnmpRequestTree handlers) throws SnmpStatusException {

        int length = oid.length;

        if (handlers == null)
            throw new SnmpStatusException(SnmpStatusException.snmpRspGenErr);

        final Object data = handlers.getUserData();

        if (depth >= length) {
            // Nothing is left... the oid is not valid
            throw new SnmpStatusException(SnmpStatusException.noAccess);
        }

        long arc = oid[depth];

        if (isNestedArc(arc)) {
            // This arc leads to a subgroup: delegates the search to the
            // method defined in SnmpMibOid
            super.findHandlingNode(varbind, oid, depth, handlers);
        } else if (isTable(arc)) {
            // This arc leads to a table: forward the search to the table.

            // Gets the table
            SnmpMibTable table = getTable(arc);

            // Forward the search to the table
            table.findHandlingNode(varbind, oid, depth + 1, handlers);

        } else {
            // If it's not a variable, throws an exception
            validateVarId(arc, data);

            // The trailing .0 is missing in the OID
            if (depth + 2 > length) {
                throw new SnmpStatusException(
                        SnmpStatusException.noSuchInstance);
            }

            // There are too many arcs left in the OID (there should remain
            // a single trailing .0)
            if (depth + 2 < length) {
                throw new SnmpStatusException(
                        SnmpStatusException.noSuchInstance);
            }

            // The last trailing arc is not .0
            if (oid[depth + 1] != 0L) {
                throw new SnmpStatusException(
                        SnmpStatusException.noSuchInstance);
            }

            // It's one of our variable, register this node.
            handlers.add(this, depth, varbind);
        }
    }

    // -------------------------------------------------------------------
    // See comments in SnmpMibNode.
    // -------------------------------------------------------------------
    @Override
    long[] findNextHandlingNode(SnmpVarBind varbind, long[] oid, int pos,
            int depth, SnmpRequestTree handlers, AcmChecker checker)
            throws SnmpStatusException {

        int length = oid.length;
        SnmpMibNode node = null;

        if (handlers == null) {
            // This should be considered as a genErr, but we do not want to
            // abort the whole request, so we're going to throw
            // a noSuchObject...
            //
            throw new SnmpStatusException(SnmpStatusException.noSuchObject);
        }

        final Object data = handlers.getUserData();
        final int pduVersion = handlers.getRequestPduVersion();

        // The generic case where the end of the OID has been reached is
        // handled in the superclass
        // XXX Revisit: this works but it is somewhat convoluted. Just setting
        // arc to -1 would work too.
        if (pos >= length)
            return super.findNextHandlingNode(varbind, oid, pos, depth,
                    handlers, checker);

        // Ok, we've got the arc.
        long arc = oid[pos];

        long[] result = null;

        // We have a recursive logic. Should we have a loop instead?
        try {

            if (isTable(arc)) {
                // If the arc identifies a table, then we need to forward
                // the search to the table.

                // Gets the table identified by `arc'
                SnmpMibTable table = getTable(arc);

                // Forward to the table
                checker.add(depth, arc);
                try {
                    result = table.findNextHandlingNode(varbind, oid, pos + 1,
                            depth + 1, handlers, checker);
                } catch (SnmpStatusException ex) {
                    throw new SnmpStatusException(
                            SnmpStatusException.noSuchObject);
                } finally {
                    checker.remove(depth);
                }
                // Build up the leaf OID
                result[depth] = arc;
                return result;
            } else if (isReadable(arc)) {
                // If the arc identifies a readable variable, then two cases:

                if (pos == (length - 1)) {
                    // The end of the OID is reached, so we return the leaf
                    // corresponding to the variable identified by `arc'

                    // Build up the OID
                    // result = new SnmpOid(0);
                    // result.insert((int)arc);
                    result = new long[depth + 2];
                    result[depth + 1] = 0L;
                    result[depth] = arc;

                    checker.add(depth, result, depth, 2);
                    try {
                        checker.checkCurrentOid();
                    } catch (SnmpStatusException e) {
                        throw new SnmpStatusException(
                                SnmpStatusException.noSuchObject);
                    } finally {
                        checker.remove(depth, 2);
                    }

                    // Registers this node
                    handlers.add(this, depth, varbind);
                    return result;
                }

                // The end of the OID is not yet reached, so we must return
                // the next leaf following the variable identified by `arc'.
                // We cannot return the variable because whatever follows in
                // the OID will be greater or equals to 0, and 0 identifies
                // the variable itself - so we have indeed to return the
                // next object.
                // So we do nothing, because this case is handled at the
                // end of the if ... else if ... else ... block.

            } else if (isNestedArc(arc)) {
                // Now if the arc leads to a subgroup, we delegate the
                // search to the child, just as done in SnmpMibNode.
                //

                // get the child ( = nested arc node).
                //
                final SnmpMibNode child = getChild(arc);

                if (child != null) {
                    checker.add(depth, arc);
                    try {
                        result = child.findNextHandlingNode(varbind, oid, pos
                                + 1, depth + 1, handlers, checker);
                        result[depth] = arc;
                        return result;
                    } finally {
                        checker.remove(depth);
                    }
                }
            }

            // The oid is not valid, we will throw an exception in order
            // to try with the next valid identifier...
            //
            throw new SnmpStatusException(SnmpStatusException.noSuchObject);

        } catch (SnmpStatusException e) {
            // We didn't find anything at the given arc, so we're going
            // to try with the next valid arc
            //
            long[] newOid = new long[1];
            newOid[0] = getNextVarId(arc, data, pduVersion);
            return findNextHandlingNode(varbind, newOid, 0, depth, handlers,
                    checker);
        }
    }

}
