/*
 * $Id: StateAwareResponseDelegateTest.java 1066849 2011-02-03 16:12:39Z apetrelli $
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
package org.apache.tiles.request.portlet.delegate;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests {@link StateAwareResponseDelegate}.
 *
 * @version $Rev: 1066849 $ $Date: 2011-02-04 03:12:39 +1100 (Fri, 04 Feb 2011) $
 */
public class StateAwareResponseDelegateTest {

    /**
     * The delegate to test.
     */
    private StateAwareResponseDelegate delegate;

    /**
     * Sets up the test.
     */
    @Before
    public void setUp() {
        delegate = new StateAwareResponseDelegate();
    }

    /**
     * Test method for {@link org.apache.tiles.request.portlet.delegate.StateAwareResponseDelegate#getOutputStream()}.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testGetOutputStream() {
        delegate.getOutputStream();
    }

    /**
     * Test method for {@link org.apache.tiles.request.portlet.delegate.StateAwareResponseDelegate#getPrintWriter()}.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testGetPrintWriter() {
        delegate.getPrintWriter();
    }

    /**
     * Test method for {@link org.apache.tiles.request.portlet.delegate.StateAwareResponseDelegate#getWriter()}.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testGetWriter() {
        delegate.getWriter();
    }

    /**
     * Test method for {@link StateAwareResponseDelegate#isResponseCommitted()}.
     */
    @Test
    public void testIsResponseCommitted() {
        assertFalse(delegate.isResponseCommitted());
    }

    /**
     * Test method for {@link StateAwareResponseDelegate#setContentType(java.lang.String)}.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testSetContentType() {
        delegate.setContentType("text/html");
    }
}
