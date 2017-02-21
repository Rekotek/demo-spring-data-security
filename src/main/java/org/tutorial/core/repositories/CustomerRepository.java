package org.tutorial.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tutorial.core.entities.personalities.Customer;

/**
 * Created by taras on 21.02.17.
 */

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>
{
}
