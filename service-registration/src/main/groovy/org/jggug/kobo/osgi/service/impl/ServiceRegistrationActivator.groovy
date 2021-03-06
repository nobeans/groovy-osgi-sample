/*
 * Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jggug.kobo.osgi.service.impl

import org.osgi.framework.BundleActivator
import org.osgi.framework.BundleContext
import org.osgi.framework.ServiceRegistration
import org.jggug.kobo.osgi.service.GroovyGreeter

class ServiceRegistrationActivator implements BundleActivator {

    private ServiceRegistration registration

    void start(BundleContext context) {
        println "ServiceRegistration BundleActivator started..."
        ClassLoader originalClassLoader = Thread.currentThread().contextClassLoader
        try {
            Thread.currentThread().contextClassLoader = getClass().classLoader
            GroovyGreeter greeter = new GroovyGreeterImpl()
            registration = context.registerService(GroovyGreeter.class.getName(), greeter, null)
        } finally {
            Thread.currentThread().contextClassLoader = originalClassLoader
        }
    }

    void stop(BundleContext context) {
        println "ServiceRegistration BundleActivator stopped."
        registration.unregister()
    }
}

