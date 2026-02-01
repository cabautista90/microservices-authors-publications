@Entity
@Table(name = "authors")
public class Author extends AuthorBase {

    @Column(nullable = false)
    private String biography;
}
