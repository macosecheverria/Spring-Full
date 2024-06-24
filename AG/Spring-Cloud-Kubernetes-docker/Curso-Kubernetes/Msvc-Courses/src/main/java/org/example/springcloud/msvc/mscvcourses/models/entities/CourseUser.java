package org.example.springcloud.msvc.mscvcourses.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "courses_users")
public class CourseUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id", unique = true)
  private Long userId;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof CourseUser)) {
      return false;
    }

    CourseUser obj = (CourseUser) o;

    return this.userId != null && this.userId.equals(obj.getUserId());
  }

}
