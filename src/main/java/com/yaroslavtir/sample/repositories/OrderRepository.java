package com.yaroslavtir.sample.repositories;

import com.yaroslavtir.sample.domain.Orderdata;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ymolodkov on 23.03.17.
 */
public interface OrderRepository  extends JpaRepository<Orderdata, Long> {
}
