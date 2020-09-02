//package main.java.ru.kpp.inm_client.clients;
//
//import javax.ru.kpp.incidentmanager.ws.rs.ClientErrorException;
//import javax.ru.kpp.incidentmanager.ws.rs.client.Client;
//import javax.ru.kpp.incidentmanager.ws.rs.client.WebTarget;
//import javax.ru.kpp.incidentmanager.ws.rs.core.MediaType;
//
//public class AuthClient {
//    /*
//     TODO: Хэшсоль на пароль
//     TODO: Авторизация должна сохранятсья на период HttpSession
//     TODO: В строке отправляемого запроса не должен явно читаться пароль, только Хэш
//     */
//    private static final String BASE_URI = "http://localhost:8090/IncidentManagerWeb/webresources/";
//    private final WebTarget webTarget;
//    private final Client client;
//
//    public AuthClient() {
//        client = javax.ru.kpp.incidentmanager.ws.rs.client.ClientBuilder.newClient();
//        webTarget = client.target(BASE_URI).path("authorization");
//    }
//
//    public boolean isLogin(String login, String password) throws ClientErrorException {
//        WebTarget resource = webTarget;
//        if (login != null && password != null) {
//            resource = resource.queryParam("login", login).queryParam("password", password);
//        }
//        return resource.request(MediaType.APPLICATION_JSON).get(Boolean.class);
//    }
//
//    public void close() {
//        client.close();
//    }
//}
