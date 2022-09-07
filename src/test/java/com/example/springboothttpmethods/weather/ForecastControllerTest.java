package com.example.springboothttpmethods.weather;

import org.junit.jupiter.api.Test;

class ForecastControllerTest {

    @Test
    void today() {
        String today = new ForecastController().today();
        System.out.println(today);
    }
}