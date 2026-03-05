package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private String name;
    private List<Book> books;
    
    public Library(String name) {
    	this.name = name;
    	books = new ArrayList<Book>();
    }
    public String getName() {
        return name;
    }
    
    //도서 추가
    public void addBook(Book book) {
    	books.add(book);
    	System.out.println("도서가 추가되었습니다: " + book.getTitle());
    }
    
    //제목검색
    public Book findBookByTitle(String title) {
    	for (Book b : books) {
    		if (b.getTitle().equals(title)) {
    			return b;
    		}
    	}
    	return null;
    }
    
    //저자 검색
    public List<Book> findBooksByAuthor(String author){
    	List<Book> result = new ArrayList<Book>();
    	
    	for (Book b : books) {
    		if (b.getAuthor().equals(author)) {
    			result.add(b);
    		}
    	}
    	return result;
    }
    
    //ISBN 검색
    public Book findBookByISBN(String isbn) {
    	for (Book b : books) {
    		if (b.getIsbn().equals(isbn)) {
    			return b;
    		}
    	}
    	return null;
    }
    
    //도서 대출
    public boolean checkOutBook(String isbn) {
    	Book book = findBookByISBN(isbn);
    	
    	if (book != null) {
    		return book.checkOut();
    	}
    	return false;
    }
    
    //도서 반납
    public boolean returnBook(String isbn) {
    	Book book = findBookByISBN(isbn);
    	
    	if (book != null) {
    		book.returnBook();
    		return true;
    	}
    	return false;
    }
    
    //전체 도서 수
    public int getTotalBooks() {
    	return books.size();
    }
    
    //대출 중 도서 수
    public int getBorrowedBooksCount() {
    	return getTotalBooks() - getAvailableBooksCount();
    }
    
    //대출 가능 도서 수
    public int getAvailableBooksCount() {
    	int count = 0;
    	
    	for (Book b : books) {
    		if (b.isAvailable()) {
    			count++;
    		}
    	}
    	return count;
    }
    
    //대출 가능 도서 목록
    public List<Book> getAvailableBooks(){
    	List<Book> result = new ArrayList<Book>();
    	
    	for (Book b : books) {
    		if (b.isAvailable()) {
    			result.add(b);
    		}
    	}
    	return result;
    }
    
    //전체 도서 목록
    public List<Book> getAllBooks(){
    	return books;
    }
    

}
