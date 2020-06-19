package app.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Book {

  @Id
  // to enable Postgres sequence
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "b_id")
  private int id;

  @Column(name = "b_name")
  private String name;

  /**
   * @ManyToMany
   * that's not a column
   * that's a field to keep a relation on Java (Hibernate) level
   *
   * because of absence `mappedBy` property
   * we create dedicated table `book_authors`
   * to maintain unidirectional relation
   */
  @ManyToMany
  private List<Author> authors;
}
