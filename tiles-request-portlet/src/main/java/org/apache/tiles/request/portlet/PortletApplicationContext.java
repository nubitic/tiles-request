/*
 * $Id: PortletApplicationContext.java 1297705 2012-03-06 20:44:30Z nlebas $
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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletContext;

import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.ApplicationResource;
import org.apache.tiles.request.collection.ReadOnlyEnumerationMap;
import org.apache.tiles.request.collection.ScopeMap;
import org.apache.tiles.request.locale.URLApplicationResource;
import org.apache.tiles.request.portlet.extractor.ApplicationScopeExtractor;
import org.apache.tiles.request.portlet.extractor.InitParameterExtractor;

/**
 * Portlet-based TilesApplicationContext implementation.
 *
 * @version $Rev: 1297705 $ $Date: 2012-03-07 07:44:30 +1100 (Wed, 07 Mar 2012) $
 */
public class PortletApplicationContext implements ApplicationContext {

    /**
     * <p>The lazily instantiated <code>Map</code> of application scope
     * attributes.</p>
     */
    private Map<String, Object> applicationScope = null;

    /**
     * <p>The <code>PortletContext</code> for this web application.</p>
     */
    protected PortletContext context = null;

    /**
     * <p>The lazily instantiated <code>Map</code> of context initialization
     * parameters.</p>
     */
    private Map<String, String> initParam = null;

    /**
     * Creates a new instance of PortletTilesApplicationContext.
     *
     * @param context The portlet context to use.
     */
    public PortletApplicationContext(PortletContext context) {
        initialize(context);
    }

    /** {@inheritDoc} */
    public Object getContext() {
        return context;
    }

    /**
     * <p>Initialize (or reinitialize) this {@link PortletApplicationContext} instance
     * for the specified Portlet API objects.</p>
     *
     * @param context The <code>PortletContext</code> for this web application
     */
    public void initialize(PortletContext context) {

        // Save the specified Portlet API object references
        this.context = context;

    }

    /**
     * <p>Return the {@link PortletContext} for this context.</p>
     *
     * @return The original portlet context.
     */
    public PortletContext getPortletContext() {
        return (this.context);
    }

    /** {@inheritDoc} */
    public Map<String, Object> getApplicationScope() {
        if ((applicationScope == null) && (context != null)) {
            applicationScope = new ScopeMap(new ApplicationScopeExtractor(context));
        }
        return (applicationScope);

    }

    /** {@inheritDoc} */
    public Map<String, String> getInitParams() {
        if ((initParam == null) && (context != null)) {
            initParam = new ReadOnlyEnumerationMap<String>(new InitParameterExtractor(context));
        }
        return (initParam);

    }

    /** {@inheritDoc} */
    public ApplicationResource getResource(String localePath) {
        try {
            URL url = context.getResource(localePath);
            if (url != null) {
                return new URLApplicationResource(localePath, url);
            } else {
                return null;
            }
        } catch (MalformedURLException e) {
            return null;
        }
    }

    /** {@inheritDoc} */
    public ApplicationResource getResource(ApplicationResource base, Locale locale) {
        try {
            URL url = context.getResource(base.getLocalePath(locale));
            if (url != null) {
                return new URLApplicationResource(base.getPath(), locale, url);
            } else {
                return null;
            }
        } catch (MalformedURLException e) {
            return null;
        }
    }

    /** {@inheritDoc} */
    public Collection<ApplicationResource> getResources(String path) {
        ArrayList<ApplicationResource> resources = new ArrayList<ApplicationResource>();
        resources.add(getResource(path));
        return resources;
    }
}
