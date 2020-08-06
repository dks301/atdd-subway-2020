package wooteco.subway.maps.map.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class SubwayPath {
    private static final int BASIC_FARE = 1250;
    private static final int BASIC_DISTANCE = 10;

    private List<LineStationEdge> lineStationEdges;

    public SubwayPath(List<LineStationEdge> lineStationEdges) {
        this.lineStationEdges = lineStationEdges;
    }

    public List<LineStationEdge> getLineStationEdges() {
        return lineStationEdges;
    }

    public List<Long> extractStationId() {
        List<Long> stationIds = Lists.newArrayList(lineStationEdges.get(0).getLineStation().getPreStationId());
        stationIds.addAll(lineStationEdges.stream()
            .map(it -> it.getLineStation().getStationId())
            .collect(Collectors.toList()));

        return stationIds;
    }

    public int calculateDuration() {
        return lineStationEdges.stream().mapToInt(it -> it.getLineStation().getDuration()).sum();
    }

    public int calculateDistance() {
        return lineStationEdges.stream().mapToInt(it -> it.getLineStation().getDistance()).sum();
    }

    public int calculateFare() {
        final int distance = calculateDistance();

        return BASIC_FARE + calculateLineExtraFare() + calculateOverFare(distance - BASIC_DISTANCE);
    }

    private int calculateLineExtraFare() {
        int lineExtraFare = 0;

        for (final LineStationEdge lineStationEdge : lineStationEdges) {
            if (lineStationEdge.getLine().getExtraFare() > lineExtraFare) {
                lineExtraFare = lineStationEdge.getLine().getExtraFare();
            }
        }

        return lineExtraFare;
    }

    private int calculateOverFare(int overDistance) {
        if (overDistance <= 0) {
            return 0;
        }
        if (overDistance <= 40) {
            return (int)((Math.ceil((overDistance - 1) / 5) + 1) * 100);
        }
        return 800 + (int)((Math.ceil((overDistance - 41) / 8) + 1) * 100);
    }
}
