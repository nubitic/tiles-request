/*
 * $Id: EnvironmentScopeMap.java 942404 2010-05-08 15:36:51Z apetrelli $
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
package org.apache.tiles.request.freemarker;

import java.util.Set;

import org.apache.tiles.request.collection.ScopeMap;
import org.apache.tiles.request.freemarker.extractor.EnvironmentScopeExtractor;

import freemarker.core.Environment;
import freemarker.template.TemplateModelException;

/**
 * <p>
 * Private implementation of <code>Map</code> for servlet request attributes.
 * </p>
 *
 * @version $Rev: 942404 $ $Date: 2010-05-09 01:36:51 +1000 (Sun, 09 May 2010) $
 */

final class EnvironmentScopeMap extends ScopeMap {

    /**
     * The request object to use.
     */
    private Environment request = null;

    /**
     * Constructor.
     *
     * @param request The request object to use.
     */
    public EnvironmentScopeMap(Environment request) {
        super(new EnvironmentScopeExtractor(request));
        this.request = request;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<String> keySet() {
        try {
            return request.getKnownVariableNames();
        } catch (TemplateModelException e) {
            throw new FreemarkerRequestException(
                    "Cannot get known variable names", e);
        }
    }
}
