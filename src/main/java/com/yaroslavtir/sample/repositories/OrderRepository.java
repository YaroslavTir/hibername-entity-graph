package com.yaroslavtir.sample.repositories;

import com.yaroslavtir.sample.domain.Orderdata;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * @author ymolodkov on 23.03.17.
 */
public interface OrderRepository  extends JpaRepository<Orderdata, Long> {

    @EntityGraph(value = "graph.Order.items", type = EntityGraph.EntityGraphType.LOAD)
    List<Orderdata> findAll();

}
