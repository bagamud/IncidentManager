package ws;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("/dashboard")
public class Dashboard {
    /**
     * TODO: ����������� � ����
     * TODO: ������������ ������� �� ����� - ������, �������������, ���������� ������, �� ������, ��� �� ������ ����������� �� ���������� �����
     * TODO: �� ����� ��������� ����� ������ ������������ ������� �� HTML ����� StringBuilder
     * TODO: �������� � Excel
     * TODO: SessionFactory ������� � Stateful �����
     */
    @Context
    UriInfo context;

    @GET
    @Produces("text/html")
    public String getClichedMessage() {
        return "Hello World";
    }
}
