package org.tutorial.core.entities.personalities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by taras on 06.02.17.
 */

@Entity
public class Employee extends LoggableUser
{
    private String workCondition;

    private long salaryPerHour;

    @ManyToOne
    private Manager manager;

    public String getWorkCondition()
    {
        return workCondition;
    }

    public void setWorkCondition(String workCondition)
    {
        this.workCondition = workCondition;
    }

    public long getSalaryPerHour()
    {
        return salaryPerHour;
    }

    public void setSalaryPerHour(long salaryPerHour)
    {
        this.salaryPerHour = salaryPerHour;
    }

    public Manager getManager()
    {
        return manager;
    }

    public void setManager(Manager manager)
    {
        this.manager = manager;
    }
}
