package main.java.clients;

import main.java.entity.Incident;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public class ManagerClient {

    private static final String BASE_URI = "http://localhost:8080/IncidentManagerWeb/webresources/";
    private final WebTarget webTarget;
    private final Client client;

    public ManagerClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("manager");
    }

    public int addIncident(int category, int priority, int rd, String requester, String rc,
                           String ip, int duration, String description, int engineer, int operator, int status) {
        WebTarget resource = webTarget;
        resource = resource.queryParam("category", category).queryParam("priority", priority).queryParam("rd", rd)
                .queryParam("requester", requester).queryParam("rc", rc).queryParam("ip", ip)
                .queryParam("duration", duration).queryParam("description", description)
                .queryParam("engineer", engineer).queryParam("operator", operator).queryParam("status", status);

        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(Integer.class);
    }

    public Incident getIncident(int id) {
        WebTarget resource = webTarget;
        resource = resource.queryParam("id", id);

        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(Incident.class);
    }

    public void updateIncident(int id, int category, int priority, int rd, String requester, String rc,
                               String ip, int duration, String description, int engineer, int operator, int status) {
        WebTarget resource = webTarget;
        resource = resource.queryParam("id", id).queryParam("category", category).queryParam("priority", priority)
                .queryParam("rd", rd).queryParam("requester", requester).queryParam("rc", rc)
                .queryParam("ip", ip).queryParam("duration", duration).queryParam("description", description)
                .queryParam("engineer", engineer).queryParam("operator", operator).queryParam("status", status);
    }

    public void close() {
        client.close();
    }

}
