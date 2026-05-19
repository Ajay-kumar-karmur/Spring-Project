package jsp.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Book;
import jsp.springboot.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    // Save Single Book
    @PostMapping
    public ResponseEntity<ResponseStructure<Book>> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    // Save Multiple Books
    @PostMapping("/all")
    public ResponseEntity<ResponseStructure<List<Book>>> saveAllBooks(@RequestBody List<Book> books) {
        return new ResponseEntity<>(bookService.saveAllBooks(books), HttpStatus.CREATED);
    }

    // Get All Books
    @GetMapping
    public ResponseEntity<ResponseStructure<List<Book>>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    // Get Book By ID
    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Book>> getBookById(@PathVariable Integer id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    // Update Book
    @PutMapping
    public ResponseEntity<ResponseStructure<Book>> updateBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);
    }

    // Delete Book
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteBook(@PathVariable Integer id) {
        return new ResponseEntity<>(bookService.deleteBook(id), HttpStatus.OK);
    }

    // Find by Author
    @GetMapping("/author/{author}")
    public ResponseEntity<ResponseStructure<List<Book>>> getByAuthor(@PathVariable String author) {
        return new ResponseEntity<>(bookService.getByAuthor(author), HttpStatus.OK);
    }

    // Find by Author and Title
    @GetMapping("/author/{author}/{title}")
    public ResponseEntity<ResponseStructure<List<Book>>> getByAuthorAndTitle(
            @PathVariable String author,
            @PathVariable String title) {

        return new ResponseEntity<>(
                bookService.getByAuthorAndTitle(author, title),
                HttpStatus.OK
        );
    }

    // Find by Price Less Than
    @GetMapping("/price/{price}")
    public ResponseEntity<ResponseStructure<List<Book>>> getByPriceLessThan(@PathVariable Double price) {
        return new ResponseEntity<>(bookService.getByPriceLessThan(price), HttpStatus.OK);
    }

    // Find by Price Between
    @GetMapping("/price/{sprice}/{eprice}")
    public ResponseEntity<ResponseStructure<List<Book>>> getByPriceBetween(
            @PathVariable Double sprice,
            @PathVariable Double eprice) {

        return new ResponseEntity<>(
                bookService.getByPriceBetween(sprice, eprice),
                HttpStatus.OK
        );
    }
    
    //Get Book By Published Year
    @GetMapping("year/{year}")
    public ResponseEntity<ResponseStructure<List<Book>>> getBookByPublishedYear(@PathVariable Integer year){
    	return new ResponseEntity<ResponseStructure<List<Book>>>(bookService.getByPublishedYear(year),HttpStatus.OK);
    }
    
    //Get Book By Genre
    @GetMapping("genre/{genre}")
    public ResponseEntity<ResponseStructure<List<Book>>> getBookByGenre(@PathVariable String genre){
    	return new ResponseEntity<ResponseStructure<List<Book>>>(bookService.getBookByGenre(genre),HttpStatus.OK);
    }
    
    @GetMapping("/{pageNumber}/{pageSize}")
    public ResponseEntity<ResponseStructure<Page<Book>>> getBookByPage(@PathVariable Integer pageNumber,@PathVariable Integer pageSize){
    	return new ResponseEntity<ResponseStructure<Page<Book>>>(bookService.getBookByPagination(pageNumber, pageSize),HttpStatus.OK);
    }
    @GetMapping("/sort/{fieldName}")
    public ResponseEntity<ResponseStructure<List<Book>>> getBookBySort(@PathVariable String fieldName){
    	return new ResponseEntity<ResponseStructure<List<Book>>>(bookService.getBookBySorting(fieldName),HttpStatus.OK);
    }
}