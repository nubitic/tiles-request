/*
 * $Id: MimeResponseDelegateTest.java 1066849 2011-02-03 16:12:39Z apetrelli $
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

import static org.easymock.classextension.EasyMock.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.portlet.MimeResponse;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests {@link MimeResponseDelegate}.
 *
 * @version $Rev: 1066849 $ $Date: 2011-02-04 03:12:39 +1100 (Fri, 04 Feb 2011) $
 */
public class MimeResponseDelegateTest {

    /**
     * The response.
     */
    private MimeResponse response;

    /**
     * The delegate to test.
     */
    private MimeResponseDelegate delegate;

    /**
     * Sets up the test.
     */
    @Before
    public void setUp() {
        response = createMock(MimeResponse.class);
        delegate = new MimeResponseDelegate(response);
    }

    /**
     * Test method for {@link org.apache.tiles.request.portlet.delegate.MimeResponseDelegate#getOutputStream()}.
     * @throws IOException If something goes wrong.
     */
    @Test
    public void testGetOutputStream() throws IOException {
        OutputStream os = createMock(OutputStream.class);

        expect(response.getPortletOutputStream()).andReturn(os);

        replay(response, os);
        assertEquals(os, delegate.getOutputStream());
        verify(response, os);
    }

    /**
     * Test method for {@link org.apache.tiles.request.portlet.delegate.MimeResponseDelegate#getPrintWriter()}.
     * @throws IOException If something goes wrong.
     */
    @Test
    public void testGetPrintWriter() throws IOException {
        PrintWriter os = createMock(PrintWriter.class);

        expect(response.getWriter()).andReturn(os);

        replay(response, os);
        assertEquals(os, delegate.getPrintWriter());
        verify(response, os);
    }

    /**
     * Test method for {@link org.apache.tiles.request.portlet.delegate.MimeResponseDelegate#getWriter()}.
     * @throws IOException If something goes wrong.
     */
    @Test
    public void testGetWriter() throws IOException {
        PrintWriter os = createMock(PrintWriter.class);

        expect(response.getWriter()).andReturn(os);

        replay(response, os);
        assertEquals(os, delegate.getWriter());
        verify(response, os);
    }

    /**
     * Test method for {@link org.apache.tiles.request.portlet.delegate.MimeResponseDelegate#isResponseCommitted()}.
     */
    @Test
    public void testIsResponseCommitted() {
        expect(response.isCommitted()).andReturn(true);

        replay(response);
        assertTrue(delegate.isResponseCommitted());
        verify(response);
    }

    /**
     * Test method for {@link MimeResponseDelegate#setContentType(String)}.
     */
    @Test
    public void testSetContentType() {
        response.setContentType("text/html");

        replay(response);
        delegate.setContentType("text/html");
        verify(response);
    }

}
