package com.example.impl;

import com.example.dao.PaymentDao;
import com.example.entity.Payment;
import com.example.service.PaymentService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    /**
     * @Resource是java自带的
     * @Autowired是Spring的
     */
    @Resource
    private PaymentDao paymentDao;

    @Override
    @Cacheable(value = "payment")
    public Payment getPaymentById(Long id) {
        System.out.println("in mysql");
        return   paymentDao.getPaymentById(id);
    }

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

}
