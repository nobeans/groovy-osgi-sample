/*
 * Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
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
package org.jggug.kobo.osgi.service.client

import org.osgi.framework.BundleActivator
import org.osgi.framework.BundleContext
import org.osgi.util.tracker.ServiceTracker
import org.jggug.kobo.osgi.service.GroovyGreeter

class ServiceTrackerClientActivator implements BundleActivator {

    private ServiceTracker groovyGreeterTracker

    void start(BundleContext context) {
        println "ServiceTrackerClient BundleActivator started..."
        groovyGreeterTracker = new ServiceTracker(context, GroovyGreeter.class.getName(), null)
        groovyGreeterTracker.open()

        GroovyGreeter greeter = (GroovyGreeter) groovyGreeterTracker.getService()
        if (greeter == null) {
            System.out.println("GroovyGreeter service is not available")
        } else {
            greeter.sayHello()
        }
    }

    void stop(BundleContext context) {
        println "ServiceTrackerClient BundleActivator stopped."
        groovyGreeterTracker.close()
    }
}
