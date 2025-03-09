package lt.deeper.assignment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.deeper.assignment.dto.request.PointRequest;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IntersectionResponse {
  private boolean intersects;
  private List<PointRequest> intersectionPoints;
}