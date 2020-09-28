package ru.kpp.incidentmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.kpp.incidentmanager.entity.Faq;

import java.util.List;

public interface FaqRepository extends CrudRepository<Faq, Integer> {
    List<Faq> findAll();
}
