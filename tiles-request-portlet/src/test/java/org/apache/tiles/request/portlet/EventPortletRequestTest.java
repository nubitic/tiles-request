/*
 * $Id: EventPortletRequestTest.java 1066849 2011-02-03 16:12:39Z apetrelli $
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
package org.apache.tiles.request.portlet;

import static org.easymock.classextension.EasyMock.*;
import static org.junit.Assert.*;

import java.lang.reflect.Field;

import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletContext;

import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.portlet.delegate.StateAwareRequestDelegate;
import org.apache.tiles.request.portlet.delegate.StateAwareResponseDelegate;
import org.junit.Test;

/**
 * Tests {@link EventPortletRequest}.
 *
 * @version $Rev: 1066849 $ $Date: 2011-02-04 03:12:39 +1100 (Fri, 04 Feb 2011) $
 */
public class EventPortletRequestTest {

    /**
     * Test method for
     * {@link EventPortletRequest#EventPortletRequest(ApplicationContext, PortletContext, EventRequest, EventResponse)}.
     * @throws NoSuchFieldException If something goes wrong.
     * @throws SecurityException If something goes wrong.
     * @throws IllegalAccessException If something goes wrong.
     * @throws IllegalArgumentException If something goes wrong.
     */
    @Test
    public void testEventPortletRequest() throws NoSuchFieldException, IllegalAccessException {
        ApplicationContext applicationContext = createMock(ApplicationContext.class);
        PortletContext portletContext = createMock(PortletContext.class);
        EventRequest request = createMock(EventRequest.class);
        EventResponse response = createMock(EventResponse.class);

        replay(applicationContext, portletContext, request, response);
        EventPortletRequest req = new EventPortletRequest(applicationContext,
                portletContext, request, response);
        Class<? extends EventPortletRequest> clazz = req.getClass();
        Field field = clazz.getSuperclass().getDeclaredField("requestDelegate");
        assertTrue(field.get(req) instanceof StateAwareRequestDelegate);
        field = clazz.getSuperclass().getDeclaredField("responseDelegate");
        assertTrue(field.get(req) instanceof StateAwareResponseDelegate);
        verify(applicationContext, portletContext, request, response);
    }

}
