package org.tutorial.core.entities.personalities;

import org.tutorial.core.entities.helpers.Address;
import org.tutorial.core.entities.helpers.Gender;
import org.tutorial.core.entities.helpers.Phone;

import javax.persistence.*;
import java.util.List;

/**
 * Created by taras on 06.02.17.
 */
@Entity
public abstract class PersonCore
{
    @Id @GeneratedValue
    private Long id;

    private String surname;
    private String firstName;
    private String secondName;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="addressLine1", column=@Column(name="PASSPORT_ADDR_LINE_1")),
            @AttributeOverride(name="addressLine2", column=@Column(name="PASSPORT_ADDR_LINE_2")),
            @AttributeOverride(name="city", column=@Column(name="PASSPORT_CITY")),
            @AttributeOverride(name="postCode", column=@Column(name="PASSPORT_POST_CODE"))
    })
    private Address passportAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="addressLine1", column=@Column(name="SHIPPING_ADDR_LINE_1")),
            @AttributeOverride(name="addressLine2", column=@Column(name="SHIPPING_ADDR_LINE_2")),
            @AttributeOverride(name="city", column=@Column(name="SHIPPING_CITY")),
            @AttributeOverride(name="postCode", column=@Column(name="SHIPPING_POST_CODE"))
    })
    private Address shippingAddress;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Phone> phones;

    @Override
    public String toString()
    {
        return "PersonCore{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", gender=" + gender +
                ", passportAddress=" + passportAddress +
                ", shippingAddress=" + shippingAddress +
                ", phones=" + phones +
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

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getSecondName()
    {
        return secondName;
    }

    public void setSecondName(String secondName)
    {
        this.secondName = secondName;
    }

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public Address getPassportAddress()
    {
        return passportAddress;
    }

    public void setPassportAddress(Address passportAddress)
    {
        this.passportAddress = passportAddress;
    }

    public Address getShippingAddress()
    {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress)
    {
        this.shippingAddress = shippingAddress;
    }

    public List<Phone> getPhones()
    {
        return phones;
    }

    public void setPhones(List<Phone> phones)
    {
        this.phones = phones;
    }
}
