package lt.deeper.assignment.helper;

import lt.deeper.assignment.dao.User;
import lt.deeper.assignment.dao.enums.ApplicationRoleEnum;
import lt.deeper.assignment.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void run(String... args) {
    if (!userRepository.existsByUsername("admin")) {
      User admin = new User();
      admin.setUsername("admin");
      admin.setRole(ApplicationRoleEnum.ADMIN);
      admin.setPassword(passwordEncoder.encode("admin123")); // Hash password
      userRepository.save(admin);
    }

    if (!userRepository.existsByUsername("user")) {
      User user = new User();
      user.setRole(ApplicationRoleEnum.USER);
      user.setUsername("user");
      user.setPassword(passwordEncoder.encode("user123"));
      userRepository.save(user);
    }
  }
}
