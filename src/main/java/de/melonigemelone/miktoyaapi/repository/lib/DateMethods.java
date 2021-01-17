package de.melonigemelone.miktoyaapi.repository.lib;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateMethods {

    //Gibt die UhrZeit von den Millisekunden an
    public static String getClockTimeFromMillis(long millis) {
        Date currentDate = new Date(millis);
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(currentDate);
    }

    //Gibt das Datum von den Millisekunden an
    public static String getDateFromMillis(long millis) {
        Date currentDate = new Date(millis);
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        return df.format(currentDate);
    }

    //Gibt das Datum  und die Uhrzeit von den Millisekunden an
    public static String getDateAndTimeFromMillis(long millis) {
        Date currentDate = new Date(millis);
        DateFormat df = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        return df.format(currentDate);
    }

    //Gibt die Millisekunden in einer Zeitangabe an PlaceHolder(%days%, %hours%, %minutes%, %seconds%)
    public static String getTimeFromMillis(long millis) {
        int seconds = (int) (millis / 1000) % 60 ;
        int minutes = (int) ((millis / (1000*60)) % 60);
        int hours   = (int) ((millis / (1000*60*60)) % 24);
        int dasy   = (int) ((millis / (1000*60*60*24)) % 365);

        return dasy + " %days%, " + hours + " %hours%, " + minutes + " %minutes%," + seconds + " %seconds%";
    }

    //Gibt das Datum in einem Format zurück, sodass es als File Format verwendet werden kann
    public static String getDateInFileFormat() {
        Date currentDate = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(currentDate);
    }

    //Gibt die UhrZeit in einem Log-Format zurück
    public static String getTimeLogFormat() {
        Date currentDate = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("[HH:mm:ss]");
        return df.format(currentDate);
    }
}
