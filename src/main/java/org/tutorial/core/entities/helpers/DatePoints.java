package org.tutorial.core.entities.helpers;

import javax.persistence.Embeddable;
import java.util.Date;

/**
 * Created by taras on 21.02.17.
 */

@Embeddable
public class DatePoints
{
    private Date startDate;
    private Date planningDate;
    private Date finishDate;

    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getPlanningDate()
    {
        return planningDate;
    }

    public void setPlanningDate(Date planningDate)
    {
        this.planningDate = planningDate;
    }

    public Date getFinishDate()
    {
        return finishDate;
    }

    public void setFinishDate(Date finishDate)
    {
        this.finishDate = finishDate;
    }
}
