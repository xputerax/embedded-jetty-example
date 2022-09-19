package com.aimandaniel;

import org.eclipse.jetty.server.CustomRequestLog;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.Slf4jRequestLogWriter;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Server server = new Server();

        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        connector.setHost("0.0.0.0");

        server.addConnector(connector);
        Slf4jRequestLogWriter logWriter = new Slf4jRequestLogWriter();
        logWriter.setLoggerName(App.class.toString());

        server.setRequestLog(new CustomRequestLog(logWriter, CustomRequestLog.NCSA_FORMAT));

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");

        // defined inside web.xml instead
        // context.addServlet(HelloServlet.class, "/shop");

        server.setHandler(context);
        server.start();
    }
}
