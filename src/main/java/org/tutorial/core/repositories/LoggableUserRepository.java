package org.tutorial.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tutorial.core.entities.personalities.LoggableUser;

/**
 * Created by taras on 06.02.17.
 */

@Repository
public interface LoggableUserRepository extends CrudRepository<LoggableUser, Long>
{
    LoggableUser findByLogin(String login);

    LoggableUser findById(Long id);
}
