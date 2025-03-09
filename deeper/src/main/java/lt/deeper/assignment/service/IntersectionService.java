package lt.deeper.assignment.service;

import lombok.RequiredArgsConstructor;
import lt.deeper.assignment.dto.request.Line;
import lt.deeper.assignment.dto.request.PointRequest;
import lt.deeper.assignment.dto.request.Square;
import lt.deeper.assignment.dto.response.IntersectionResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IntersectionService {

  private final RequestCounterService requestCounterService;

  /*
  No transactional annotation because the request should be saved no matter if it fails of not
   */
  public IntersectionResponse checkIntersection(Square square, Line line) {
    requestCounterService.logRequest();//saving the request
    List<PointRequest> intersections = new ArrayList<>();
    List<PointRequest> squareEdges = square.getEdges();

    // Square edges (pairs of PointRequests)
    Line[] squareLines = {
        new Line(squareEdges.get(0), squareEdges.get(1)),  // Top edge
        new Line(squareEdges.get(1), squareEdges.get(3)),  // Right edge
        new Line(squareEdges.get(3), squareEdges.get(2)),  // Bottom edge
        new Line(squareEdges.get(2), squareEdges.get(0))   // Left edge
    };

    for (Line edge : squareLines) {
      PointRequest intersection = getIntersection(line, edge);
      if (intersection != null) {
        intersections.add(intersection);
      }
    }

    return new IntersectionResponse(!intersections.isEmpty(), intersections);
  }

  private PointRequest getIntersection(Line line1, Line line2) {
    double x1 = line1.getStart().getX(), y1 = line1.getStart().getY();
    double x2 = line1.getEnd().getX(), y2 = line1.getEnd().getY();
    double x3 = line2.getStart().getX(), y3 = line2.getStart().getY();
    double x4 = line2.getEnd().getX(), y4 = line2.getEnd().getY();

    double denom = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
    if (denom == 0) return null; // Parallel lines

    double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / denom;
    double u = -((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3)) / denom;

    if (t >= 0 && t <= 1 && u >= 0 && u <= 1) {
      double x = x1 + t * (x2 - x1);
      double y = y1 + t * (y2 - y1);
      return new PointRequest(x, y);
    }
    return null; // No intersection
  }
}
