package org.jggug.kobo.osgi

import org.osgi.framework.BundleActivator
import org.osgi.framework.BundleContext

class GroovyOSGiSampleActivator implements BundleActivator {

    void start(BundleContext context) {
        println "Groovy BundleActivator started..."
    }

    void stop(BundleContext context) {
        println "Groovy BundleActivator stopped. Bye!!"
    }

}

