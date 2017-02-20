package org.tutorial.reposotories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tutorial.core.entities.personalities.Role;
import org.tutorial.core.repositories.RoleRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.tutorial.core.entities.personalities.RoleName.*;

/**
 * Created by taras on 07.02.17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRepositoryTest
{
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void loadedRoles() {
        List<Role> roles = (List<Role>) roleRepository.findAll();

        assertEquals(3, roles.size());

        List<String> roleNames = roles.stream()
                .map(role -> role.getRoleName().name())
                .collect(toList());

        assertTrue(roleNames.contains(ROLE_ADMIN));
        assertTrue(roleNames.contains(ROLE_CUSTOMER));
        assertTrue(roleNames.contains(ROLE_MANAGER));
    }
}
