package main.java.clients;

import main.java.entity.Incident;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
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

    public void addIncident(String incident) {
        webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(incident, MediaType.APPLICATION_JSON));
    }

    public Incident getIncident(int id) {
        WebTarget resource = webTarget.queryParam("id", id);
        return resource.request(MediaType.APPLICATION_JSON).get(Incident.class);
    }

    public void updateIncident(Incident incident) {
        webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(incident, MediaType.APPLICATION_JSON));
    }

    public String getAllIncidents() {
        return webTarget.request(MediaType.APPLICATION_JSON).get(String.class);
    }

    public void close() {
        client.close();
    }

}
