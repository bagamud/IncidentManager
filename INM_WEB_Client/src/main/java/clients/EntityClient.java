package main.java.clients;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class EntityClient {
    /**
     * TODO:
     */
    private static final String BASE_URI = "http://localhost:8090/IncidentManagerWeb/webresources/";
    private final WebTarget webTarget;
    private final Client client;

    public EntityClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("manager");
    }

    public void addIncident(String incidentJson) {
        WebTarget resource = webTarget;
        resource = resource.queryParam("incidentJson", incidentJson);

//        return resource.request(MediaType.APPLICATION_JSON).get(String.class);
    }

    public String getIncident(int id) {
        WebTarget resource = webTarget;
        resource = resource.queryParam("id", id);

        return resource.request(MediaType.APPLICATION_JSON).get(String.class);
    }

    public void updateIncident(String incidentJson) {
        WebTarget resource = webTarget;
        resource = resource.queryParam("incidentJson", incidentJson);
    }

    public String getAllIncidents() {
        WebTarget resource = webTarget;

        return resource.request(MediaType.APPLICATION_JSON).get(String.class);
    }

    public void close() {
        client.close();
    }

}
