package jsp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jsp.springboot.dto.ResponseStructure;
import jsp.springboot.entity.Book;
import jsp.springboot.exception.IdNotFoundException;
import jsp.springboot.exception.NoRecordAvailable;
import jsp.springboot.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Save Single
    public ResponseStructure<Book> saveBook(Book book) {
        ResponseStructure<Book> res = new ResponseStructure<>();
        res.setMessage("Book Record Saved");
        res.setStatusCode(HttpStatus.CREATED.value());
        res.setData(bookRepository.save(book));
        return res;
    }

    // Save Multiple
    public ResponseStructure<List<Book>> saveAllBooks(List<Book> books) {
        ResponseStructure<List<Book>> res = new ResponseStructure<>();
        res.setMessage("Multiple Records Saved");
        res.setStatusCode(HttpStatus.CREATED.value());
        res.setData(bookRepository.saveAll(books));
        return res;
    }

    // Get All
    public ResponseStructure<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) {
            throw new NoRecordAvailable("No Data Available");
        }

        ResponseStructure<List<Book>> res = new ResponseStructure<>();
        res.setMessage("All Data Fetched");
        res.setStatusCode(HttpStatus.OK.value());
        res.setData(books);
        return res;
    }

    // Get By ID
    public ResponseStructure<Book> getBookById(Integer id) {
        Optional<Book> opt = bookRepository.findById(id);

        if (opt.isPresent()) {
            ResponseStructure<Book> res = new ResponseStructure<>();
            res.setMessage("Record Fetched Successfully");
            res.setStatusCode(HttpStatus.OK.value());
            res.setData(opt.get());
            return res;
        } else {
            throw new IdNotFoundException("Id Not Found");
        }
    }

    // Update
    public ResponseStructure<Book> updateBook(Book book) {
        if (book.getId() == null) {
            throw new IdNotFoundException("Id Not Found");
        }

        Optional<Book> opt = bookRepository.findById(book.getId());

        if (opt.isPresent()) {
            ResponseStructure<Book> res = new ResponseStructure<>();
            res.setMessage("Data Updated Successfully");
            res.setStatusCode(HttpStatus.OK.value());
            res.setData(bookRepository.save(book));
            return res;
        } else {
            throw new IdNotFoundException("Id Not Found");
        }
    }

    // Delete
    public ResponseStructure<String> deleteBook(Integer id) {
        Optional<Book> opt = bookRepository.findById(id);

        if (opt.isPresent()) {
            bookRepository.delete(opt.get());

            ResponseStructure<String> res = new ResponseStructure<>();
            res.setMessage("Data Deleted Successfully");
            res.setStatusCode(HttpStatus.OK.value());
            res.setData("Deleted");
            return res;
        } else {
            throw new IdNotFoundException("Id Not Found");
        }
    }

    // Find by Author
    public ResponseStructure<List<Book>> getByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthor(author);

        if (books.isEmpty()) {
            throw new NoRecordAvailable("No Record Available");
        }

        ResponseStructure<List<Book>> res = new ResponseStructure<>();
        res.setMessage("Data Fetched Successfully");
        res.setStatusCode(HttpStatus.OK.value());
        res.setData(books);
        return res;
    }

    // Find by Author & Title
    public ResponseStructure<List<Book>> getByAuthorAndTitle(String author, String title) {
        List<Book> books = bookRepository.findByAuthorAndTitle(author, title);

        if (books.isEmpty()) {
            throw new NoRecordAvailable("No Record Available");
        }

        ResponseStructure<List<Book>> res = new ResponseStructure<>();
        res.setMessage("Data Fetched Successfully");
        res.setStatusCode(HttpStatus.OK.value());
        res.setData(books);
        return res;
    }

    // Price less than
    public ResponseStructure<List<Book>> getByPriceLessThan(Double price) {
        List<Book> books = bookRepository.findByPriceLessThan(price);

        if (books.isEmpty()) {
            throw new NoRecordAvailable("No Record Available");
        }

        ResponseStructure<List<Book>> res = new ResponseStructure<>();
        res.setMessage("Data Fetched Successfully");
        res.setStatusCode(HttpStatus.OK.value());
        res.setData(books);
        return res;
    }

    // Price between
    public ResponseStructure<List<Book>> getByPriceBetween(Double sprice, Double eprice) {
        List<Book> books = bookRepository.findByPriceBetween(sprice, eprice);

        if (books.isEmpty()) {
            throw new NoRecordAvailable("No Record Available");
        }

        ResponseStructure<List<Book>> res = new ResponseStructure<>();
        res.setMessage("Data Fetched Successfully");
        res.setStatusCode(HttpStatus.OK.value());
        res.setData(books);
        return res;
    }
    
    //Get Book By Published Year
    public ResponseStructure<List<Book>> getByPublishedYear(Integer year){
    	List<Book> books = bookRepository.getBookByPublishedYear(year);

        if (books.isEmpty()) {
            throw new NoRecordAvailable("No Record Available");
        }

        ResponseStructure<List<Book>> res = new ResponseStructure<>();
        res.setMessage("Data Fetched Successfully");
        res.setStatusCode(HttpStatus.OK.value());
        res.setData(books);
        return res;
    }
    
    
    //Get Book By Genre
    public ResponseStructure<List<Book>> getBookByGenre(String genre){
    	List<Book> books = bookRepository.getBookByGenre(genre);

        if (books.isEmpty()) {
            throw new NoRecordAvailable("No Record Available");
        }

        ResponseStructure<List<Book>> res = new ResponseStructure<>();
        res.setMessage("Data Fetched Successfully");
        res.setStatusCode(HttpStatus.OK.value());
        res.setData(books);
        return res;
    }
    
 //Pagination
    public ResponseStructure<Page<Book>> getBookByPagination(int pageNumber,int pageSize){
    	Page<Book> pages=bookRepository.findAll(PageRequest.of(pageNumber, pageSize));
    	if(!pages.isEmpty()) {
    		ResponseStructure<Page<Book>> res=new ResponseStructure<Page<Book>>();
    		res.setData(pages);
    		res.setMessage("Data Fetched");
    		res.setStatusCode(HttpStatus.OK.value());
    		return res;
    	}else {
    		throw new NoRecordAvailable("Record Not Available");
    	}
    }
    public ResponseStructure<List<Book>> getBookBySorting(String FieldName){
    	List<Book> books=bookRepository.findAll(Sort.by(FieldName).ascending());
    	if(!books.isEmpty()) {
    		ResponseStructure<List<Book>> res=new ResponseStructure<List<Book>>();
    		res.setData(books);
    		res.setMessage("Data Fetched");
    		res.setStatusCode(HttpStatus.OK.value());
    		return res;
    	}else {
    		throw new NoRecordAvailable("Record Not Available");
    	}
    }
}