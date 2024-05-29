package com.taraskina.eshop.service;

import com.taraskina.eshop.entity.OrderDetails;
import com.taraskina.eshop.repository.OrderDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderDetailsService {
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    public List<OrderDetails> findAll() {
        return orderDetailsRepository.findAll();
    }

    public OrderDetails save(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    public OrderDetails findById(Long id) {
        return orderDetailsRepository.findById(id).orElseThrow();
    }

    public OrderDetails update(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    public void delete(Long id) {
        orderDetailsRepository.deleteById(id);
    }
}
