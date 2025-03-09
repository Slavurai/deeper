package lt.deeper.assignment.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lt.deeper.assignment.dao.enums.ApplicationRoleEnum;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(unique = true, nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column
  @Enumerated(EnumType.STRING)
  private ApplicationRoleEnum role;
}
