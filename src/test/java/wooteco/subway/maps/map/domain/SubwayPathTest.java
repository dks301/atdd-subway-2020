package wooteco.subway.maps.map.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

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
    private List<LineStationEdge> lineStations;

    @BeforeEach
    void setUp() {
        Line line3 = TestObjectUtils.createLine(3L, "3호선", "ORANGE");
        line3.addLineStation(new LineStation(1L, null, 0, 0));
        LineStation lineStation6 = new LineStation(4L, 1L, 1, 2);
        LineStation lineStation7 = new LineStation(3L, 4L, 2, 2);
        line3.addLineStation(lineStation6);
        line3.addLineStation(lineStation7);

        lineStations = Lists.newArrayList(
            new LineStationEdge(lineStation6, line3.getId(), line3),
            new LineStationEdge(lineStation7, line3.getId(), line3)
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

    @DisplayName("calculateFare가 거리가 3km일 때 기본 요금인 1250을 반환한다.")
    @Test
    void calculateFare() {
        assertThat(subwayPath.calculateFare()).isEqualTo(1250);
    }

    @DisplayName("거리가 11km일 때 1350원을 반환한다.")
    @Test
    void calculateFare2() {
        Line line3 = TestObjectUtils.createLine(3L, "3호선", "ORANGE");
        line3.addLineStation(new LineStation(1L, null, 0, 0));
        LineStation lineStation6 = new LineStation(4L, 1L, 1, 2);
        LineStation lineStation7 = new LineStation(3L, 4L, 10, 2);
        line3.addLineStation(lineStation6);
        line3.addLineStation(lineStation7);

        lineStations = Lists.newArrayList(
            new LineStationEdge(lineStation6, line3.getId(), line3),
            new LineStationEdge(lineStation7, line3.getId(), line3)
        );

        subwayPath = new SubwayPath(lineStations);
        assertThat(subwayPath.calculateFare()).isEqualTo(1350);
    }

    @DisplayName("거리가 15km일 때 1350원을 반환한다.")
    @Test
    void calculateFare3() {
        Line line3 = TestObjectUtils.createLine(3L, "3호선", "ORANGE");
        line3.addLineStation(new LineStation(1L, null, 0, 0));
        LineStation lineStation6 = new LineStation(4L, 1L, 5, 2);
        LineStation lineStation7 = new LineStation(3L, 4L, 10, 2);
        line3.addLineStation(lineStation6);
        line3.addLineStation(lineStation7);

        lineStations = Lists.newArrayList(
            new LineStationEdge(lineStation6, line3.getId(), line3),
            new LineStationEdge(lineStation7, line3.getId(), line3)
        );

        subwayPath = new SubwayPath(lineStations);
        assertThat(subwayPath.calculateFare()).isEqualTo(1350);
    }

    @DisplayName("거리가 50km일 때 2050원을 반환한다.")
    @Test
    void calculateFare4() {
        Line line3 = TestObjectUtils.createLine(3L, "3호선", "ORANGE");
        line3.addLineStation(new LineStation(1L, null, 0, 0));
        LineStation lineStation6 = new LineStation(4L, 1L, 25, 2);
        LineStation lineStation7 = new LineStation(3L, 4L, 25, 2);
        line3.addLineStation(lineStation6);
        line3.addLineStation(lineStation7);

        lineStations = Lists.newArrayList(
            new LineStationEdge(lineStation6, line3.getId(), line3),
            new LineStationEdge(lineStation7, line3.getId(), line3)
        );

        subwayPath = new SubwayPath(lineStations);
        assertThat(subwayPath.calculateFare()).isEqualTo(2050);
    }

    @DisplayName("거리가 51km일 때 2150원을 반환한다.")
    @Test
    void calculateFare5() {
        Line line3 = TestObjectUtils.createLine(3L, "3호선", "ORANGE");
        line3.addLineStation(new LineStation(1L, null, 0, 0));
        LineStation lineStation6 = new LineStation(4L, 1L, 26, 2);
        LineStation lineStation7 = new LineStation(3L, 4L, 25, 2);
        line3.addLineStation(lineStation6);
        line3.addLineStation(lineStation7);

        lineStations = Lists.newArrayList(
            new LineStationEdge(lineStation6, line3.getId(), line3),
            new LineStationEdge(lineStation7, line3.getId(), line3)
        );

        subwayPath = new SubwayPath(lineStations);
        assertThat(subwayPath.calculateFare()).isEqualTo(2150);
    }

    @DisplayName("거리가 59km일 때 2250원을 반환한다.")
    @Test
    void calculateFare6() {
        Line line3 = TestObjectUtils.createLine(3L, "3호선", "ORANGE");
        line3.addLineStation(new LineStation(1L, null, 0, 0));
        LineStation lineStation6 = new LineStation(4L, 1L, 29, 2);
        LineStation lineStation7 = new LineStation(3L, 4L, 30, 2);
        line3.addLineStation(lineStation6);
        line3.addLineStation(lineStation7);

        lineStations = Lists.newArrayList(
            new LineStationEdge(lineStation6, line3.getId(), line3),
            new LineStationEdge(lineStation7, line3.getId(), line3)
        );

        subwayPath = new SubwayPath(lineStations);
        assertThat(subwayPath.calculateFare()).isEqualTo(2250);
    }

    @DisplayName("거리가 10km이고 노선 추가요금이 500원일 때 1750원을 반환한다.")
    @Test
    void calculateFare7() {
        Line line3 = TestObjectUtils.createLineWithExtraFare(3L, "3호선", "ORANGE", 500);
        line3.addLineStation(new LineStation(1L, null, 0, 0));
        LineStation lineStation6 = new LineStation(4L, 1L, 5, 2);
        LineStation lineStation7 = new LineStation(3L, 4L, 5, 2);
        line3.addLineStation(lineStation6);
        line3.addLineStation(lineStation7);

        lineStations = Lists.newArrayList(
            new LineStationEdge(lineStation6, line3.getId(), line3),
            new LineStationEdge(lineStation7, line3.getId(), line3)
        );

        subwayPath = new SubwayPath(lineStations);
        assertThat(subwayPath.calculateFare()).isEqualTo(1750);
    }

    @DisplayName("거리가 50km이고 노선 추가요금이 1호선은 0원, 2호선은 300원, 3호선은 500원일 때 2550원을 반환한다.")
    @Test
    void calculateFare8() {
        Line line3 = TestObjectUtils.createLineWithExtraFare(3L, "3호선", "ORANGE", 500);
        line3.addLineStation(new LineStation(1L, null, 0, 0));
        LineStation lineStation6 = new LineStation(4L, 1L, 10, 2);
        LineStation lineStation7 = new LineStation(3L, 4L, 10, 2);
        line3.addLineStation(lineStation6);
        line3.addLineStation(lineStation7);

        Line line1 = TestObjectUtils.createLine(1L, "1호선", "BLUE");
        LineStation lineStation1 = new LineStation(5L, 4L, 5, 2);
        LineStation lineStation2 = new LineStation(6L, 5L, 5, 2);
        line1.addLineStation(lineStation1);
        line1.addLineStation(lineStation2);

        Line line2 = TestObjectUtils.createLineWithExtraFare(2L, "2호선", "GREEN", 300);
        LineStation lineStation3 = new LineStation(7L, 6L, 10, 2);
        LineStation lineStation4 = new LineStation(8L, 7L, 10, 2);
        line3.addLineStation(lineStation3);
        line3.addLineStation(lineStation4);

        lineStations = Lists.newArrayList(
            new LineStationEdge(lineStation6, line3.getId(), line3),
            new LineStationEdge(lineStation7, line3.getId(), line3),
            new LineStationEdge(lineStation1, line1.getId(), line1),
            new LineStationEdge(lineStation2, line1.getId(), line1),
            new LineStationEdge(lineStation3, line2.getId(), line2),
            new LineStationEdge(lineStation4, line2.getId(), line2)
        );

        subwayPath = new SubwayPath(lineStations);
        assertThat(subwayPath.calculateFare()).isEqualTo(2550);
    }
}
