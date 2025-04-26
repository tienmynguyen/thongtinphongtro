package com.example.crud.repositories;

import com.example.crud.models.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayMentTypeRepository extends JpaRepository<PaymentType, Long> {

}
