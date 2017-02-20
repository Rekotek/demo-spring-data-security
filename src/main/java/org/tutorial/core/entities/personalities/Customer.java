package org.tutorial.core.entities.personalities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by taras on 06.02.17.
 */

@Entity
public class Customer extends PersonCore
{
    private String summary;

    @ManyToOne
    private Manager responsibleManager;

    public String getSummary()
    {
        return summary;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public Manager getResponsibleManager()
    {
        return responsibleManager;
    }

    public void setResponsibleManager(Manager responsibleManager)
    {
        this.responsibleManager = responsibleManager;
    }
}
