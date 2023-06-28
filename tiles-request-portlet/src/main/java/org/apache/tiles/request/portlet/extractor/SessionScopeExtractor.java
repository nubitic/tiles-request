/*
 * $Id: SessionScopeExtractor.java 1066849 2011-02-03 16:12:39Z apetrelli $
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
package org.apache.tiles.request.portlet.extractor;

import java.util.Enumeration;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;

import org.apache.tiles.request.attribute.AttributeExtractor;

/**
 * Extracts attributes from the session scope of a portlet request.
 *
 * @version $Rev: 1066849 $ $Date: 2011-02-04 03:12:39 +1100 (Fri, 04 Feb 2011) $
 */
public class SessionScopeExtractor implements AttributeExtractor {

    /**
     * The portlet request.
     */
    private PortletRequest request;

    /**
     * The subscope (application or portlet).
     */
    private int scope;

    /**
     * Constructor.
     *
     * @param request The request.
     * @param scope The subscope (application or portlet).
     */
    public SessionScopeExtractor(PortletRequest request, int scope) {
        this.request = request;
        if (scope != PortletSession.APPLICATION_SCOPE
                && scope != PortletSession.PORTLET_SCOPE) {
            throw new IllegalArgumentException(
                    "The scope must be either APPLICATION_SCOPE or PORTLET_SCOPE");
        }
        this.scope = scope;
    }

    @Override
    public void setValue(String name, Object value) {
        request.getPortletSession().setAttribute(name, value, scope);
    }

    @Override
    public void removeValue(String name) {
        PortletSession session = request.getPortletSession(false);
        if (session != null) {
            session.removeAttribute(name, scope);
        }
    }

    @Override
    public Enumeration<String> getKeys() {
        PortletSession session = request.getPortletSession(false);
        if (session != null) {
            return session.getAttributeNames(scope);
        }
        return null;
    }

    @Override
    public Object getValue(String key) {
        PortletSession session = request.getPortletSession(false);
        if (session != null) {
            return session.getAttribute(key, scope);
        }
        return null;
    }
}
