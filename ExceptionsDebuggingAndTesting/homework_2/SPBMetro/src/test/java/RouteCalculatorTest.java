import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.*;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    StationIndex stationIndex;

    @Override
    protected void setUp() throws Exception {
        stationIndex = new StationIndex();

        stationIndex.addLine(new Line(1, "Первая"));
        stationIndex.addLine(new Line(2, "Вторая"));
        stationIndex.addLine(new Line(3, "Третья"));

        stationIndex.getLine(1).addStation(new Station("Петровская", stationIndex.getLine(1)));
        stationIndex.getLine(1).addStation(new Station("Корабельная", stationIndex.getLine(1)));
        stationIndex.getLine(1).addStation(new Station("Парусная", stationIndex.getLine(1)));
        stationIndex.getLine(1).addStation(new Station("Такелажная", stationIndex.getLine(1)));
        stationIndex.getLine(1).addStation(new Station("Якорная", stationIndex.getLine(1)));

        stationIndex.addStation(new Station("Петровская", stationIndex.getLine(1)));
        stationIndex.addStation(new Station("Корабельная", stationIndex.getLine(1)));
        stationIndex.addStation(new Station("Парусная", stationIndex.getLine(1)));
        stationIndex.addStation(new Station("Такелажная", stationIndex.getLine(1)));
        stationIndex.addStation(new Station("Якорная", stationIndex.getLine(1)));

        stationIndex.getLine(2).addStation(new Station("Торговая", stationIndex.getLine(2)));
        stationIndex.getLine(2).addStation(new Station("Кожевенная", stationIndex.getLine(2)));
        stationIndex.getLine(2).addStation(new Station("Охотская", stationIndex.getLine(2)));
        stationIndex.getLine(2).addStation(new Station("Рыбацкая", stationIndex.getLine(2)));
        stationIndex.getLine(2).addStation(new Station("Кузнечная", stationIndex.getLine(2)));

        stationIndex.addStation(new Station("Торговая", stationIndex.getLine(2)));
        stationIndex.addStation(new Station("Кожевенная", stationIndex.getLine(2)));
        stationIndex.addStation(new Station("Охотская", stationIndex.getLine(2)));
        stationIndex.addStation(new Station("Рыбацкая", stationIndex.getLine(2)));
        stationIndex.addStation(new Station("Кузнечная", stationIndex.getLine(2)));

        stationIndex.getLine(3).addStation(new Station("Весёлая", stationIndex.getLine(3)));
        stationIndex.getLine(3).addStation(new Station("Грибная", stationIndex.getLine(3)));
        stationIndex.getLine(3).addStation(new Station("Грушёвая", stationIndex.getLine(3)));
        stationIndex.getLine(3).addStation(new Station("Персиковая", stationIndex.getLine(3)));
        stationIndex.getLine(3).addStation(new Station("Лесная", stationIndex.getLine(3)));

        stationIndex.addStation(new Station("Весёлая", stationIndex.getLine(3)));
        stationIndex.addStation(new Station("Грибная", stationIndex.getLine(3)));
        stationIndex.addStation(new Station("Грушёвая", stationIndex.getLine(3)));
        stationIndex.addStation(new Station("Персиковая", stationIndex.getLine(3)));
        stationIndex.addStation(new Station("Лесная", stationIndex.getLine(3)));

        List<Station> list = new ArrayList<>();
        list.add(stationIndex.getStation("Корабельная", 1));
        list.add(stationIndex.getStation("Кожевенная", 2));
        List<Station> list2 = new ArrayList<>();
        list2.add(stationIndex.getStation("Кожевенная", 2));
        list2.add(stationIndex.getStation("Корабельная", 1));
        List<Station> list3 = new ArrayList<>();
        list3.add(stationIndex.getStation("Рыбацкая", 2));
        list3.add(stationIndex.getStation("Персиковая", 3));
        List<Station> list4 = new ArrayList<>();
        list4.add(stationIndex.getStation("Персиковая", 3));
        list4.add(stationIndex.getStation("Рыбацкая", 2));

        stationIndex.addConnection(list);
        stationIndex.addConnection(list2);
        stationIndex.addConnection(list3);
        stationIndex.addConnection(list4);
    }

    public void testCalculateDuration() {
        route = new ArrayList<>();
        route.add(new Station("Петровская", stationIndex.getLine(1)));
        route.add(new Station("Корабельная", stationIndex.getLine(1)));
        route.add(new Station("Кожевенная", stationIndex.getLine(2)));
        route.add(new Station("Охотская", stationIndex.getLine(2)));
        route.add(new Station("Рыбацкая", stationIndex.getLine(2)));
        route.add(new Station("Персиковая", stationIndex.getLine(3)));
        route.add(new Station("Грушёвая", stationIndex.getLine(3)));
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 17;
        assertEquals(actual, expected);
    }

    public void testGetShortestRouteOnTheLine() {
        route = new ArrayList<>();
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        route.add(stationIndex.getStation("Петровская"));
        route.add(stationIndex.getStation("Корабельная"));
        route.add(stationIndex.getStation("Парусная"));
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Петровская"),stationIndex.getStation("Парусная"));
        List<Station> expected = route;
        assertEquals(actual, expected);
    }

    public void testGetShortestRouteWithOneConnection() {
        route = new ArrayList<>();
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        route.add(stationIndex.getStation("Петровская"));
        route.add(stationIndex.getStation("Корабельная"));
        route.add(stationIndex.getStation("Кожевенная"));
        route.add(stationIndex.getStation("Торговая"));
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Петровская"),stationIndex.getStation("Торговая"));
        List<Station> expected = route;
        assertEquals(actual, expected);
    }

    public void testGetShortestRouteWithTwoConnections() {
        route = new ArrayList<>();
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        route.add(stationIndex.getStation("Петровская"));
        route.add(stationIndex.getStation("Корабельная"));
        route.add(stationIndex.getStation("Кожевенная"));
        route.add(stationIndex.getStation("Охотская"));
        route.add(stationIndex.getStation("Рыбацкая"));
        route.add(stationIndex.getStation("Персиковая"));
        route.add(stationIndex.getStation("Грушёвая"));
        route.add(stationIndex.getStation("Грибная"));
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Петровская"),stationIndex.getStation("Грибная"));
        List<Station> expected = route;
        assertEquals(actual, expected);
    }

    @Override
    protected void tearDown() throws Exception {

    }
}
