/*
 * $Id$
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
package org.apache.tiles.request.render;

import java.io.IOException;

import org.apache.tiles.request.Request;

/**
 * Renders an attribute that contains a reference to a template.
 *
 * @version $Rev$ $Date$
 * @since 3.0.0
 */
public class DispatchRenderer implements TypeDetectingRenderer {

    /** {@inheritDoc} */
    @Override
    public void render(String path, Request request) throws IOException {
        if (path == null) {
            throw new InvalidTemplateException("Cannot dispatch a null path");
        }

        request.dispatch(path);
    }

    /** {@inheritDoc} */
    public boolean isRenderable(String path, Request request) {
        return path != null && path.startsWith("/");
    }
}