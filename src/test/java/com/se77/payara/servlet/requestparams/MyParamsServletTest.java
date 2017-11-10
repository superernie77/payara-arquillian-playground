package com.se77.payara.servlet.requestparams;

import com.se77.payara.servlet.simple.MyServlet;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.core.UriBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class MyParamsServletTest {

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addPackage(MyParamsServlet.class.getPackage());
    }


    @ArquillianResource
    URL deploymentUrl;

    @Test
    @RunAsClient
    public void testParamsServlet() throws IOException, Exception {
        UriBuilder builder = UriBuilder.fromUri(deploymentUrl.toURI()).path("echo").queryParam("parameter1","test").queryParam("parameter2", "test2");

        URL url = builder.build().toURL();
        StringBuilder stringbuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;

        while ((line = reader.readLine()) != null) {
            stringbuilder.append(line);
        }
        reader.close();

        assertEquals("testtest2",stringbuilder.toString());
    }

}
