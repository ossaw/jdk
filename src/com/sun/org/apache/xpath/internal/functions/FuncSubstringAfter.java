/*
 * Copyright (c) 2007, 2017, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * Copyright 1999-2004 The Apache Software Foundation.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * $Id: FuncSubstringAfter.java,v 1.2.4.1 2005/09/14 20:18:43 jeffsuttor Exp $
 */
package com.sun.org.apache.xpath.internal.functions;

import com.sun.org.apache.xml.internal.utils.XMLString;
import com.sun.org.apache.xpath.internal.XPathContext;
import com.sun.org.apache.xpath.internal.objects.XObject;
import com.sun.org.apache.xpath.internal.objects.XString;

/**
 * Execute the SubstringAfter() function.
 * 
 * @xsl.usage advanced
 */
public class FuncSubstringAfter extends Function2Args {
	static final long serialVersionUID = -8119731889862512194L;

	/**
	 * Execute the function. The function must return a valid object.
	 * 
	 * @param xctxt
	 *              The current execution context.
	 * @return A valid XObject.
	 *
	 * @throws javax.xml.transform.TransformerException
	 */
	public XObject execute(XPathContext xctxt)
			throws javax.xml.transform.TransformerException {

		XMLString s1 = m_arg0.execute(xctxt).xstr();
		XMLString s2 = m_arg1.execute(xctxt).xstr();
		int index = s1.indexOf(s2);

		return (-1 == index) ? XString.EMPTYSTRING
				: (XString) s1.substring(index + s2.length());
	}
}
