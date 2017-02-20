package org.tutorial.core.entities;

import org.tutorial.core.entities.helpers.DatePoints;
import org.tutorial.core.entities.personalities.Employee;

import javax.persistence.*;

/**
 * Created by taras on 21.02.17.
 */

@Entity
public class OrderTask
{
    @Id @GeneratedValue
    private Long id;

    private String title;
    private String description;

    @Embedded
    private DatePoints datePoints;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Employee employee;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public DatePoints getDatePoints()
    {
        return datePoints;
    }

    public void setDatePoints(DatePoints datePoints)
    {
        this.datePoints = datePoints;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
}
