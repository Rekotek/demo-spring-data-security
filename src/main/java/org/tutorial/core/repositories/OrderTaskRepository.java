package org.tutorial.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tutorial.core.entities.OrderTask;

/**
 * Created by taras on 21.02.17.
 */

@Repository
public interface OrderTaskRepository extends CrudRepository<OrderTask, Long>
{

}
