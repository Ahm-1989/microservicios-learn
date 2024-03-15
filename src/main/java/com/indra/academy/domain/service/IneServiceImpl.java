package com.indra.academy.domain.service;

import com.indra.academy.domain.model.Image;
import com.indra.academy.domain.model.Ine;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Log4j2
public class IneServiceImpl implements IneService {

    @Override
    public Ine validIne(File ineBackSide, File ineFrontSide, File selfie, String date) throws Exception {

        UUID uuid = UUID.randomUUID();
        log.info("IneId: {}", uuid);

        Image ineBackImage = validImage(ineBackSide, "BACK_INE");
        Image ineFrontImage = validImage(ineFrontSide, "FRONT_INE");
        Image selfieImage = validImage(selfie, "SELFIE");
        Date dateIne = validDate(date);

        return new Ine (uuid, ineBackImage, ineFrontImage, selfieImage, dateIne);
    }

    private Image validImage(File file, String type) throws Exception {

        if (file == null){
            throw new Exception(type + " can't be null");
        }

        Image image = new Image(file, type);
        String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);

        image.setValid(extension.equals("jpg") || extension.equals("jpeg"));
        log.info("File name: {}", file.getName());
        log.info("File type: {}", type);
        log.info("File is valid: {}", image.isValid());

        if (!image.isValid()){
            throw new Exception(image.getType() + " doesn't have a valid format");
        }

        return image;
    }

    private Date validDate(String stringDate) throws Exception {
        log.info("Date: {}", stringDate);
        String formatPattern = "^([0][1-9]|[12][0-9]|3[01])(\\/|-)([0][1-9]|[1][0-2])\\2(\\d{4})";
        if (!stringDate.matches(formatPattern)) {
            throw new Exception("The date doesn't have a valid format");
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return formatter.parse(stringDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
