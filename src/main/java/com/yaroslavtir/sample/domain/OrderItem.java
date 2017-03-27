package com.yaroslavtir.sample.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ymolodkov on 23.03.17.
 */

@Table
@Entity
@Setter
@Getter
public class OrderItem extends AbstractEntity {


    @Column
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Product product;

}
