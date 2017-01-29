package org.itnavigator.customerscatalog.model;

import javax.persistence.*;

/**
 * Created by lion on 26.01.17.
 */

@Entity
@Table(name = "phonenumbers")
public class PhoneNumber {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "number")
    private String number;

    @Column(name = "description")
    private String description;

    //@Enumerated(EnumType.STRING)
    @Column(name = "type")
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
