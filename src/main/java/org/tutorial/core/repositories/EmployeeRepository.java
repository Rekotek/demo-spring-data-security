package org.tutorial.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tutorial.core.entities.personalities.Employee;
import org.tutorial.core.entities.personalities.Manager;

import java.util.List;

/**
 * Created by taras on 07.02.17.
 */

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>
{
    List<Employee> findByManager(Manager manager);
}
