package servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resource_server.ResourceServer;
import resources.TestResource;
import sax.ReadXMLFileSAX;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResourcePageServlet extends HttpServlet {

    static final Logger logger = LogManager.getLogger(ResourcePageServlet.class.getName());
    public static final String PAGE_URL = "/resources";
    ResourceServer resourceServer;

    public ResourcePageServlet(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        String pathToResource = req.getParameter("path");
        TestResource resource = (TestResource) ReadXMLFileSAX.readXML(pathToResource);
        if (resource != null){
            resourceServer.setTestResource(resource);
            resp.setStatus(HttpServletResponse.SC_OK);
        } else resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
    }
}
