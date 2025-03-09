package lt.deeper.assignment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Square {
  private PointRequest topLeft;
  private double sideLength;

  public List<PointRequest> getEdges() {
    double x = topLeft.getX();
    double y = topLeft.getY();
    double s = sideLength;

    return List.of(
        topLeft,
        new PointRequest(x + s, y),         // Top-right
        new PointRequest(x, y - s),         // Bottom-left
        new PointRequest(x + s, y - s)      // Bottom-right
    );
  }
}