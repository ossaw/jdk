/*
 * Copyright (c) 2007, 2017, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * Copyright 2001-2004 The Apache Software Foundation.
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
 * $Id: NumberCall.java,v 1.2.4.1 2005/09/02 10:39:10 pvedula Exp $
 */

package com.sun.org.apache.xalan.internal.xsltc.compiler;

import java.util.Vector;

import com.sun.org.apache.bcel.internal.generic.InstructionList;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ClassGenerator;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MethodGenerator;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.TypeCheckError;

/**
 * @author Jacek Ambroziak
 * @author Santiago Pericas-Geertsen
 */
final class NumberCall extends FunctionCall {

	public NumberCall(QName fname, Vector arguments) {
		super(fname, arguments);
	}

	public Type typeCheck(SymbolTable stable) throws TypeCheckError {
		if (argumentCount() > 0) {
			argument().typeCheck(stable);
		}
		return _type = Type.Real;
	}

	public void translate(ClassGenerator classGen, MethodGenerator methodGen) {
		final InstructionList il = methodGen.getInstructionList();
		Type targ;

		if (argumentCount() == 0) {
			il.append(methodGen.loadContextNode());
			targ = Type.Node;
		} else {
			final Expression arg = argument();
			arg.translate(classGen, methodGen);
			arg.startIterator(classGen, methodGen);
			targ = arg.getType();
		}

		if (!targ.identicalTo(Type.Real)) {
			targ.translateTo(classGen, methodGen, Type.Real);
		}
	}
}
