package main.java.clients;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class VocabularyClient {
    /*
     TODO:
     */
    private static final String BASE_URI = "http://localhost:8090/IncidentManagerWeb/webresources/";
    private final WebTarget webTarget;
    private final Client client;

    public VocabularyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("vocabulary");
    }

    public String getSource(String source) {
        WebTarget resource = webTarget;
        resource = resource.queryParam("source", source);
        return resource.request(MediaType.APPLICATION_JSON).get(String.class);
    }

}
