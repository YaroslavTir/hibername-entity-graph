package com.yaroslavtir.sample.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ymolodkov on 23.03.17.
 */

@Table
@Entity
@Data
public class OrderItem  implements Serializable {

    @Id
    private Long id = 0L;

    @Column
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Product product;

}
