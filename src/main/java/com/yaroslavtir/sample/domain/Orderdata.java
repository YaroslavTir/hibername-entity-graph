package com.yaroslavtir.sample.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * @author ymolodkov on 23.03.17.
 */
@Entity
@Table
@Data
public class Orderdata implements Serializable {

    @Id
    private Long id = 0L;

    @Column
    private String orderNumber;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderItem> items = new HashSet<>();

}
