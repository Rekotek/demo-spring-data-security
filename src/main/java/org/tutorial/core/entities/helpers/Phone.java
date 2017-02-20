package org.tutorial.core.entities.helpers;

import org.tutorial.core.entities.personalities.PersonCore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by taras on 06.02.17.
 */

@Entity
public class Phone
{
    @Id
    @GeneratedValue
    private Long id;

    private String number;
    private String descr;

    @ManyToOne
    private PersonCore person;

    @Override
    public String toString()
    {
        return "Phone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", descr='" + descr + '\'' +
                '}';
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getDescr()
    {
        return descr;
    }

    public void setDescr(String descr)
    {
        this.descr = descr;
    }

    public PersonCore getPerson()
    {
        return person;
    }

    public void setPerson(PersonCore person)
    {
        this.person = person;
    }
}
