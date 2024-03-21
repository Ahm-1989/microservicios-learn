package com.indra.academy.domain.service;

import com.indra.academy.domain.model.Ine;

import java.io.File;

public interface IneService {
    Ine validIne(File ineBackSide, File ineFrontSide, File selfie, String date) throws Exception;
}
