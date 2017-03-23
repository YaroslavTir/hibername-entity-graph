package com.yaroslavtir.sample.repositories;

import com.yaroslavtir.sample.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ymolodkov on 23.03.17.
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
