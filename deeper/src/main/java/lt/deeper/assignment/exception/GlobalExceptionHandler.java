package lt.deeper.assignment.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  private static final String MESSAGE_INTERNAL_SERVER_ERROR = "Internal server error";

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(NullPointerException ex) {
    return new ResponseEntity<>(MESSAGE_INTERNAL_SERVER_ERROR + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
    BindingResult bindingResult = ex.getBindingResult();

    Map<String, String> errors = new HashMap<>();
    bindingResult.getFieldErrors().forEach(error ->
        errors.put(error.getField(), error.getDefaultMessage())
    );

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }
}