package com.yaroslavtir.sample.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ymolodkov on 23.03.17.
 */


@Entity
@DiscriminatorValue("ORDER_DATS")
@Table(name = "order_data")
@Setter
@Getter
public class OrderData extends OrderDataBase {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private OrderItem superItem;
}
