/*
 * $Id: ReadOnlyEnumerationMapValuesCollectionTest.java 1066446 2011-02-02 12:38:04Z apetrelli $
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

import static org.easymock.EasyMock.*;
import static org.easymock.classextension.EasyMock.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.apache.tiles.request.attribute.HasKeys;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests {@link ReadOnlyEnumerationMap#values()}.
 *
 * @version $Rev: 1066446 $ $Date: 2011-02-02 23:38:04 +1100 (Wed, 02 Feb 2011) $
 */
public class ReadOnlyEnumerationMapValuesCollectionTest {
    /**
     * The extractor to use.
     */
    private HasKeys<Integer> extractor;

    /**
     * The map to test.
     */
    private ReadOnlyEnumerationMap<Integer> map;

    /**
     * The collection to test.
     */
    private Collection<Integer> coll;

    /**
     * Sets up the test.
     */
    @SuppressWarnings("unchecked")
    @Before
    public void setUp() {
        extractor = createMock(HasKeys.class);
        map = new ReadOnlyEnumerationMap<Integer>(extractor);
        coll = map.values();
    }

    /**
     * Tests {@link Collection#add(Object)}.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testAdd() {
        coll.add(null);
    }

    /**
     * Tests {@link Collection#addAll(Object)}.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testAddAll() {
        coll.addAll(null);
    }

    /**
     * Tests {@link Collection#clear(Object)}.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testClear() {
        coll.clear();
    }

    /**
     * Tests {@link Collection#contains(Object)}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testContainsValue() {
        Enumeration<String> keys = createMock(Enumeration.class);

        expect(extractor.getKeys()).andReturn(keys);
        expect(keys.hasMoreElements()).andReturn(true);
        expect(keys.nextElement()).andReturn("one");
        expect(keys.hasMoreElements()).andReturn(true);
        expect(keys.nextElement()).andReturn("two");

        expect(extractor.getValue("one")).andReturn(1);
        expect(extractor.getValue("two")).andReturn(2);

        replay(extractor, keys);
        assertTrue(coll.contains(2));
        verify(extractor, keys);
    }

    /**
     * Tests {@link Collection#contains(Object)}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testContainsValueFalse() {
        Enumeration<String> keys = createMock(Enumeration.class);

        expect(extractor.getKeys()).andReturn(keys);
        expect(keys.hasMoreElements()).andReturn(true);
        expect(keys.nextElement()).andReturn("one");
        expect(keys.hasMoreElements()).andReturn(true);
        expect(keys.nextElement()).andReturn("two");
        expect(keys.hasMoreElements()).andReturn(false);

        expect(extractor.getValue("one")).andReturn(1);
        expect(extractor.getValue("two")).andReturn(2);

        replay(extractor, keys);
        assertFalse(coll.contains(3));
        verify(extractor, keys);
    }

    /**
     * Tests {@link Collection#containsAll(Object)}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testContainsAll() {
        Enumeration<String> keys = createMock(Enumeration.class);

        expect(extractor.getKeys()).andReturn(keys);
        expect(keys.hasMoreElements()).andReturn(true);
        expect(keys.nextElement()).andReturn("one");
        expect(keys.hasMoreElements()).andReturn(true);
        expect(keys.nextElement()).andReturn("two");

        expect(extractor.getValue("one")).andReturn(1);
        expect(extractor.getValue("two")).andReturn(2);

        replay(extractor, keys);
        List<Integer> coll = new ArrayList<Integer>();
        coll.add(1);
        coll.add(2);
        assertTrue(this.coll.containsAll(coll));
        verify(extractor, keys);
    }

    /**
     * Tests {@link Collection#containsAll(Object)}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testContainsAllFalse() {
        Enumeration<String> keys = createMock(Enumeration.class);

        expect(extractor.getKeys()).andReturn(keys);
        expect(keys.hasMoreElements()).andReturn(true);
        expect(keys.nextElement()).andReturn("one");
        expect(keys.hasMoreElements()).andReturn(true);
        expect(keys.nextElement()).andReturn("two");
        expect(keys.hasMoreElements()).andReturn(false);

        expect(extractor.getValue("one")).andReturn(1);
        expect(extractor.getValue("two")).andReturn(2);

        replay(extractor, keys);
        List<Integer> coll = new ArrayList<Integer>();
        coll.add(3);
        assertFalse(this.coll.containsAll(coll));
        verify(extractor, keys);
    }

    /**
     * Test method for {@link Collection#isEmpty()}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testIsEmpty() {
        Enumeration<String> keys = createMock(Enumeration.class);

        expect(extractor.getKeys()).andReturn(keys);
        expect(keys.hasMoreElements()).andReturn(true);

        replay(extractor, keys);
        assertFalse(coll.isEmpty());
        verify(extractor, keys);
    }

    /**
     * Test method for {@link Collection#iterator()}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testIterator() {
        Enumeration<String> keys = createMock(Enumeration.class);

        expect(extractor.getKeys()).andReturn(keys);
        expect(keys.hasMoreElements()).andReturn(true);
        expect(keys.nextElement()).andReturn("two");

        expect(extractor.getValue("two")).andReturn(2);

        replay(extractor, keys);
        Iterator<Integer> entryIt = coll.iterator();
        assertTrue(entryIt.hasNext());
        assertEquals(new Integer(2), entryIt.next());
        verify(extractor, keys);
    }

    /**
     * Test method for {@link Collection#iterator()}.
     */
    @SuppressWarnings("unchecked")
    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorRemove() {
        Enumeration<String> keys = createMock(Enumeration.class);

        expect(extractor.getKeys()).andReturn(keys);

        try {
            replay(extractor, keys);
            coll.iterator().remove();
        } finally {
            verify(extractor, keys);
        }
    }

    /**
     * Tests {@link Collection#remove(Object)}.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testRemove() {
        coll.remove(null);
    }

    /**
     * Tests {@link Collection#removeAll(java.util.Collection)}.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveAll() {
        coll.removeAll(null);
    }

    /**
     * Tests {@link Collection#retainAll(java.util.Collection)}.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testRetainAll() {
        coll.retainAll(null);
    }

    /**
     * Test method for {@link org.apache.tiles.request.collection.HeaderValuesMap#size()}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testSize() {
        Enumeration<String> keys = createMock(Enumeration.class);

        expect(extractor.getKeys()).andReturn(keys);
        expect(keys.hasMoreElements()).andReturn(true);
        expect(keys.nextElement()).andReturn("one");
        expect(keys.hasMoreElements()).andReturn(true);
        expect(keys.nextElement()).andReturn("two");
        expect(keys.hasMoreElements()).andReturn(false);

        replay(extractor, keys);
        assertEquals(2, coll.size());
        verify(extractor, keys);
    }

    /**
     * Test method for {@link Collection#toArray()}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testToArray() {
        Enumeration<String> keys = createMock(Enumeration.class);

        expect(extractor.getKeys()).andReturn(keys);
        expect(keys.hasMoreElements()).andReturn(true);
        expect(keys.nextElement()).andReturn("one");
        expect(keys.hasMoreElements()).andReturn(true);
        expect(keys.nextElement()).andReturn("two");
        expect(keys.hasMoreElements()).andReturn(false);

        expect(extractor.getValue("one")).andReturn(1);
        expect(extractor.getValue("two")).andReturn(2);

        Integer[] entryArray = new Integer[] {1, 2};

        replay(extractor, keys);
        assertArrayEquals(entryArray, coll.toArray());
        verify(extractor, keys);
    }

    /**
     * Test method for {@link Collection#toArray(Object[])}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testToArrayTArray() {
        Enumeration<String> keys = createMock(Enumeration.class);

        expect(extractor.getKeys()).andReturn(keys);
        expect(keys.hasMoreElements()).andReturn(true);
        expect(keys.nextElement()).andReturn("one");
        expect(keys.hasMoreElements()).andReturn(true);
        expect(keys.nextElement()).andReturn("two");
        expect(keys.hasMoreElements()).andReturn(false);

        expect(extractor.getValue("one")).andReturn(1);
        expect(extractor.getValue("two")).andReturn(2);

        Integer[] entryArray = new Integer[] {1, 2};

        replay(extractor, keys);
        Integer[] realArray = new Integer[2];
        assertArrayEquals(entryArray, coll.toArray(realArray));
        verify(extractor, keys);
    }
}
