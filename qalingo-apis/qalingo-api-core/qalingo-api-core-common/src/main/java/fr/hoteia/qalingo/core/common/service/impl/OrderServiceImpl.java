/**
 * Most of the code in the Qalingo project is copyrighted Hoteia and licensed
 * under the Apache License Version 2.0 (release version ${license.version})
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *                   Copyright (c) Hoteia, 2012-2013
 * http://www.hoteia.com - http://twitter.com/hoteia - contact@hoteia.com
 *
 */
package fr.hoteia.qalingo.core.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.hoteia.qalingo.core.common.dao.OrderDao;
import fr.hoteia.qalingo.core.common.domain.Order;
import fr.hoteia.qalingo.core.common.service.OrderService;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	public Order getOrderById(String rawOrderId) {
		long orderId = -1;
		try {
			orderId = Long.parseLong(rawOrderId);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}
		return orderDao.getOrderById(orderId);
	}

	public List<Order> findOrdersByCustomerId(String customerId) {
		return orderDao.findOrdersByCustomerId(Long.parseLong(customerId));
	}

	public void saveOrUpdateOrder(Order order) {
		orderDao.saveOrUpdateOrder(order);
	}

	public void deleteOrder(Order order) {
		orderDao.deleteOrder(order);
	}

}