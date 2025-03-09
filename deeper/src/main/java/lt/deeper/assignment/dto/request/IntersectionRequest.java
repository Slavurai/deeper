package lt.deeper.assignment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IntersectionRequest {
  private Square square;
  private Line line;
}