package com.indra.academy.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

@Setter
@Getter
public class Image {
    private File image;
    private boolean valid;
    private String type;

    public Image (File image, String type){
        this.image = image;
        this.valid = image != null;
        this.type = type;
    }
}
