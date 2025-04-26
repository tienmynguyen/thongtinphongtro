package com.example.crud.repositories;

import com.example.crud.models.RentalRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRoomRepository extends JpaRepository<RentalRoom, Long> {
    List<RentalRoom> findByTenantNameContainingIgnoreCase(String tenantName);
    List<RentalRoom> findByPhoneNumberContaining(String phoneNumber);

    List<RentalRoom> findByTenantNameContainingIgnoreCaseOrPhoneNumberContaining(String keyword, String keyword1);
}
