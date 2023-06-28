/*
 * $Id: FreemarkerAutotagException.java 1305546 2012-03-26 20:34:37Z nlebas $
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
package org.apache.tiles.request.freemarker.autotag;

/**
 * Thrown when a Freemarker problem under Autotag runtime part happens.
 *
 * @version $Rev: 1305546 $ $Date: 2012-03-27 07:34:37 +1100 (Tue, 27 Mar 2012) $
 */
public class FreemarkerAutotagException extends RuntimeException {

    /**
     * Constructor.
     */
    public FreemarkerAutotagException() {
    }

    /**
     * Constructor.
     *
     * @param message The message of the exception.
     */
    public FreemarkerAutotagException(String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param cause The cause.
     */
    public FreemarkerAutotagException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor.
     *
     * @param message The message of the exception.
     * @param cause The cause.
     */
    public FreemarkerAutotagException(String message, Throwable cause) {
        super(message, cause);
    }

}
