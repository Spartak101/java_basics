import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;
import net.sf.saxon.functions.AccessorFn;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        Date date = new Date();
        Long dateLong = date.getTime() + 7200000;
        Date date1 = new Date(dateLong);
        return airport
                .getTerminals()
                .stream()
                .flatMap(
                        terminal -> terminal
                                .getFlights()
                                .stream()
                                .filter(
                                        flight -> flight
                                                .getDate()
                                                .getTime() > date.getTime() && flight
                                                .getDate()
                                                .getTime() < date1.getTime()
                                )
                                .filter(
                                        flight -> flight
                                                .getType()
                                                .equals(Flight.Type.DEPARTURE))
                )
                .collect(Collectors.toList()
                );
    }
}
