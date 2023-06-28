/*
 * $Id: FreemarkerAutotagExceptionTest.java 1305546 2012-03-26 20:34:37Z nlebas $
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

package org.apache.tiles.request.freemarker.autotag;

import static org.junit.Assert.*;

import org.apache.tiles.request.freemarker.autotag.FreemarkerAutotagException;
import org.junit.Test;

/**
 * Tests {@link FreemarkerAutotagException}.
 *
 * @version $Rev: 1305546 $ $Date: 2012-03-27 07:34:37 +1100 (Tue, 27 Mar 2012) $
 */
public class FreemarkerAutotagExceptionTest {

    /**
     * Test method for {@link FreemarkerAutotagException#FreemarkerAutotagException()}.
     */
    @Test
    public void testFreemarkerAutotagException() {
        FreemarkerAutotagException exception = new FreemarkerAutotagException();
        assertNull(exception.getMessage());
        assertNull(exception.getCause());
    }

    /**
     * Test method for {@link FreemarkerAutotagException#FreemarkerAutotagException(java.lang.String)}.
     */
    @Test
    public void testFreemarkerAutotagExceptionString() {
        FreemarkerAutotagException exception = new FreemarkerAutotagException("my message");
        assertEquals("my message", exception.getMessage());
        assertNull(exception.getCause());
    }

    /**
     * Test method for {@link FreemarkerAutotagException#FreemarkerAutotagException(java.lang.Throwable)}.
     */
    @Test
    public void testFreemarkerAutotagExceptionThrowable() {
        Throwable cause = new Throwable();
        FreemarkerAutotagException exception = new FreemarkerAutotagException(cause);
        assertEquals(cause.toString(), exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    /**
     * Test method for {@link FreemarkerAutotagException#FreemarkerAutotagException(String, Throwable)}.
     */
    @Test
    public void testFreemarkerAutotagExceptionStringThrowable() {
        Throwable cause = new Throwable();
        FreemarkerAutotagException exception = new FreemarkerAutotagException("my message", cause);
        assertEquals("my message", exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

}
