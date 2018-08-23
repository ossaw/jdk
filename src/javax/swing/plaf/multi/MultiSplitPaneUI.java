/*
 * Copyright (c) 1997, 2001, Oracle and/or its affiliates. All rights reserved.
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
package javax.swing.plaf.multi;

import java.util.Vector;
import javax.swing.plaf.SplitPaneUI;
import javax.swing.JSplitPane;
import java.awt.Graphics;
import javax.swing.plaf.ComponentUI;
import javax.swing.JComponent;
import java.awt.Dimension;
import javax.accessibility.Accessible;

/**
 * A multiplexing UI used to combine <code>SplitPaneUI</code>s.
 *
 * <p>
 * This file was automatically generated by AutoMulti.
 *
 * @author Otto Multey
 */
public class MultiSplitPaneUI extends SplitPaneUI {

	/**
	 * The vector containing the real UIs. This is populated in the call to
	 * <code>createUI</code>, and can be obtained by calling the
	 * <code>getUIs</code> method. The first element is guaranteed to be the
	 * real UI obtained from the default look and feel.
	 */
	protected Vector uis = new Vector();

	////////////////////
	// Common UI methods
	////////////////////

	/**
	 * Returns the list of UIs associated with this multiplexing UI. This allows
	 * processing of the UIs by an application aware of multiplexing UIs on
	 * components.
	 */
	public ComponentUI[] getUIs() {
		return MultiLookAndFeel.uisToArray(uis);
	}

	////////////////////
	// SplitPaneUI methods
	////////////////////

	/**
	 * Invokes the <code>resetToPreferredSizes</code> method on each UI handled
	 * by this object.
	 */
	public void resetToPreferredSizes(JSplitPane a) {
		for (int i = 0; i < uis.size(); i++) {
			((SplitPaneUI) (uis.elementAt(i))).resetToPreferredSizes(a);
		}
	}

	/**
	 * Invokes the <code>setDividerLocation</code> method on each UI handled by
	 * this object.
	 */
	public void setDividerLocation(JSplitPane a, int b) {
		for (int i = 0; i < uis.size(); i++) {
			((SplitPaneUI) (uis.elementAt(i))).setDividerLocation(a, b);
		}
	}

	/**
	 * Invokes the <code>getDividerLocation</code> method on each UI handled by
	 * this object.
	 *
	 * @return the value obtained from the first UI, which is the UI obtained
	 *         from the default <code>LookAndFeel</code>
	 */
	public int getDividerLocation(JSplitPane a) {
		int returnValue = ((SplitPaneUI) (uis.elementAt(0))).getDividerLocation(a);
		for (int i = 1; i < uis.size(); i++) {
			((SplitPaneUI) (uis.elementAt(i))).getDividerLocation(a);
		}
		return returnValue;
	}

	/**
	 * Invokes the <code>getMinimumDividerLocation</code> method on each UI
	 * handled by this object.
	 *
	 * @return the value obtained from the first UI, which is the UI obtained
	 *         from the default <code>LookAndFeel</code>
	 */
	public int getMinimumDividerLocation(JSplitPane a) {
		int returnValue = ((SplitPaneUI) (uis.elementAt(0))).getMinimumDividerLocation(a);
		for (int i = 1; i < uis.size(); i++) {
			((SplitPaneUI) (uis.elementAt(i))).getMinimumDividerLocation(a);
		}
		return returnValue;
	}

	/**
	 * Invokes the <code>getMaximumDividerLocation</code> method on each UI
	 * handled by this object.
	 *
	 * @return the value obtained from the first UI, which is the UI obtained
	 *         from the default <code>LookAndFeel</code>
	 */
	public int getMaximumDividerLocation(JSplitPane a) {
		int returnValue = ((SplitPaneUI) (uis.elementAt(0))).getMaximumDividerLocation(a);
		for (int i = 1; i < uis.size(); i++) {
			((SplitPaneUI) (uis.elementAt(i))).getMaximumDividerLocation(a);
		}
		return returnValue;
	}

	/**
	 * Invokes the <code>finishedPaintingChildren</code> method on each UI
	 * handled by this object.
	 */
	public void finishedPaintingChildren(JSplitPane a, Graphics b) {
		for (int i = 0; i < uis.size(); i++) {
			((SplitPaneUI) (uis.elementAt(i))).finishedPaintingChildren(a, b);
		}
	}

	////////////////////
	// ComponentUI methods
	////////////////////

	/**
	 * Invokes the <code>contains</code> method on each UI handled by this
	 * object.
	 *
	 * @return the value obtained from the first UI, which is the UI obtained
	 *         from the default <code>LookAndFeel</code>
	 */
	public boolean contains(JComponent a, int b, int c) {
		boolean returnValue = ((ComponentUI) (uis.elementAt(0))).contains(a, b, c);
		for (int i = 1; i < uis.size(); i++) {
			((ComponentUI) (uis.elementAt(i))).contains(a, b, c);
		}
		return returnValue;
	}

	/**
	 * Invokes the <code>update</code> method on each UI handled by this object.
	 */
	public void update(Graphics a, JComponent b) {
		for (int i = 0; i < uis.size(); i++) {
			((ComponentUI) (uis.elementAt(i))).update(a, b);
		}
	}

	/**
	 * Returns a multiplexing UI instance if any of the auxiliary
	 * <code>LookAndFeel</code>s supports this UI. Otherwise, just returns the
	 * UI object obtained from the default <code>LookAndFeel</code>.
	 */
	public static ComponentUI createUI(JComponent a) {
		ComponentUI mui = new MultiSplitPaneUI();
		return MultiLookAndFeel.createUIs(mui, ((MultiSplitPaneUI) mui).uis, a);
	}

	/**
	 * Invokes the <code>installUI</code> method on each UI handled by this
	 * object.
	 */
	public void installUI(JComponent a) {
		for (int i = 0; i < uis.size(); i++) {
			((ComponentUI) (uis.elementAt(i))).installUI(a);
		}
	}

	/**
	 * Invokes the <code>uninstallUI</code> method on each UI handled by this
	 * object.
	 */
	public void uninstallUI(JComponent a) {
		for (int i = 0; i < uis.size(); i++) {
			((ComponentUI) (uis.elementAt(i))).uninstallUI(a);
		}
	}

	/**
	 * Invokes the <code>paint</code> method on each UI handled by this object.
	 */
	public void paint(Graphics a, JComponent b) {
		for (int i = 0; i < uis.size(); i++) {
			((ComponentUI) (uis.elementAt(i))).paint(a, b);
		}
	}

	/**
	 * Invokes the <code>getPreferredSize</code> method on each UI handled by
	 * this object.
	 *
	 * @return the value obtained from the first UI, which is the UI obtained
	 *         from the default <code>LookAndFeel</code>
	 */
	public Dimension getPreferredSize(JComponent a) {
		Dimension returnValue = ((ComponentUI) (uis.elementAt(0))).getPreferredSize(a);
		for (int i = 1; i < uis.size(); i++) {
			((ComponentUI) (uis.elementAt(i))).getPreferredSize(a);
		}
		return returnValue;
	}

	/**
	 * Invokes the <code>getMinimumSize</code> method on each UI handled by this
	 * object.
	 *
	 * @return the value obtained from the first UI, which is the UI obtained
	 *         from the default <code>LookAndFeel</code>
	 */
	public Dimension getMinimumSize(JComponent a) {
		Dimension returnValue = ((ComponentUI) (uis.elementAt(0))).getMinimumSize(a);
		for (int i = 1; i < uis.size(); i++) {
			((ComponentUI) (uis.elementAt(i))).getMinimumSize(a);
		}
		return returnValue;
	}

	/**
	 * Invokes the <code>getMaximumSize</code> method on each UI handled by this
	 * object.
	 *
	 * @return the value obtained from the first UI, which is the UI obtained
	 *         from the default <code>LookAndFeel</code>
	 */
	public Dimension getMaximumSize(JComponent a) {
		Dimension returnValue = ((ComponentUI) (uis.elementAt(0))).getMaximumSize(a);
		for (int i = 1; i < uis.size(); i++) {
			((ComponentUI) (uis.elementAt(i))).getMaximumSize(a);
		}
		return returnValue;
	}

	/**
	 * Invokes the <code>getAccessibleChildrenCount</code> method on each UI
	 * handled by this object.
	 *
	 * @return the value obtained from the first UI, which is the UI obtained
	 *         from the default <code>LookAndFeel</code>
	 */
	public int getAccessibleChildrenCount(JComponent a) {
		int returnValue = ((ComponentUI) (uis.elementAt(0))).getAccessibleChildrenCount(a);
		for (int i = 1; i < uis.size(); i++) {
			((ComponentUI) (uis.elementAt(i))).getAccessibleChildrenCount(a);
		}
		return returnValue;
	}

	/**
	 * Invokes the <code>getAccessibleChild</code> method on each UI handled by
	 * this object.
	 *
	 * @return the value obtained from the first UI, which is the UI obtained
	 *         from the default <code>LookAndFeel</code>
	 */
	public Accessible getAccessibleChild(JComponent a, int b) {
		Accessible returnValue = ((ComponentUI) (uis.elementAt(0))).getAccessibleChild(a, b);
		for (int i = 1; i < uis.size(); i++) {
			((ComponentUI) (uis.elementAt(i))).getAccessibleChild(a, b);
		}
		return returnValue;
	}
}
