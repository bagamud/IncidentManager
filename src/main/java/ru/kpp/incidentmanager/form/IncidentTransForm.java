package ru.kpp.incidentmanager.form;

import org.springframework.stereotype.Service;
import ru.kpp.incidentmanager.entity.Incident;
import ru.kpp.incidentmanager.repositories.*;

import java.text.ParseException;

/**
 * Класс предназначен для конвертирования экземпляра класса {@link Incident} в экземпляр класса {@link IncidentForm}
 * для валидации и отображения пользователю в веб-форме manager.jsp и обратно, для взаимодействия введенной пользователем
 * информации об инциденте с методами приложения
 */

@Service
public class IncidentTransForm {

    /**
     * Объявление экземпляра клиента справочников
     */

    final CategoryRepository categoryRepository;
    final DepartmentRepository departmentRepository;
    final PriorityRepository priorityRepository;
    final StatusRepository statusRepository;
    final UsersRepository usersRepository;

    public IncidentTransForm(CategoryRepository categoryRepository, DepartmentRepository departmentRepository,
                             PriorityRepository priorityRepository, StatusRepository statusRepository,
                             UsersRepository usersRepository) {
        this.categoryRepository = categoryRepository;
        this.departmentRepository = departmentRepository;
        this.priorityRepository = priorityRepository;
        this.statusRepository = statusRepository;
        this.usersRepository = usersRepository;
    }

    /**
     * Метод конвертирования экземпляра класса представления {@link IncidentForm} в класс сущности {@link Incident}
     *
     * @param incidentForm экземпляр класса {@link IncidentForm}
     * @return экземпляр класса {@link Incident}
     * @throws ParseException исключение ошибки разбора переменных класса {@link IncidentForm} и заполнения переменных
     *                        сущностей, содержащихся в классе {@link Incident}
     */

    public Incident convert(IncidentForm incidentForm) throws ParseException {

        Incident incident = new Incident();

        incident.setId(incidentForm.getId());
        incident.setDate(incidentForm.getDate());
        incident.setCategory(categoryRepository.findById(incidentForm.getCategory()));
        incident.setPriority(priorityRepository.findById(incidentForm.getPriority()));
        incident.setRequesterdepartment(departmentRepository.findById(incidentForm.getRequesterdepartment()));
        incident.setRequester(incidentForm.getRequester());
        incident.setRequestercontacts(incidentForm.getRequestercontacts());
        incident.setIpaddress(incidentForm.getIpaddress());
        incident.setDuration(incidentForm.getDuration());
        incident.setDescription(incidentForm.getDescription());
        incident.setEngineer(usersRepository.findById(incidentForm.getEngineer()));
        incident.setOperator(usersRepository.findById(incidentForm.getOperator()));
        incident.setStatus(statusRepository.findById(incidentForm.getStatus()));
        incident.setClosedate(incidentForm.getClosedate());
        incident.setJournal(incidentForm.getJournal());

        return incident;
    }

    /**
     * Метод конвертирования экземпляра класса сущности {@link Incident} в класс представления {@link IncidentForm}
     *
     * @param incident экземпляр класса {@link Incident}
     * @return экземпляр класса {@link IncidentForm}
     */

    public IncidentForm convert(Incident incident) {

        IncidentForm incidentForm = new IncidentForm();

        incidentForm.setId(incident.getId());
        incidentForm.setDate(incident.getDate());
        incidentForm.setCategory(incident.getCategory().getId());
        incidentForm.setCategoryTitle(incident.getCategory().getTitle());
        if (incident.getPriority() != null) {
            incidentForm.setPriority(incident.getPriority().getId());
            incidentForm.setPriorityDescription(incident.getPriority().getDescription());
        }
        incidentForm.setRequesterdepartment(incident.getRequesterdepartment().getId());
        incidentForm.setRequesterdepartmentTitle(incident.getRequesterdepartment().getTitle());
        incidentForm.setRequester(incident.getRequester());
        incidentForm.setRequestercontacts(incident.getRequestercontacts());
        incidentForm.setIpaddress(incident.getIpaddress());
        if (incident.getDuration() != null) incidentForm.setDuration(incident.getDuration());
        incidentForm.setDescription(incident.getDescription());
        incidentForm.setEngineer(incident.getEngineer().getId());
        incidentForm.setEngineerName(incident.getEngineer().getName());
        incidentForm.setOperator(incident.getOperator().getId());
        incidentForm.setOperatorName(incident.getOperator().getName());
        incidentForm.setStatus(incident.getStatus().getId());
        incidentForm.setStatusTitle(incident.getStatus().getTitle());
        incidentForm.setClosedate(incident.getClosedate());
        incidentForm.setJournal(incident.getJournal());

        return incidentForm;
    }
}
