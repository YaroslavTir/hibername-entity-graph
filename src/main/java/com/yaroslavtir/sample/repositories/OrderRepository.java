package com.yaroslavtir.sample.repositories;

import com.yaroslavtir.sample.domain.OrderData;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ymolodkov on 23.03.17.
 */
public interface OrderRepository  extends JpaRepository<OrderData, Long> {

    @EntityGraph(value = "graph.OrderData.items", type = EntityGraph.EntityGraphType.LOAD)
    List<OrderData> findAll();

}
