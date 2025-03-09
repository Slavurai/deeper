package lt.deeper.assignment.service;

import lombok.RequiredArgsConstructor;
import lt.deeper.assignment.dao.User;
import lt.deeper.assignment.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> userOptional = userRepository.findByUsername(username);

    if (userOptional.isEmpty()) {
      throw new UsernameNotFoundException("User not found");
    }

    User user = userOptional.get();

    return new org.springframework.security.core.userdetails.User(
        user.getUsername(),
        user.getPassword(),
        Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
    );
  }
}