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
                },
                subgraphs = {
                        @NamedSubgraph(
                                name = "items",
                                attributeNodes = {
                                        @NamedAttributeNode(value = "product", subgraph = "product")
                                }),
                        @NamedSubgraph(
                                name = "product",
                                attributeNodes = {
                                        @NamedAttributeNode("line"),
                                        @NamedAttributeNode("detail")
                                })
                }
        )
})

@Data
public class OrderData implements Serializable {

    @Id
    private Long id = 0L;

    @Column
    private String orderNumber;

    @JoinColumn(name = "id")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderItem> items = new HashSet<>();

}
