package com.firstproject.FirstProject.Service;

import com.firstproject.FirstProject.DTO.OrderDto;
import com.firstproject.FirstProject.Entity.Order;
import com.firstproject.FirstProject.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id){return orderRepository.findById(id);};

    public void addOrder( OrderDto orderDto) throws IOException {
        Order order = new Order();
        order.setUser_id(orderDto.getUser_id());
        order.setName(orderDto.getName());
        order.setPrice(orderDto.getPrice());
        order.setQuantity(orderDto.getQuantity());
        orderRepository.save(order);
    }
}
