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
@Table(name = "order_data")
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "graph.OrderData.items",
                includeAllAttributes = true,
                attributeNodes = {
                        @NamedAttributeNode(value = "items", subgraph = "items")
                }
        )
})

public class OrderData extends BaseOrderData {


}
