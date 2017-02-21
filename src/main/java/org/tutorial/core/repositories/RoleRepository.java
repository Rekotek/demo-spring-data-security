package org.tutorial.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.tutorial.core.entities.personalities.Role;
import org.tutorial.core.entities.personalities.RoleName;

/**
 * Created by taras on 07.02.17.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long>
{
    Role findByRoleName(RoleName roleName);
}
