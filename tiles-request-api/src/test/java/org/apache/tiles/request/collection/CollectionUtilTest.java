/*
 * $Id: CollectionUtilTest.java 1229087 2012-01-09 10:35:14Z mck $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tiles.request.collection;

import org.apache.tiles.request.collection.CollectionUtil;
import static org.easymock.classextension.EasyMock.*;
import static org.junit.Assert.*;

import java.util.Enumeration;

import org.junit.Test;

/**
 * Test {@link RequestUtil}.
 *
 * @version $Rev: 1066446 $ $Date: 2011-02-02 13:38:04 +0100 (Wed, 02 Feb 2011) $
 */
public class CollectionUtilTest {

    /**
     * Test method for {@link org.apache.tiles.request.RequestUtil#key(java.lang.Object)}.
     */
    @Test
    public void testKey() {
        assertEquals("1", CollectionUtil.key(1));
        assertEquals("hello", CollectionUtil.key("hello"));
    }

    /**
     * Test method for {@link org.apache.tiles.request.RequestUtil#key(java.lang.Object)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testKeyException() {
        CollectionUtil.key(null);
    }

    /**
     * Test method for {@link org.apache.tiles.request.RequestUtil#enumerationSize(java.util.Enumeration)}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testEnumerationSize() {
        Enumeration<Object> enumeration = createMock(Enumeration.class);

        expect(enumeration.hasMoreElements()).andReturn(true);
        expect(enumeration.nextElement()).andReturn(1);
        expect(enumeration.hasMoreElements()).andReturn(true);
        expect(enumeration.nextElement()).andReturn(1);
        expect(enumeration.hasMoreElements()).andReturn(false);

        replay(enumeration);
        assertEquals(2, CollectionUtil.enumerationSize(enumeration));
        verify(enumeration);
    }

}
