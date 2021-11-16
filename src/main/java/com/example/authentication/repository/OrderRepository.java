package com.example.authentication.repository;

import com.example.authentication.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    public Order findByMsisdn(Long msisdn) throws Exception;
}
