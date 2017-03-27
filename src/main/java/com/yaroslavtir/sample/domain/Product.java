package com.yaroslavtir.sample.domain;

/**
 * @author ymolodkov on 23.03.17.
 */

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Table(name = "product")
@Entity
@Setter
@Getter
public class Product extends AbstractEntity {


    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ProductLine line;


    @JoinColumn(name = "product_id")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ProductDetail> detail = new HashSet<>();



}
