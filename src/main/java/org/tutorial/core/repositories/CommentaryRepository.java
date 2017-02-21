package org.tutorial.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tutorial.core.entities.Commentary;
import org.tutorial.core.entities.CustomerOrder;
import org.tutorial.core.entities.personalities.PersonCore;

import java.util.List;

/**
 * Created by taras on 21.02.17.
 */

@Repository
public interface CommentaryRepository extends CrudRepository<Commentary, Long>
{
    List<Commentary> findByAuthorOrderByInsertedDateDesc(PersonCore author);

    List<Commentary> findByCustomerOrderOrderByInsertedDateDesc(CustomerOrder customerOrder);
}

