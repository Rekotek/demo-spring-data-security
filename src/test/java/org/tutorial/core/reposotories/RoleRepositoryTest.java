package org.tutorial.core.reposotories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional(readOnly = true)
    public void loadedRoles() {
        List<Role> roles = (List<Role>) roleRepository.findAll();

        System.out.println("================================");

        roles.forEach(r -> System.out.println(r.toString()));

        System.out.println("================================");

        assertEquals(4, roles.size());

        List<String> roleNames = roles.stream()
                .map(role -> role.getRoleName().name())
                .distinct()
                .collect(toList());

        assertTrue(roleNames.contains(ROLE_ADMIN.toString()));
        assertTrue(roleNames.contains(ROLE_CUSTOMER.toString()));
        assertTrue(roleNames.contains(ROLE_MANAGER.toString()));
        assertTrue(roleNames.contains(ROLE_EMPLOYEE.toString()));
    }
}
