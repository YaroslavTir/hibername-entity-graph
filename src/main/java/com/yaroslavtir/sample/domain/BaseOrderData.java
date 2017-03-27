package com.yaroslavtir.sample.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ymolodkov on 27.03.17.
 */
@Entity
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "graph.OrderData.base.items",
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
public class BaseOrderData implements Serializable {

    @Id
    private Long id = 0L;

    @Column
    private String orderNumber;

    @JoinColumn(name = "id")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderItem> items = new HashSet<>();

}
