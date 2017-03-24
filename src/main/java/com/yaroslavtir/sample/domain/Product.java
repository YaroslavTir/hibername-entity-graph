package com.yaroslavtir.sample.domain;

/**
 * @author ymolodkov on 23.03.17.
 */

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "product")
@Entity
@Data
public class Product implements Serializable {

    @Id
    private Long id = 0L;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ProductLine line;

}
