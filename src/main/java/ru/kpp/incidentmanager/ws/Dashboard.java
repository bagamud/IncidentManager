//package ru.kpp.incidentmanager.ws;
//
//import javax.ru.kpp.incidentmanager.ws.rs.GET;
//import javax.ru.kpp.incidentmanager.ws.rs.Path;
//import javax.ru.kpp.incidentmanager.ws.rs.Produces;
//import javax.ru.kpp.incidentmanager.ws.rs.core.Context;
//import javax.ru.kpp.incidentmanager.ws.rs.core.UriInfo;
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
