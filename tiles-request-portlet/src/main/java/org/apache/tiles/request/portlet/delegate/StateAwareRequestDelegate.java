/*
 * $Id: StateAwareRequestDelegate.java 1066849 2011-02-03 16:12:39Z apetrelli $
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

import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.StateAwareResponse;

import org.apache.tiles.request.collection.AddableParameterMap;
import org.apache.tiles.request.portlet.extractor.StateAwareParameterExtractor;

/**
 * Exposes parameters getting them from a portlet reques and allowing to be put
 * into a {@link StateAwareResponse}.
 *
 * @version $Rev: 1066849 $ $Date: 2011-02-04 03:12:39 +1100 (Fri, 04 Feb 2011) $
 */
public class StateAwareRequestDelegate implements RequestDelegate {

    /**
     * The request.
     */
    private PortletRequest request;

    /**
     * The response.
     */
    private StateAwareResponse response;

    /**
     * Constructor.
     *
     * @param request The request.
     * @param response The response.
     */
    public StateAwareRequestDelegate(PortletRequest request,
            StateAwareResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * <p>The lazily instantiated <code>Map</code> of request
     * parameter name-value.</p>
     */
    private Map<String, String> param = null;

    /**
     * <p>The lazily instantiated <code>Map</code> of request
     * parameter name-values.</p>
     */
    private Map<String, String[]> paramValues = null;

    /** {@inheritDoc} */
    public Map<String, String> getParam() {
        if ((param == null) && (request != null)) {
            param = new AddableParameterMap(new StateAwareParameterExtractor(
                    request, response));
        }
        return (param);
    }

    /** {@inheritDoc} */
    public Map<String, String[]> getParamValues() {
        if ((paramValues == null) && (request != null)) {
            paramValues = new StateAwareParameterMap(request.getParameterMap(),
                    response.getRenderParameterMap());
        }
        return (paramValues);
    }
}
