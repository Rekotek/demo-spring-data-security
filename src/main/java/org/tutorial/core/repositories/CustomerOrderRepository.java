package org.tutorial.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tutorial.core.entities.CustomerOrder;
import org.tutorial.core.entities.personalities.Customer;
import org.tutorial.core.entities.personalities.Manager;

import java.util.List;

/**
 * Created by taras on 21.02.17.
 */

@Repository
public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Long>
{
    /*
        Using @Embedded field. Spring Data really smart to understand it...
     */
    List<CustomerOrder> findByResponsibleCustomerOrderByDatePointsStartDateDesc(Customer responsibleCustomer);

    List<CustomerOrder> findByResponsibleManagerOrderByDatePointsStartDateDesc(Manager responsibleManager);
}
