package helpers.other;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class GetCurrentDate {

    public String getCurrentDate() {
        return ZonedDateTime.now(ZoneId.of("Europe/Moscow"))
                .format(DateTimeFormatter.ofPattern("dd.MM.yyy"));
    }
}
