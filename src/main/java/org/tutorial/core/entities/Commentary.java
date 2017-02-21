package org.tutorial.core.entities;

import org.tutorial.core.entities.personalities.PersonCore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by taras on 07.02.17.
 */

@Entity
public class Commentary
{
    @Id @GeneratedValue
    private Long id;

    private String text;

    private Date insertedDate;

    @ManyToOne
    private PersonCore author;

    @ManyToOne
    private CustomerOrder customerOrder;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public PersonCore getAuthor()
    {
        return author;
    }

    public void setAuthor(PersonCore author)
    {
        this.author = author;
    }

    public Date getInsertedDate()
    {
        return insertedDate;
    }

    public void setInsertedDate(Date insertedDate)
    {
        this.insertedDate = insertedDate;
    }

    public CustomerOrder getCustomerOrder()
    {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder)
    {
        this.customerOrder = customerOrder;
    }
}
