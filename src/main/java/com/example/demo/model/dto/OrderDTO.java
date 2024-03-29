package com.example.demo.model.dto;

import com.example.demo.model.enums.Booking;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDTO {

    Long idOrder;
    Long idPlace;
    Long idSession;
}
