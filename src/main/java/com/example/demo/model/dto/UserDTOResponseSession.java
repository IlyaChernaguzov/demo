package com.example.demo.model.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTOResponseSession extends SessionDTORequest{

    MovieDTOResponse movieDTOResponse;
    HallDTORequest hallDTORequest;
}
