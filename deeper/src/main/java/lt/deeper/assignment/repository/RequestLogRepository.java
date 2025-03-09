package lt.deeper.assignment.repository;

import lt.deeper.assignment.dao.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestLogRepository extends JpaRepository<RequestLog, Long> {
}
