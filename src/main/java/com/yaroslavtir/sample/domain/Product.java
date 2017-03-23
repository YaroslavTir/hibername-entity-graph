package com.yaroslavtir.sample.domain;

/**
 * @author ymolodkov on 23.03.17.
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity
//@Data
public class Product implements Serializable {
    @Id
    private Long id = 0L;

    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
