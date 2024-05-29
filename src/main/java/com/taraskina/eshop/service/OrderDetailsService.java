package com.taraskina.eshop.service.impl;

import com.taraskina.eshop.entity.OrderDetails;
import com.taraskina.eshop.repository.OrderDetailsRepository;
import com.taraskina.eshop.service.OrderDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    @Override
    public List<OrderDetails> findAll() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public OrderDetails save(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public OrderDetails findById(Long id) {
        return orderDetailsRepository.findById(id).orElseThrow();
    }

    @Override
    public OrderDetails update(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public void delete(Long id) {
        orderDetailsRepository.deleteById(id);
    }
}
