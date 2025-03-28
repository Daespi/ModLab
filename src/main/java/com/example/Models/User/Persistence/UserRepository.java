package com.example.softlearning.applicationcore.entity.book.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.softlearning.applicationcore.entity.book.dtos.BookDTO;
import com.example.softlearning.applicationcore.entity.book.appservices.BookServicesImpl;


@Repository
public interface UserRepository  {

    public Optional<BookDTO> findById(String isbn);

    public List<BookDTO> findByName(String title);
 
    public List<BookDTO> findByPartialTitle(String title);

    public Integer countByPartialTitle(String title);

    public BookDTO save(BookDTO book);
    
    public void deleteById(String isbn);
    
}

