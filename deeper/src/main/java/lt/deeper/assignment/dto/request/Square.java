package lt.deeper.assignment.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Square {
  @NotNull
  private PointRequest topLeft;
  private double sideLength;

  public List<PointRequest> getEdges() {
    double x = topLeft.getX();
    double y = topLeft.getY();
    double s = sideLength;

    return List.of(
        topLeft,
        new PointRequest(x + s, y),
        new PointRequest(x, y - s),
        new PointRequest(x + s, y - s)
    );
  }
}