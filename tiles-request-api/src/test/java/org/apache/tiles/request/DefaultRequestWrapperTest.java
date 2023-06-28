/*
 * $Id: DefaultRequestWrapperTest.java 1332134 2012-04-30 09:23:19Z mck $
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

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

import org.apache.tiles.request.attribute.Addable;
import org.junit.Test;

/**
 * Tests {@link DefaultRequestWrapper}.
 *
 * @version $Rev: 1215009 $ $Date: 2011-12-16 01:32:31 +0100 (Fri, 16 Dec 2011) $
 */
public class DefaultRequestWrapperTest {

    /**
     * Creates the RequestWrapper to be tested.
     *
     * @param wrappedRequest the request to be wrapped.
     * @return the RequestWrapper.
     */
    protected RequestWrapper createRequestWrapper(Request wrappedRequest) {
        DefaultRequestWrapper request = new DefaultRequestWrapper(wrappedRequest);
        return request;
    }

    /**
     * Creates a mock Request adequate to the test.
     *
     * @return the Request object.
     */
    protected Request createMockRequest() {
        Request wrappedRequest = createMock(Request.class);
        return wrappedRequest;
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getWrappedRequest()}.
     */
    @Test
    public void testGetWrappedRequest() {
        Request wrappedRequest = createMockRequest();

        replay(wrappedRequest);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(wrappedRequest, request.getWrappedRequest());
        verify(wrappedRequest);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getHeader()}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testGetHeader() {
        Request wrappedRequest = createMockRequest();
        Map<String, String> header = createMock(Map.class);

        expect(wrappedRequest.getHeader()).andReturn(header);

        replay(wrappedRequest);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(header, request.getHeader());
        verify(wrappedRequest);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getResponseHeaders()}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testGetResponseHeaders() {
        Request wrappedRequest = createMockRequest();
        Addable<String> header = createMock(Addable.class);

        expect(wrappedRequest.getResponseHeaders()).andReturn(header);

        replay(wrappedRequest);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(header, request.getResponseHeaders());
        verify(wrappedRequest);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getHeaderValues()}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testGetHeaderValues() {
        Request wrappedRequest = createMockRequest();
        Map<String, String[]> header = createMock(Map.class);

        expect(wrappedRequest.getHeaderValues()).andReturn(header);

        replay(wrappedRequest);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(header, request.getHeaderValues());
        verify(wrappedRequest);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getContext(java.lang.String)}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testGetContext() {
        Request wrappedRequest = createMockRequest();
        Map<String, Object> context = createMock(Map.class);

        RequestWrapper request = createRequestWrapper(wrappedRequest);

        expect(wrappedRequest.getContext("one")).andReturn(context);

        replay(wrappedRequest, context);
        assertEquals(context, request.getContext("one"));
        verify(wrappedRequest, context);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getAvailableScopes()}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testGetAvailableScopes() {
        Request wrappedRequest = createMockRequest();
        Map<String, Object> context = createMock(Map.class);

        RequestWrapper request = createRequestWrapper(wrappedRequest);

        String[] scopes = new String[] {"one", "two", "three"};
        expect(wrappedRequest.getAvailableScopes()).andReturn(Arrays.asList(scopes));

        replay(wrappedRequest, context);
        assertArrayEquals(scopes, request.getAvailableScopes().toArray());
        verify(wrappedRequest, context);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getApplicationContext()}.
     */
    @Test
    public void testGetApplicationContext() {
        Request wrappedRequest = createMockRequest();
        ApplicationContext applicationContext = createMock(ApplicationContext.class);

        expect(wrappedRequest.getApplicationContext()).andReturn(applicationContext);

        replay(wrappedRequest, applicationContext);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(applicationContext, request.getApplicationContext());
        verify(wrappedRequest, applicationContext);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getOutputStream()}.
     * @throws IOException If something goes wrong.
     */
    @Test
    public void testGetOutputStream() throws IOException {
        Request wrappedRequest = createMockRequest();
        OutputStream stream = createMock(OutputStream.class);

        expect(wrappedRequest.getOutputStream()).andReturn(stream);

        replay(wrappedRequest, stream);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(stream, request.getOutputStream());
        verify(wrappedRequest, stream);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getWriter()}.
     * @throws IOException If something goes wrong.
     */
    @Test
    public void testGetWriter() throws IOException {
        Request wrappedRequest = createMockRequest();
        Writer writer = createMock(Writer.class);

        expect(wrappedRequest.getWriter()).andReturn(writer);

        replay(wrappedRequest, writer);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(writer, request.getWriter());
        verify(wrappedRequest, writer);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getPrintWriter()}.
     * @throws IOException If something goes wrong.
     */
    @Test
    public void testGetPrintWriter() throws IOException {
        Request wrappedRequest = createMockRequest();
        PrintWriter writer = createMock(PrintWriter.class);

        expect(wrappedRequest.getPrintWriter()).andReturn(writer);

        replay(wrappedRequest, writer);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(writer, request.getPrintWriter());
        verify(wrappedRequest, writer);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#isResponseCommitted()}.
     */
    @Test
    public void testIsResponseCommitted() {
        Request wrappedRequest = createMockRequest();

        expect(wrappedRequest.isResponseCommitted()).andReturn(Boolean.TRUE);

        replay(wrappedRequest);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertTrue(request.isResponseCommitted());
        verify(wrappedRequest);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getParam()}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testGetParam() {
        Request wrappedRequest = createMockRequest();
        Map<String, String> param = createMock(Map.class);

        expect(wrappedRequest.getParam()).andReturn(param);

        replay(wrappedRequest, param);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(param, request.getParam());
        verify(wrappedRequest, param);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getParamValues()}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testGetParamValues() {
        Request wrappedRequest = createMockRequest();
        Map<String, String[]> param = createMock(Map.class);

        expect(wrappedRequest.getParamValues()).andReturn(param);

        replay(wrappedRequest, param);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(param, request.getParamValues());
        verify(wrappedRequest, param);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#getRequestLocale()}.
     */
    @Test
    public void testGetRequestLocale() {
        Request wrappedRequest = createMockRequest();
        Locale param = Locale.ITALY;

        expect(wrappedRequest.getRequestLocale()).andReturn(param);

        replay(wrappedRequest);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertEquals(param, request.getRequestLocale());
        verify(wrappedRequest);
    }

    /**
     * Test method for {@link org.apache.tiles.request.DefaultRequestWrapper#isUserInRole(java.lang.String)}.
     */
    @Test
    public void testIsUserInRole() {
        Request wrappedRequest = createMockRequest();

        expect(wrappedRequest.isUserInRole("myrole")).andReturn(Boolean.TRUE);

        replay(wrappedRequest);
        RequestWrapper request = createRequestWrapper(wrappedRequest);
        assertTrue(request.isUserInRole("myrole"));
        verify(wrappedRequest);
    }

}
