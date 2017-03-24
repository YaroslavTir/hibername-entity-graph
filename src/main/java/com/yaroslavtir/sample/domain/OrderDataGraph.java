package com.yaroslavtir.sample.domain;

import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.NamedSubgraph;

/**
 * @author ymolodkov on 24.03.17.
 */
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
                                attributeNodes = @NamedAttributeNode("product"))
                }
        )
})
public interface OrderDataGraph {
}
