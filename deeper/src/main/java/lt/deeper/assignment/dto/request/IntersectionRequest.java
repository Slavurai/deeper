package lt.deeper.assignment.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IntersectionRequest {
  @NotNull
  private Square square;
  @NotNull
  private Line line;
}