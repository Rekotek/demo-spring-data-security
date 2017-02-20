package org.tutorial.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tutorial.core.entities.helpers.Phone;

/**
 * Created by taras on 07.02.17.
 */

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Long>
{
}
