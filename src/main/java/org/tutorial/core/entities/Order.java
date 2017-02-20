package org.tutorial.core.entities;

import org.tutorial.core.entities.helpers.DatePoints;
import org.tutorial.core.entities.personalities.Customer;
import org.tutorial.core.entities.personalities.Manager;

import javax.persistence.*;
import java.util.List;

/**
 * Created by taras on 21.02.17.
 */

@Entity
@Table(name = "CUSTOMER_ORDER") // Order is reserved word!
public class Order
{
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;

    @Embedded
    private DatePoints datePoints;

    @ManyToOne
    private Customer responsibleCustomer;

    @ManyToOne
    private Manager responsibleManager;

    @OneToMany(mappedBy = "order")
    private List<OrderTask> orderTaskList;

    @OneToMany(mappedBy = "order")
    private List<Commentary> commentaries;

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

    public DatePoints getDatePoints()
    {
        return datePoints;
    }

    public void setDatePoints(DatePoints datePoints)
    {
        this.datePoints = datePoints;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Customer getResponsibleCustomer()
    {
        return responsibleCustomer;
    }

    public void setResponsibleCustomer(Customer responsibleCustomer)
    {
        this.responsibleCustomer = responsibleCustomer;
    }

    public Manager getResponsibleManager()
    {
        return responsibleManager;
    }

    public void setResponsibleManager(Manager responsibleManager)
    {
        this.responsibleManager = responsibleManager;
    }

    public List<OrderTask> getOrderTaskList()
    {
        return orderTaskList;
    }

    public void setOrderTaskList(List<OrderTask> orderTaskList)
    {
        this.orderTaskList = orderTaskList;
    }

    public List<Commentary> getCommentaries()
    {
        return commentaries;
    }

    public void setCommentaries(List<Commentary> commentaries)
    {
        this.commentaries = commentaries;
    }
}
