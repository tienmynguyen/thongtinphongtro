package com.example.crud.controllers;


import com.example.crud.models.PaymentType;
import com.example.crud.models.RentalRoomDto;
import com.example.crud.repositories.PayMentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.example.crud.models.RentalRoom;
import com.example.crud.repositories.RentalRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class RentalRoomWebController {
    @Autowired
    private final RentalRoomRepository rentalRoomRepository;
    @Autowired
    private final PayMentTypeRepository payMentTypeRepository;
    @GetMapping("/rooms")
    public String showSearchForm(@RequestParam(required = false) String keyword,
                                 Model model) {
        List<RentalRoom> rooms;

        if (keyword != null && !keyword.isEmpty()) {
            boolean found = false;
            rooms = new java.util.ArrayList<>();

            // Nếu là số, thử tìm theo ID
            if (keyword.matches("\\d+")) {
                Optional<RentalRoom> room = rentalRoomRepository.findById(Long.parseLong(keyword));
                List<RentalRoom> finalRooms = rooms;
                room.ifPresent(r -> {
                    finalRooms.add(r);
                });
                found = room.isPresent();
            }

            // Nếu không tìm được ID, hoặc keyword không phải số, tìm theo tên hoặc số điện thoại
            if (!found) {
                rooms = rentalRoomRepository.findByTenantNameContainingIgnoreCaseOrPhoneNumberContaining(keyword, keyword);
            }
        } else {
            rooms = rentalRoomRepository.findAll();
        }

        model.addAttribute("rooms", rooms);
        model.addAttribute("keyword", keyword);
        return "room-search";
    }

    @GetMapping("/")
    public String redirectToRooms() {
        return "redirect:/rooms";
    }

    @GetMapping("/create")
    public String create(Model model) {
        RentalRoomDto dto = new RentalRoomDto();
        model.addAttribute("dto", dto);
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute RentalRoomDto dto, BindingResult result) {
    Optional<PaymentType> paymentType = payMentTypeRepository.findById(dto.getPaymentType());
    if (paymentType.isEmpty()) {
        return "create";
    }
        if (result.hasErrors()) {
            return "create";
        }
        Date date = new Date();
        LocalDate localDate = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    RentalRoom rentalRoom = new RentalRoom();
        rentalRoom.setPaymentType(paymentType.get());
        rentalRoom.setTenantName(dto.getTenantName());
        rentalRoom.setPhoneNumber(dto.getPhoneNumber());
        rentalRoom.setRentalDate(LocalDate.now());
        rentalRoom.setNote(dto.getNote());
        rentalRoomRepository.save(rentalRoom);
        return "redirect:/rooms";
    }

    @PostMapping("/rooms/delete")
    public String deleteMultiple(@RequestParam("selectedIds") List<Long> selectedIds) {
        RentalRoomRepository repo = rentalRoomRepository;
        repo.deleteAllById(selectedIds);
        return "redirect:/rooms";
    }


}

