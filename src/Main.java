import incident.Incident;
import incident.Priority;

public class Main {
    public static void main(String[] args) {
        Incident incident = new Incident("category", new Priority(0,1), "1 отдел УГИБДД",
                "Филиппов Дмитрий", "182", "Не печатает принтер", "Гаврилова Н.С.",
                "в работе");

        System.out.println(incident.getDate() + " " + incident.getPriority().getDescription());
    }
}
