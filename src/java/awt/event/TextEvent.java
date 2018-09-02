/*
 * Copyright (c) 1996, 2008, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.awt.event;

import java.awt.AWTEvent;

/**
 * A semantic event which indicates that an object's text changed. This
 * high-level event is generated by an object (such as a TextComponent) when its
 * text changes. The event is passed to every <code>TextListener</code> object
 * which registered to receive such events using the component's
 * <code>addTextListener</code> method.
 * <P>
 * The object that implements the <code>TextListener</code> interface gets this
 * <code>TextEvent</code> when the event occurs. The listener is spared the
 * details of processing individual mouse movements and key strokes Instead, it
 * can process a "meaningful" (semantic) event like "text changed".
 * <p>
 * An unspecified behavior will be caused if the {@code id} parameter of any
 * particular {@code TextEvent} instance is not in the range from
 * {@code TEXT_FIRST} to {@code TEXT_LAST}.
 *
 * @author Georges Saab
 *
 * @see java.awt.TextComponent
 * @see TextListener
 *
 * @since 1.1
 */

public class TextEvent extends AWTEvent {

	/**
	 * The first number in the range of ids used for text events.
	 */
	public static final int TEXT_FIRST = 900;

	/**
	 * The last number in the range of ids used for text events.
	 */
	public static final int TEXT_LAST = 900;

	/**
	 * This event id indicates that object's text changed.
	 */
	public static final int TEXT_VALUE_CHANGED = TEXT_FIRST;

	/*
	 * JDK 1.1 serialVersionUID
	 */
	private static final long serialVersionUID = 6269902291250941179L;

	/**
	 * Constructs a <code>TextEvent</code> object.
	 * <p>
	 * This method throws an <code>IllegalArgumentException</code> if
	 * <code>source</code> is <code>null</code>.
	 *
	 * @param source
	 *               The (<code>TextComponent</code>) object that originated the
	 *               event
	 * @param id
	 *               An integer that identifies the event type. For information
	 *               on
	 *               allowable values, see the class description for
	 *               {@link TextEvent}
	 * @throws IllegalArgumentException
	 *                                  if <code>source</code> is null
	 * @see #getSource()
	 * @see #getID()
	 */
	public TextEvent(Object source, int id) {
		super(source, id);
	}

	/**
	 * Returns a parameter string identifying this text event. This method is
	 * useful for event-logging and for debugging.
	 *
	 * @return a string identifying the event and its attributes
	 */
	public String paramString() {
		String typeStr;
		switch (id) {
			case TEXT_VALUE_CHANGED:
				typeStr = "TEXT_VALUE_CHANGED";
				break;
			default:
				typeStr = "unknown type";
		}
		return typeStr;
	}
}
