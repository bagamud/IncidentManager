package main.java.clients;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class AuthClient {
    /**
     * TODO: ������� �� ������
     * TODO: ����������� ������ ����������� �� ������ HttpSession
     * TODO: � ������ ������������� ������� �� ������ ���� �������� ������, ������ ���
     */
    private static final String BASE_URI = "http://localhost:8090/IncidentManagerWeb/webresources/";
    private final WebTarget webTarget;
    private final Client client;

    public AuthClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("authorization");
    }

    public String isLogin(String login, String password) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (login != null && password != null) {
            resource = resource.queryParam("login", login).queryParam("password", password);
        }
        return resource.request(MediaType.APPLICATION_JSON).get(String.class);
    }

    public void close() {
        client.close();
    }
}
