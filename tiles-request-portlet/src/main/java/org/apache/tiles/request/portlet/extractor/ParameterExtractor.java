/*
 * $Id: ParameterExtractor.java 1066849 2011-02-03 16:12:39Z apetrelli $
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

import org.apache.tiles.request.attribute.HasKeys;

/**
 * Extracts parameters from a portlet request.
 *
 * @version $Rev: 1066849 $ $Date: 2011-02-04 03:12:39 +1100 (Fri, 04 Feb 2011) $
 */
public class ParameterExtractor implements HasKeys<String> {

    /**
     * The portlet request.
     */
    private PortletRequest request;

    /**
     * Constructor.
     *
     * @param request The portlet request.
     */
    public ParameterExtractor(PortletRequest request) {
        this.request = request;
    }

    @Override
    public Enumeration<String> getKeys() {
        return request.getParameterNames();
    }

    @Override
    public String getValue(String key) {
        return request.getParameter(key);
    }
}
