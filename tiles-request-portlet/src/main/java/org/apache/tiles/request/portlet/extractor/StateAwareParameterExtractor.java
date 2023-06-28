/*
 * $Id: StateAwareParameterExtractor.java 1066849 2011-02-03 16:12:39Z apetrelli $
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

import javax.portlet.PortletRequest;
import javax.portlet.StateAwareResponse;

import org.apache.tiles.request.attribute.HasAddableKeys;

/**
 * Extracts parameters from a request and allows putting render parameters in a state aware response.
 *
 * @version $Rev: 1066849 $ $Date: 2011-02-04 03:12:39 +1100 (Fri, 04 Feb 2011) $
 */
public class StateAwareParameterExtractor extends ParameterExtractor implements HasAddableKeys<String> {

    /**
     * The portlet response.
     */
    private StateAwareResponse response;

    /**
     * Constructor.
     *
     * @param request The portlet request.
     * @param response The portlet response.
     */
    public StateAwareParameterExtractor(PortletRequest request, StateAwareResponse response) {
        super(request);
        this.response = response;
    }

    @Override
    public void setValue(String key, String value) {
        response.setRenderParameter(key, value);
    }
}
