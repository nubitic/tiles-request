/*
 * $Id: NotAvailableFeatureExceptionTest.java 1066446 2011-02-02 12:38:04Z apetrelli $
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

package org.apache.tiles.request;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests {@link NotAvailableFeatureException}.
 *
 * @version $Rev: 1066446 $ $Date: 2011-02-02 23:38:04 +1100 (Wed, 02 Feb 2011) $
 */
public class NotAvailableFeatureExceptionTest {

    /**
     * Test method for {@link org.apache.tiles.request.NotAvailableFeatureException#NotAvailableFeatureException()}.
     */
    @Test
    public void testNotAvailableFeatureException() {
        NotAvailableFeatureException exception = new NotAvailableFeatureException();
        assertNull(exception.getMessage());
        assertNull(exception.getCause());
    }

    /**
     * Test method for {@link NotAvailableFeatureException#NotAvailableFeatureException(String)}.
     */
    @Test
    public void testNotAvailableFeatureExceptionString() {
        NotAvailableFeatureException exception = new NotAvailableFeatureException("my message");
        assertEquals("my message", exception.getMessage());
        assertNull(exception.getCause());
    }

    /**
     * Test method for {@link NotAvailableFeatureException#NotAvailableFeatureException(Throwable)}.
     */
    @Test
    public void testNotAvailableFeatureExceptionThrowable() {
        Throwable cause = new Throwable();
        NotAvailableFeatureException exception = new NotAvailableFeatureException(cause);
        assertEquals(cause.toString(), exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    /**
     * Test method for {@link NotAvailableFeatureException#NotAvailableFeatureException(String, Throwable)}.
     */
    @Test
    public void testNotAvailableFeatureExceptionStringThrowable() {
        Throwable cause = new Throwable();
        NotAvailableFeatureException exception = new NotAvailableFeatureException("my message", cause);
        assertEquals("my message", exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

}
