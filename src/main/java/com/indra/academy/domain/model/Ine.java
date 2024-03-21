package com.indra.academy.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class Ine {

    private UUID id;
    private Image backSide;
    private Image frontSide;
    private Image selfie;
    private Date date;
}
