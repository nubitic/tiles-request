/*
 * $Id: HeaderExtractorTest.java 1066499 2011-02-02 15:33:34Z apetrelli $
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
package org.apache.tiles.request.servlet.extractor;

import static org.easymock.classextension.EasyMock.*;
import static org.junit.Assert.*;

import java.util.Enumeration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests {@link HeaderExtractor}.
 *
 * @version $Rev: 1066499 $ $Date: 2011-02-03 02:33:34 +1100 (Thu, 03 Feb 2011) $
 */
public class HeaderExtractorTest {

    /**
     * The request.
     */
    private HttpServletRequest request;

    /**
     * The response.
     */
    private HttpServletResponse response;

    /**
     * The extractor to test.
     */
    private HeaderExtractor extractor;

    /**
     * Sets up the test.
     */
    @Before
    public void setUp() {
        request = createMock(HttpServletRequest.class);
        response = createMock(HttpServletResponse.class);
        extractor = new HeaderExtractor(request, response);
    }

    /**
     * Test method for {@link org.apache.tiles.request.servlet.extractor.HeaderExtractor#getKeys()}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testGetKeys() {
        Enumeration<String> keys = createMock(Enumeration.class);

        expect(request.getHeaderNames()).andReturn(keys);

        replay(request, response, keys);
        assertEquals(keys, extractor.getKeys());
        verify(request, response, keys);
    }

    /**
     * Test method for {@link org.apache.tiles.request.servlet.extractor.HeaderExtractor#getValue(java.lang.String)}.
     */
    @Test
    public void testGetValue() {
        expect(request.getHeader("name")).andReturn("value");

        replay(request, response);
        assertEquals("value", extractor.getValue("name"));
        verify(request, response);
    }

    /**
     * Test method for {@link org.apache.tiles.request.servlet.extractor.HeaderExtractor#getValues(java.lang.String)}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testGetValues() {
        Enumeration<String> keys = createMock(Enumeration.class);

        expect(request.getHeaders("name")).andReturn(keys);

        replay(request, response, keys);
        assertEquals(keys, extractor.getValues("name"));
        verify(request, response, keys);
    }

    /**
     * Test method for {@link HeaderExtractor#setValue(String, String)}.
     */
    @Test
    public void testSetValue() {
        response.setHeader("name", "value");

        replay(request, response);
        extractor.setValue("name", "value");
        verify(request, response);
    }

}
