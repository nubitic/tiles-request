/*
 * $Id: AbstractRequestTest.java 1375743 2012-08-21 20:05:58Z nlebas $
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

import static org.easymock.classextension.EasyMock.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Tests {@link AbstractRequest}.
 *
 * @version $Rev: 1375743 $ $Date: 2012-08-22 06:05:58 +1000 (Wed, 22 Aug 2012) $
 */
public class AbstractRequestTest {

    /**
     * Test method for {@link org.apache.tiles.request.AbstractRequest#setForceInclude(boolean)}.
     */
    @Test
    public void testSetForceInclude() {
        AbstractRequest request = createMockBuilder(AbstractRequest.class).createMock();
        Map<String, Object> scope = new HashMap<String, Object>();

        expect(request.getContext(Request.REQUEST_SCOPE)).andReturn(scope).anyTimes();

        replay(request);
        assertFalse(request.isForceInclude());
        request.setForceInclude(true);
        assertTrue(request.isForceInclude());
        verify(request);
    }
}
