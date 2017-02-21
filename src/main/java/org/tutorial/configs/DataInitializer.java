package org.tutorial.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.tutorial.core.entities.helpers.Address;
import org.tutorial.core.entities.helpers.Phone;
import org.tutorial.core.entities.personalities.*;
import org.tutorial.core.repositories.*;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static org.tutorial.core.entities.helpers.Gender.MAN;
import static org.tutorial.core.entities.personalities.RoleName.*;
import static org.tutorial.helpers.RandomChooser.getRandom;

/**
 * Created by taras on 07.02.17.
 */

@Component
public class DataInitializer
{
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private Role roleAdmin;
    private Role roleCustomer;
    private Role roleManager;
    private Role roleEmployee;


    @PostConstruct
    @Transactional
    public void loadInitialData()
    {
        initializeRoles();

        loadManagers();
        loadAdmin();
        loadEmployees();
    }

    private void loadEmployees()
    {
        for (int i = 0; i < 20; i++) {
            Employee employee = new Employee();

            initPersonCore(employee);
            initLoggablePerson(employee,
                    "empl_" + i,
                    bCryptPasswordEncoder.encode("www"),
                    new Role[] {roleEmployee});

            employeeRepository.save(employee);
        }
    }

    private void loadAdmin()
    {
        Admin admin = new Admin();

        initPersonCore(admin);

        initLoggablePerson(admin,
                "admin",
                bCryptPasswordEncoder.encode("aaa"),
                new Role[] {roleAdmin});

        adminRepository.save(admin);
    }

    private void initializeRoles()
    {
        roleAdmin = new Role();
        roleAdmin.setRoleName(ROLE_ADMIN);

        roleCustomer = new Role();
        roleCustomer.setRoleName(ROLE_CUSTOMER);

        roleManager = new Role();
        roleManager.setRoleName(ROLE_MANAGER);

        roleEmployee = new Role();
        roleEmployee.setRoleName(ROLE_EMPLOYEE);

        roleRepository.save(asList(roleAdmin, roleManager, roleCustomer, roleEmployee));
    }

    private void loadManagers()
    {
        final String[] TITLES = {"Генерал", "Надзиратель", "Рубаха-парень", "Кризис-менеджер"};

        for (int i = 1; i < 11; i++) {
            Manager manager = new Manager();
            
            initPersonCore(manager);

            initLoggablePerson(manager,
                    "manager_" + i,
                    bCryptPasswordEncoder.encode("qqq"),
                    new Role[] {roleManager, roleEmployee});

            manager.setActive(true);
            manager.setInStaff(true);
            manager.setOccupationTitle(getRandom(TITLES));

            managerRepository.save(manager);

            savePhones(manager, i);
        }
    }

    private void initLoggablePerson(LoggableUser person, String login, String password, Role[] roles)
    {
        person.setLogin(login);
        person.setPassword(password);

        applyRoles(person, roles);
    }


    private void applyRoles(LoggableUser loggableUser, Role[] roles)
    {
        Set<Role> roleSet = new HashSet<>(asList(roles));

        loggableUser.setRoles(roleSet);
    }

    private static void initPersonCore(PersonCore person)
    {
        final String[] SURNAMES = {"Пупкин", "Крамник", "Иванчук", "Со", "Непомнящий", "Карякин", "Карлсен"};
        final String[] NAMES = {"Владимир", "Василий", "Магнус", "Ян", "Веселин", "Степан"};
        final String[] SECOND_NAMES = {"Петрович", "Михалыч", "Степаныч", "Иваныч"};

        person.setSurname(getRandom(SURNAMES));
        person.setFirstName(getRandom(NAMES));
        person.setSecondName(getRandom(SECOND_NAMES));
        person.setGender(MAN);

        person.setPassportAddress(receiveAddress());
        person.setShippingAddress(receiveAddress());
    }
    
    
    private static Address receiveAddress()
    {
        final String ADDRESSES[] = {"улица Яблочная", "бульвар Рыбный", "проспект Малиновый"};
        final String[] CITIES = {"Пекин", "Лондон", "Урюпинск", "Мелкомягковск", "Оракулов"};

        Address address = new Address();
        address.setAddressLine1(getRandom(ADDRESSES));
        address.setAddressLine2("дом 11б кв 21");
        address.setCity(getRandom(CITIES));
        address.setPostCode("21022");

        return address;
    }


    private void savePhones(PersonCore person, int num)
    {
        Phone phone1 = new Phone();
        phone1.setNumber("222-33-" + 15 * (num + 1));
        phone1.setDescr("Рабочий");
        phone1.setPerson(person);

        Phone phone2 = new Phone();
        phone2.setNumber("111-22-" + 40 * (num + 6));
        phone2.setDescr("Домашний");
        phone2.setPerson(person);

        phoneRepository.save(asList(phone1, phone2));
    }
}
