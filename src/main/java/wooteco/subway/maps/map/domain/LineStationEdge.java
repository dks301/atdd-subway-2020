package wooteco.subway.maps.map.domain;

import wooteco.subway.maps.line.domain.Line;
import wooteco.subway.maps.line.domain.LineStation;
import org.jgrapht.graph.DefaultWeightedEdge;

public class LineStationEdge extends DefaultWeightedEdge {
    private LineStation lineStation;
    private Long lineId;
    private Line line;

    public LineStationEdge(LineStation lineStation, Long lineId) {
        this.lineStation = lineStation;
        this.lineId = lineId;
    }

    public LineStationEdge(final LineStation lineStation, final Long lineId, final Line line) {
        this.lineStation = lineStation;
        this.lineId = lineId;
        this.line = line;
    }

    public LineStation getLineStation() {
        return lineStation;
    }

    public Long getLineId() {
        return lineId;
    }

    public Line getLine() {
        return line;
    }

    @Override
    protected Object getSource() {
        return this.lineStation.getPreStationId();
    }

    @Override
    protected Object getTarget() {
        return this.lineStation.getStationId();
    }

    public Long extractTargetStationId(Long preStationId) {
        if (lineStation.getStationId().equals(preStationId)) {
            return lineStation.getPreStationId();
        } else if (lineStation.getPreStationId().equals(preStationId)) {
            return lineStation.getStationId();
        } else {
            throw new RuntimeException();
        }
    }
}
