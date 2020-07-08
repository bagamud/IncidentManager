package main.java.clients;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public class ManagerClient {
    /**
     * TODO:
     */
    private static final String BASE_URI = "http://localhost:8090/IncidentManagerWeb/webresources/";
    private final WebTarget webTarget;
    private final Client client;

    public ManagerClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("manager");
    }

    public int addIncident(String incidentJson) {
        WebTarget resource = webTarget;
        resource = resource.queryParam("incidentJson", incidentJson);

        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(Integer.class);
    }

    public String getIncident(int id) {
        WebTarget resource = webTarget;
        resource = resource.queryParam("id", id);

        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public void updateIncident(String incidentJson) {
        WebTarget resource = webTarget;
        resource = resource.queryParam("incidentJson", incidentJson);
    }

    public void close() {
        client.close();
    }

}
