//package ru.kpp.incidentmanager.services;
//
//import org.springframework.stereotype.Component;
//
//import java.sql.Timestamp;
//import java.util.Date;
//
//@Component
//public class LoggingService {
//
//    final LogBookRepository logBookRepository;
//
//    public LoggingService(LogBookRepository logBookRepository) {
//        this.logBookRepository = logBookRepository;
//    }
//
//    public void record(LogType logType, String username, String logger, String msg, String entity, String changedEntity) {
//        LogBook logBook = new LogBook();
//        logBook.setRecordTimestamp(new Timestamp(new Date().getTime()));
//        logBook.setLogType(logType);
//        logBook.setUsername(username);
//        logBook.setLogger(logger);
//        logBook.setMsg(msg);
//        logBook.setEntityStamp(entity);
//        logBook.setChangedEntityStamp(changedEntity);
//        logBookRepository.save(logBook);
//    }
//}
