package org.tutorial.core.entities.personalities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by taras on 06.02.17.
 */

@Entity
public class Manager extends LoggableUser
{
    private String occupationTitle;

    @OneToMany(mappedBy = "responsibleManager", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Customer> customers;

    @OneToMany(mappedBy = "manager")
    @JsonIgnore
    private List<Employee> employees;

    @Override
    public String toString()
    {
        return "Manager{" +
                "occupationTitle='" + occupationTitle + '\'' +
                ", customers=" + customers +
                ", employees=" + employees +
                "} " + super.toString();
    }

    public String getOccupationTitle()
    {
        return occupationTitle;
    }

    public void setOccupationTitle(String occupationTitle)
    {
        this.occupationTitle = occupationTitle;
    }

    public List<Customer> getCustomers()
    {
        return customers;
    }

    public void setCustomers(List<Customer> customers)
    {
        this.customers = customers;
    }

    public List<Employee> getEmployees()
    {
        return employees;
    }

    public void setEmployees(List<Employee> employees)
    {
        this.employees = employees;
    }
}
