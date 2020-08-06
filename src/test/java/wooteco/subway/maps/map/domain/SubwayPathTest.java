package wooteco.subway.maps.map.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Lists;
import wooteco.subway.common.TestObjectUtils;
import wooteco.subway.maps.line.domain.Line;
import wooteco.subway.maps.line.domain.LineStation;

class SubwayPathTest {
    private SubwayPath subwayPath;

    @BeforeEach
    void setUp() {
        Line line3 = TestObjectUtils.createLine(3L, "3호선", "ORANGE");
        line3.addLineStation(new LineStation(1L, null, 0, 0));
        LineStation lineStation6 = new LineStation(4L, 1L, 1, 2);
        LineStation lineStation7 = new LineStation(3L, 4L, 2, 2);
        line3.addLineStation(lineStation6);
        line3.addLineStation(lineStation7);

        List<LineStationEdge> lineStations = Lists.newArrayList(
            new LineStationEdge(lineStation6, line3.getId()),
            new LineStationEdge(lineStation7, line3.getId())
        );
        subwayPath = new SubwayPath(lineStations);
    }

    @DisplayName("getLineStationEdges가 2개의 LineStateEdge를 반환한다.")
    @Test
    void getLineStationEdges() {
        assertThat(subwayPath.getLineStationEdges().size()).isEqualTo(2);
    }

    @DisplayName("extractStationId가 1L->4L->3L인 리스트를 반환한다.")
    @Test
    void extractStationId() {
        assertThat(subwayPath.extractStationId()).isEqualTo(Arrays.asList(1L, 4L, 3L));
    }

    @DisplayName("calculateDuration이 총 소요시간인 4를 반환한다.")
    @Test
    void calculateDuration() {
        assertThat(subwayPath.calculateDuration()).isEqualTo(4);
    }

    @DisplayName("calcaulateDistance가 총 거리인 3을 반환한다.")
    @Test
    void calculateDistance() {
        assertThat(subwayPath.calculateDistance()).isEqualTo(3);
    }

    @DisplayName("calculateFare가 기본 요금인 1250을 반환한다.")
    @Test
    void calculateFare() {
        assertThat(subwayPath.calculateFare()).isEqualTo(1250);
    }
}
