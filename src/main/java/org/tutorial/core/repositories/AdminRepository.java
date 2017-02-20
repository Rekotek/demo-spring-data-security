package org.tutorial.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tutorial.core.entities.personalities.Admin;

/**
 * Created by taras on 18.02.17.
 */
@Repository
public interface AdminRepository extends CrudRepository<Admin, Long>
{
    Admin findByLogin(String login);
}
