package com.yaroslavtir.sample.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ymolodkov on 27.03.17.
 */
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "graph.order-data.base.items",
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
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("ORDER_DATA_BASE")
@Setter
@Getter
public class OrderDataBase extends AbstractEntity {

    @Column
    private String orderNumber;

    @JoinColumn(name = "order_data_id")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderItem> items = new HashSet<>();

}
