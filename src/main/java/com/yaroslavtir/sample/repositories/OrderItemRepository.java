package com.yaroslavtir.sample.repositories;

import com.yaroslavtir.sample.domain.OrderItem;
import com.yaroslavtir.sample.domain.Orderdata;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * @author ymolodkov on 23.03.17.
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


}
