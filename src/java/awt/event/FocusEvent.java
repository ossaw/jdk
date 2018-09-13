/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.awt.event;

import java.awt.Component;
import sun.awt.AppContext;
import sun.awt.SunToolkit;

/**
 * A low-level event which indicates that a Component has gained or lost the
 * input focus. This low-level event is generated by a Component (such as a
 * TextField). The event is passed to every <code>FocusListener</code> or
 * <code>FocusAdapter</code> object which registered to receive such events
 * using the Component's <code>addFocusListener</code> method. (<code>
 * FocusAdapter</code> objects implement the <code>FocusListener</code>
 * interface.) Each such listener object gets this <code>FocusEvent</code> when
 * the event occurs.
 * <p>
 * There are two levels of focus events: permanent and temporary. Permanent
 * focus change events occur when focus is directly moved from one Component to
 * another, such as through a call to requestFocus() or as the user uses the TAB
 * key to traverse Components. Temporary focus change events occur when focus is
 * temporarily lost for a Component as the indirect result of another operation,
 * such as Window deactivation or a Scrollbar drag. In this case, the original
 * focus state will automatically be restored once that operation is finished,
 * or, for the case of Window deactivation, when the Window is reactivated. Both
 * permanent and temporary focus events are delivered using the FOCUS_GAINED and
 * FOCUS_LOST event ids; the level may be distinguished in the event using the
 * isTemporary() method.
 * <p>
 * An unspecified behavior will be caused if the {@code id} parameter of any
 * particular {@code FocusEvent} instance is not in the range from
 * {@code FOCUS_FIRST} to {@code FOCUS_LAST}.
 *
 * @see FocusAdapter
 * @see FocusListener
 * @see <a href=
 *      "https://docs.oracle.com/javase/tutorial/uiswing/events/focuslistener.html">
 *      Tutorial: Writing a Focus Listener</a>
 *
 * @author Carl Quinn
 * @author Amy Fowler
 * @since 1.1
 */
public class FocusEvent extends ComponentEvent {

	/**
	 * The first number in the range of ids used for focus events.
	 */
	public static final int FOCUS_FIRST = 1004;

	/**
	 * The last number in the range of ids used for focus events.
	 */
	public static final int FOCUS_LAST = 1005;

	/**
	 * This event indicates that the Component is now the focus owner.
	 */
	public static final int FOCUS_GAINED = FOCUS_FIRST; // Event.GOT_FOCUS

	/**
	 * This event indicates that the Component is no longer the focus owner.
	 */
	public static final int FOCUS_LOST = 1 + FOCUS_FIRST; // Event.LOST_FOCUS

	/**
	 * A focus event can have two different levels, permanent and temporary. It
	 * will be set to true if some operation takes away the focus temporarily
	 * and intends on getting it back once the event is completed. Otherwise it
	 * will be set to false.
	 *
	 * @serial
	 * @see #isTemporary
	 */
	boolean temporary;

	/**
	 * The other Component involved in this focus change. For a FOCUS_GAINED
	 * event, this is the Component that lost focus. For a FOCUS_LOST event,
	 * this is the Component that gained focus. If this focus change occurs with
	 * a native application, a Java application in a different VM, or with no
	 * other Component, then the opposite Component is null.
	 *
	 * @see #getOppositeComponent
	 * @since 1.4
	 */
	transient Component opposite;

	/*
	 * JDK 1.1 serialVersionUID
	 */
	private static final long serialVersionUID = 523753786457416396L;

	/**
	 * Constructs a <code>FocusEvent</code> object with the specified temporary
	 * state and opposite <code>Component</code>. The opposite
	 * <code>Component</code> is the other <code>Component</code> involved in
	 * this focus change. For a <code>FOCUS_GAINED</code> event, this is the
	 * <code>Component</code> that lost focus. For a <code>FOCUS_LOST</code>
	 * event, this is the <code>Component</code> that gained focus. If this
	 * focus change occurs with a native application, with a Java application in
	 * a different VM, or with no other <code>Component</code>, then the
	 * opposite <code>Component</code> is <code>null</code>.
	 * <p>
	 * This method throws an <code>IllegalArgumentException</code> if
	 * <code>source</code> is <code>null</code>.
	 *
	 * @param source
	 *                  The <code>Component</code> that originated the event
	 * @param id
	 *                  An integer indicating the type of event. For information
	 *                  on
	 *                  allowable values, see the class description for
	 *                  {@link FocusEvent}
	 * @param temporary
	 *                  Equals <code>true</code> if the focus change is
	 *                  temporary;
	 *                  <code>false</code> otherwise
	 * @param opposite
	 *                  The other Component involved in the focus change, or
	 *                  <code>null</code>
	 * @throws IllegalArgumentException
	 *                                  if <code>source</code> equals
	 *                                  {@code null}
	 * @see #getSource()
	 * @see #getID()
	 * @see #isTemporary()
	 * @see #getOppositeComponent()
	 * @since 1.4
	 */
	public FocusEvent(Component source, int id, boolean temporary,
			Component opposite) {
		super(source, id);
		this.temporary = temporary;
		this.opposite = opposite;
	}

	/**
	 * Constructs a <code>FocusEvent</code> object and identifies whether or not
	 * the change is temporary.
	 * <p>
	 * This method throws an <code>IllegalArgumentException</code> if
	 * <code>source</code> is <code>null</code>.
	 *
	 * @param source
	 *                  The <code>Component</code> that originated the event
	 * @param id
	 *                  An integer indicating the type of event. For information
	 *                  on
	 *                  allowable values, see the class description for
	 *                  {@link FocusEvent}
	 * @param temporary
	 *                  Equals <code>true</code> if the focus change is
	 *                  temporary;
	 *                  <code>false</code> otherwise
	 * @throws IllegalArgumentException
	 *                                  if <code>source</code> equals
	 *                                  {@code null}
	 * @see #getSource()
	 * @see #getID()
	 * @see #isTemporary()
	 */
	public FocusEvent(Component source, int id, boolean temporary) {
		this(source, id, temporary, null);
	}

	/**
	 * Constructs a <code>FocusEvent</code> object and identifies it as a
	 * permanent change in focus.
	 * <p>
	 * This method throws an <code>IllegalArgumentException</code> if
	 * <code>source</code> is <code>null</code>.
	 *
	 * @param source
	 *               The <code>Component</code> that originated the event
	 * @param id
	 *               An integer indicating the type of event. For information on
	 *               allowable values, see the class description for
	 *               {@link FocusEvent}
	 * @throws IllegalArgumentException
	 *                                  if <code>source</code> equals
	 *                                  {@code null}
	 * @see #getSource()
	 * @see #getID()
	 */
	public FocusEvent(Component source, int id) {
		this(source, id, false);
	}

	/**
	 * Identifies the focus change event as temporary or permanent.
	 *
	 * @return <code>true</code> if the focus change is temporary;
	 *         <code>false</code> otherwise
	 */
	public boolean isTemporary() {
		return temporary;
	}

	/**
	 * Returns the other Component involved in this focus change. For a
	 * FOCUS_GAINED event, this is the Component that lost focus. For a
	 * FOCUS_LOST event, this is the Component that gained focus. If this focus
	 * change occurs with a native application, with a Java application in a
	 * different VM or context, or with no other Component, then null is
	 * returned.
	 *
	 * @return the other Component involved in the focus change, or null
	 * @since 1.4
	 */
	public Component getOppositeComponent() {
		if (opposite == null) {
			return null;
		}

		return (SunToolkit.targetToAppContext(opposite) == AppContext
				.getAppContext()) ? opposite : null;
	}

	/**
	 * Returns a parameter string identifying this event. This method is useful
	 * for event-logging and for debugging.
	 *
	 * @return a string identifying the event and its attributes
	 */
	public String paramString() {
		String typeStr;
		switch (id) {
			case FOCUS_GAINED:
				typeStr = "FOCUS_GAINED";
				break;
			case FOCUS_LOST:
				typeStr = "FOCUS_LOST";
				break;
			default:
				typeStr = "unknown type";
		}
		return typeStr + (temporary ? ",temporary" : ",permanent")
				+ ",opposite=" + getOppositeComponent();
	}

}
