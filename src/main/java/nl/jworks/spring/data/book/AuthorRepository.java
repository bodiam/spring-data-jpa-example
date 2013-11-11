package nl.jworks.spring.data.book;


import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByLastName(String lastName);
}
