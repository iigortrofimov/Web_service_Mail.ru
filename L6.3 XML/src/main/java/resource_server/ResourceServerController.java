package resource_server;

import resources.TestResource;

public class ResourceServerController implements ResourceServerControllerMBean {
    private ResourceServer resourceServer;

    public ResourceServerController(ResourceServer resourceServer) {
        this.resourceServer = resourceServer;
    }

    @Override
    public String getname() {
        return resourceServer.getname();
    }

    @Override
    public int getage() {
        return resourceServer.getage();
    }

}
