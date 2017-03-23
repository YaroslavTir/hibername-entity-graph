package com.yaroslavtir.sample;

import com.yaroslavtir.sample.domain.OrderItem;
import com.yaroslavtir.sample.domain.Orderdata;
import com.yaroslavtir.sample.domain.Product;
import com.yaroslavtir.sample.repositories.OrderRepository;
import com.yaroslavtir.sample.repositories.OrderItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SampleApplication.class)
@WebAppConfiguration
@Transactional
public class EntityGraphTests {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Before
	public void setUp() throws Exception {
		Product product = new Product();
		product.setName("test");

		OrderItem orderItem = new OrderItem();
		orderItem.setProduct(product);


		Orderdata orderdata = new Orderdata();
		orderdata.setOrderNumber("test number");
		orderdata.getItems().add(orderItem);

		Orderdata save = orderRepository.save(orderdata);
		orderItemRepository.save(orderItem);

		entityManager.flush();
		entityManager.clear();
	}

	@Test
	public void contextLoads() {

		List<Orderdata> orders = orderRepository.findAll();
		orders.stream()
				.forEach(orderData -> orderData.getItems().stream()
				.forEach(item ->
						System.out.println(item.getProduct().getName())));
		org.junit.Assert.assertEquals(1, orders.size());
	}

}
