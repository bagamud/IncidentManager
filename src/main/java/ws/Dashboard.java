//package ws;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.UriInfo;
//
//@Path("dashboard")
//public class Dashboard {
//    /*
//     TODO: Подключение к базе
//     TODO: Формирование отчетов по полям - Статус, Подразделение, Инженерная группа, За период, так же должно формировать по нескольким полям
//     TODO: На выход отдельный метод должен отрисовывать таблицы на HTML через StringBuilder
//     TODO: Выгрузка в Excel
//     */
//    @Context
//    UriInfo context;
//
//    @GET
//    @Produces("text/html")
//    public String getClichedMessage() {
//        return "Hello World";
//    }
//}
