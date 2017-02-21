package org.tutorial.core.entities.personalities;

import org.tutorial.core.entities.CustomerOrder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by taras on 06.02.17.
 */

@Entity
public class Customer extends LoggableUser
{
    private String summary;

    @ManyToOne
    private Manager responsibleManager;

    @OneToMany(mappedBy = "responsibleCustomer")
    private List<CustomerOrder> customerOrders;

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

    public List<CustomerOrder> getCustomerOrders()
    {
        return customerOrders;
    }

    public void setCustomerOrders(List<CustomerOrder> customerOrders)
    {
        this.customerOrders = customerOrders;
    }
}
