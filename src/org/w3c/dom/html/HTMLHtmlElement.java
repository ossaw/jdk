/*
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/*
 * Copyright (c) 2000 World Wide Web Consortium,
 * (Massachusetts Institute of Technology, Institut National de
 * Recherche en Informatique et en Automatique, Keio University). All
 * Rights Reserved. This program is distributed under the W3C's Software
 * Intellectual Property License. This program is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE. See W3C License http://www.w3.org/Consortium/Legal/ for more
 * details.
 */

package org.w3c.dom.html;

/**
 * Root of an HTML document. See the HTML element definition in HTML 4.0.
 * <p>
 * See also the
 * <a href='http://www.w3.org/TR/2000/CR-DOM-Level-2-20000510'>Document Object
 * Model (DOM) Level 2 Specification</a>.
 */
public interface HTMLHtmlElement extends HTMLElement {
	/**
	 * Version information about the document's DTD. See the version attribute
	 * definition in HTML 4.0. This attribute is deprecated in HTML 4.0.
	 */
	public String getVersion();

	public void setVersion(String version);

}
