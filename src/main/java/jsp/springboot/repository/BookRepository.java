package jsp.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jsp.springboot.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{
	
	//Using Standard Naming Convention
	List<Book> findByAuthor(String author);
	List<Book> findByAuthorAndTitle(String author,String title);
	List<Book> findByPriceLessThan(Double price);
	List<Book> findByPriceBetween(Double sprice,Double eprice);
	
	//Using Query
	@Query("select b from Book b where b.availability=true")
	List<Book> getBookByAvailability();
	
	@Query("select b from Book b where b.publishedYear=?1")
	List<Book> getBookByPublishedYear(Integer year);
	
	@Query("select b from Book b where b.genre=:genre")
	List<Book> getBookByGenre(String genre);
	
	
}
