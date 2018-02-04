package com.se77.payara.servlet.mappings;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class MyServletMappingsTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(MyServletWitMappings.class.getPackage());
    }


    @ArquillianResource
    URL deploymentUrl;

    @Test
    @RunAsClient
    public void testFirstMapping() throws IOException {
        // Test first mapping
        URL url = new URL(deploymentUrl, "start2");
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;

        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        reader.close();

        assertEquals("Hello World!",builder.toString());
    }

    @Test
    @RunAsClient
    public void testSecondMapping() throws IOException {
        // Test first mapping
        URL url = new URL(deploymentUrl, "myServlet2");
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;

        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        reader.close();

        assertEquals("Hello World!",builder.toString());
    }

}
