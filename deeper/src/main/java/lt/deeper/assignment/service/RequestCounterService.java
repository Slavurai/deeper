package lt.deeper.assignment.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lt.deeper.assignment.dao.RequestLog;
import lt.deeper.assignment.repository.RequestLogRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestCounterService {

  private final RequestLogRepository requestLogRepository;

  @Transactional
  public void logRequest() {
    requestLogRepository.save(new RequestLog());
  }

  public long getRequestCount() {
    return requestLogRepository.count();
  }
}

