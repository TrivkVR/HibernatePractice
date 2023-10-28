package hibertut;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.Author;
import entity.Book;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Logger logger = LoggerFactory.getLogger(Application.class);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(Author.class);
		logger.info("Created Configuration Con");
		SessionFactory sf = con.buildSessionFactory();
		logger.info("Created SessionFactory");
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Author author = new Author(1,"Padmaja",null);
		Book rangaBook = new Book("57567t686",null,"Ranga is a bad Boy");
		Book vikiBook = new Book("fqef67t686",null,"Viki is a good Boy");
		Set<Book> pBooks = new HashSet();
		pBooks.add(vikiBook);
		pBooks.add(rangaBook);
		author.setBooks(pBooks);
		session.persist(author);
		session.persist(vikiBook);
		session.persist(rangaBook);
		tx.commit();

	}

}
