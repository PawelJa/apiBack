package pl.coderslab.apiback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pl.coderslab.apiback.model.Book;
import pl.coderslab.apiback.model.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@GetMapping("/test")
	public Book test() {
		return new Book(1L, "9788324631766", "Thinking	in	Java", "Bruce	Eckel", "Helion", "programming");
	}

	@Autowired
	BookService bookService;

	@GetMapping("")
	public List<Book> getList() {
		return this.bookService.getList();
	}

	@GetMapping("/{id}")
	public Book getById(@PathVariable long id) {
		return this.bookService.getById(id);
	}

	@PostMapping("")
	public Book addBook(@RequestBody Book book) {
		return this.bookService.add(book);
	}

	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable long id) {
		this.bookService.deleteById(id);

		return "{result: ok}";
	}

	@PutMapping("/{id}")
	public String putBook(@PathVariable long id, @RequestBody Book book) {
		this.bookService.edit(book);

		return "{result: ok}";
	}

}
