package com.yaroslavtir.sample;

import com.yaroslavtir.sample.domain.OrderItem;
import com.yaroslavtir.sample.domain.OrderData;
import com.yaroslavtir.sample.domain.Product;
import com.yaroslavtir.sample.domain.ProductLine;
import com.yaroslavtir.sample.repositories.OrderItemRepository;
import com.yaroslavtir.sample.repositories.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        ProductLine productLine = new ProductLine();
        productLine.setLine("testLine");
        productLine.setTextDescription("description test");

        Product product = new Product();
		product.setName("test");
        product.setLine(productLine);

		OrderItem orderItem = new OrderItem();
		orderItem.setProduct(product);


		OrderData orderData = new OrderData();
		orderData.setOrderNumber("test number");
		orderData.getItems().add(orderItem);

		orderRepository.save(orderData);

		entityManager.flush();
		entityManager.clear();
	}

	@Test
	public void contextLoads() {

		List<OrderData> orders = orderRepository.findAll();
        orders.stream().flatMap(o -> o.getItems().stream())
                .map(OrderItem::getProduct)
                .map(Product::getLine)
                .map(ProductLine::getTextDescription)
                .forEach(System.out::println);

		assertEquals(1, orders.size());
	}

}
