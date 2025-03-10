package lt.deeper.assignment.controller;

import lombok.RequiredArgsConstructor;
import lt.deeper.assignment.service.RequestCounterService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
@RequiredArgsConstructor
public class RequestsInformationController {

  private final RequestCounterService requestCounterService;

  @GetMapping(value = "/requests/count", produces = MediaType.APPLICATION_JSON_VALUE)
  public Long getRequestsCount() {
    return requestCounterService.getRequestCount();
  }
}
