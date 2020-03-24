package resource_server;

import resources.TestResource;

public class ResourceServer {

    private TestResource testResource;

    public ResourceServer(TestResource testResource) {
        this.testResource = testResource;
    }

    public String getname() {
        return testResource.getName();
    }

    public int getage() {
        return testResource.getAge();
    }

    public void setTestResource(TestResource testResource) {
        this.testResource = testResource;
    }
}
