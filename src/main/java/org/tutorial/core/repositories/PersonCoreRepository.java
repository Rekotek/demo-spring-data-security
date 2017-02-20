package org.tutorial.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tutorial.core.entities.personalities.PersonCore;

/**
 * Created by taras on 06.02.17.
 */

@Repository
public interface PersonCoreRepository extends CrudRepository<PersonCore, Long>
{

}
