package com.indra.academy.domain.service;

import com.indra.academy.domain.model.Ine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class IneServiceTests {

    @InjectMocks
    private IneServiceImpl ineService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void validIneTest() throws Exception {
        //File back = mock(File.class, "back.jpeg");
        File back = new File(getClass().getClassLoader().getResource("back.jpeg").getFile());
        File front = new File(getClass().getClassLoader().getResource("front.jpeg").getFile());
        File selfie = new File(getClass().getClassLoader().getResource("selfie.jpg").getFile());
        Ine ine = ineService.validIne(back, front, selfie, "14-03-2024");
        assertNotNull(ine.getId());
        assertEquals(ine.getBackSide().getImage().getName(), "back.jpeg");
        assertEquals(ine.getFrontSide().getImage().getName(), "front.jpeg");
        assertEquals(ine.getSelfie().getImage().getName(), "selfie.jpg");
    }

    @Test
    void validIneBackSideNullTest() throws Exception {
        Exception exception = assertThrows(Exception.class, () -> {
            ineService.validIne(null, null, null, "14-03-2024");
        });
        assertEquals("BACK_INE can't be null", exception.getMessage());
    }

    @Test
    void validIneFrontSideNullTest() throws Exception {
        File back = new File(getClass().getClassLoader().getResource("back.jpeg").getFile());

        Exception exception = assertThrows(Exception.class, () -> {
            ineService.validIne(back, null, null, "14-03-2024");
        });
        assertEquals("FRONT_INE can't be null", exception.getMessage());
    }

    @Test
    void validIneSelfieSideNullTest() throws Exception {
        File back = new File(getClass().getClassLoader().getResource("back.jpeg").getFile());
        File front = new File(getClass().getClassLoader().getResource("front.jpeg").getFile());

        Exception exception = assertThrows(Exception.class, () -> {
            ineService.validIne(back, front, null, "14-03-2024");
        });
        assertEquals("SELFIE can't be null", exception.getMessage());
    }

    @Test
    void validIneDateInvalidFormatTest() throws Exception {
        File back = new File(getClass().getClassLoader().getResource("back.jpeg").getFile());
        File front = new File(getClass().getClassLoader().getResource("front.jpeg").getFile());
        File selfie = new File(getClass().getClassLoader().getResource("selfie.jpg").getFile());

        Exception exception = assertThrows(Exception.class, () -> {
            ineService.validIne(back, front, selfie, "1403-2024");
        });
        assertEquals("The date doesn't have a valid format", exception.getMessage());
    }

    @Test
    void validIneImageInvalidFormatTest() throws Exception {
        File back = new File(getClass().getClassLoader().getResource("back.txt").getFile());
        File front = new File(getClass().getClassLoader().getResource("front.jpeg").getFile());
        File selfie = new File(getClass().getClassLoader().getResource("selfie.jpg").getFile());

        Exception exception = assertThrows(Exception.class, () -> {
            ineService.validIne(back, front, selfie, "14-03-2024");
        });
        assertEquals("BACK_INE doesn't have a valid format", exception.getMessage());
    }

}
