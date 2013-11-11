package nl.jworks.spring.data;

import nl.jworks.spring.data.book.Author;
import nl.jworks.spring.data.book.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ApplicationConfiguration.class);
        ctx.refresh();

        Application start = ctx.getBean(Application.class);
        start.start();
    }

    @Autowired
    private AuthorRepository authorRepository;

    private void start() {

        System.out.println("Found author: " + authorRepository.findByLastName("Pragt"));

        Author newAuthor = new Author("Erik", "Pragt");
        authorRepository.save(newAuthor);

        authorRepository.count();

        Author author = authorRepository.findByLastName("Pragt");
        System.out.println("Found author:");
        System.out.println(" id: " + author.getId());
        System.out.println(" firstname: " + author.getFirstName());
        System.out.println(" lastname: " + author.getLastName());
    }
}
