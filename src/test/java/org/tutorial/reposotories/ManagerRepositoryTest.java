package org.tutorial.reposotories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.tutorial.core.entities.helpers.Phone;
import org.tutorial.core.entities.personalities.Manager;
import org.tutorial.core.repositories.ManagerRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by taras on 07.02.17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ManagerRepositoryTest
{
    @Autowired
    private ManagerRepository managerRepository;

    @Test
    public void loadedManager() {
        List<Manager> managers = (ArrayList<Manager>) managerRepository.findAll();

        assertNotNull(managers);
        assertTrue(managers.size() > 0);

        List<Phone> phones = managers.get(0).getPhones();
        assertTrue(phones.size() > 0);

        System.out.println("===================");
        managers.forEach(System.out::println);
        System.out.println("===================");
    }
}
