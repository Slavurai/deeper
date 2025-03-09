package lt.deeper.assignment.controller;

import lombok.RequiredArgsConstructor;
import lt.deeper.assignment.dto.request.IntersectionRequest;
import lt.deeper.assignment.dto.response.IntersectionResponse;
import lt.deeper.assignment.service.IntersectionService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/public")
@RequiredArgsConstructor
public class IntersectionController {

  private final IntersectionService intersectionService;


  @PostMapping(value = "/intersections", produces = MediaType.APPLICATION_JSON_VALUE)
  public IntersectionResponse checkIntersection(@RequestBody IntersectionRequest request) {
    return intersectionService.checkIntersection(request.getSquare(), request.getLine());
  }
}
