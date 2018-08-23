/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.doctree;

import java.util.List;

/**
 * A tree node for an @return block tag.
 *
 * <p>
 * &#064;return description
 *
 * @since 1.8
 */
@jdk.Exported
public interface ReturnTree extends BlockTagTree {
	List<? extends DocTree> getDescription();
}
