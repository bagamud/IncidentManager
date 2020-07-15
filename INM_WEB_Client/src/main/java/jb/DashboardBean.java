package main.java.jb;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.clients.EntityClient;
import main.java.entity.Incident;

import java.io.IOException;

public class DashboardBean {

    EntityClient entityClient;
    ObjectMapper objectMapper;
    Vocabulary vocabulary;

    public DashboardBean() {
    }

    public String getAllIncidentData() {
        StringBuilder sb = new StringBuilder();
        try {
            entityClient = new EntityClient();
            objectMapper = new ObjectMapper();
            vocabulary = new Vocabulary();

            Incident[] incidentJson = objectMapper.readValue(entityClient.getAllIncidents(), Incident[].class);
            for (Incident incident : incidentJson) {
                sb.append("<tr><td>").append(incident.getId()).append("</td><td>")
                        .append(vocabulary.getDepartments()[incident.getRequesterDepartment() - 1].getTitle())
                        .append("</td><td>").append(incident.getDate()).append("</td><td>").append(vocabulary.getUsers()[incident.getOperator() - 1].getName())
                        .append("</td><td>").append(vocabulary.getCategories()[incident.getCategory() - 1].getTitle())
                        .append("</td><td>").append(vocabulary.getStatus()[incident.getStatus() - 1].getTitle()).append("</td></tr>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public String getIncidentDataWhere(String request) {
        StringBuilder sb = new StringBuilder();
        try {
            entityClient = new EntityClient();
            objectMapper = new ObjectMapper();
            vocabulary = new Vocabulary();

            Incident[] incidentJson = objectMapper.readValue(entityClient.getAllIncidents(), Incident[].class);
            for (Incident incident : incidentJson) {
                sb.append("<tr><td>").append(incident.getId()).append("</td><td>")
                        .append(vocabulary.getDepartments()[incident.getRequesterDepartment() - 1].getTitle())
                        .append("</td><td>").append(incident.getDate()).append("</td><td>").append(vocabulary.getUsers()[incident.getOperator() - 1].getName())
                        .append("</td><td>").append(vocabulary.getCategories()[incident.getCategory() - 1].getTitle())
                        .append("</td><td>").append(vocabulary.getStatus()[incident.getStatus() - 1].getTitle()).append("</td></tr>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
