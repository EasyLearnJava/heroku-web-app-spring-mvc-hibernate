package pl.napadlek.webapp.web.jetty;

import java.io.IOException;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import pl.napadlek.webapp.web.config.WebAppConfig;

public class JettyRunner {

    private static final Logger logger = LoggerFactory.getLogger(JettyRunner.class);

    private static final int DEFAULT_PORT = 8000;
    private static final String CONTEXT_PATH = "/";
    private static final String MAPPING_URL = "/*";
    private static final String DEFAULT_PROFILE = "dev";

    public static void main(String[] args) throws Exception {
        new JettyRunner().startJetty(args.length == 0 ? DEFAULT_PORT : Integer.parseInt(args[0]));
    }

    private void startJetty(int port) throws Exception {
        Server server = new Server(port);
        server.setHandler(getServletContextHandler(getContext()));
        server.start();
        logger.info("Server started at port {}", port);
        server.join();
    }

    private static ServletContextHandler getServletContextHandler(WebApplicationContext context) throws IOException {
        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.setErrorHandler(null);
        contextHandler.setContextPath(CONTEXT_PATH);
        contextHandler.addServlet(new ServletHolder(new DispatcherServlet(context)), MAPPING_URL);
        contextHandler.addEventListener(new ContextLoaderListener(context));
        contextHandler.setResourceBase(new ClassPathResource("webapp").getURI().toString());
        return contextHandler;
    }

    private static WebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.setConfigLocation(CONFIG_LOCATION);
        context.register(WebAppConfig.class);
        context.getEnvironment().setDefaultProfiles(DEFAULT_PROFILE);
        return context;
    }

}