package ru.itis.servicecoffe.services;



import org.springframework.core.convert.converter.Converter;

import java.time.LocalTime;

public class ConvertTimeImpl implements Converter<Integer, LocalTime> {

    private String timePattern = "HH:mm";

    public String getTimePattern() {
        return timePattern;
    }

    public void setTimePattern(String timePattern) {
        this.timePattern = timePattern;
    }

    @Override
    public LocalTime convert(Integer integer) {
        if(integer >60){
            int hours = integer/60;
            int minutes = integer%100;
            return LocalTime.now().plusHours(hours).plusMinutes(minutes);
        }
        return LocalTime.now().plusMinutes(integer);
    }
}
