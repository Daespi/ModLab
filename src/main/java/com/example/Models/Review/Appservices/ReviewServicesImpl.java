package com.example.Models.Review.Appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.Review.DTO.ReviewDTO;
import com.example.Models.Review.Mapper.ReviewMapper;
import com.example.Models.Review.Persistance.ReviewRepository;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

@Controller
public class ReviewServicesImpl {

    @Autowired
    private ReviewRepository reviewRepository;
    private Serializer<ReviewDTO> serializer;

    // ****** Implementing the business logic methods and common featues (clean code design) ******

    protected ReviewDTO getDTO(int id)  {
        return reviewRepository.findById(id).orElse(null );
    }


    protected ReviewDTO getById(int id) throws ServiceException {
        ReviewDTO bdto = this.getDTO(id);

        if ( bdto == null ) {
            throw new ServiceException("review " + id + " not found");
        }
        return bdto;
    }
    
    
    protected ReviewDTO checkInputData(String book) throws ServiceException {
        try {
            ReviewDTO bdto = (ReviewDTO) this.serializer.deserialize(book, ReviewDTO.class);
            ReviewMapper.reviewFromDTO(bdto);
            return bdto;
        } catch (BuildException e) {
            throw new ServiceException("error in the input book data: " + e.getMessage());
        }
    }


    protected ReviewDTO newBook(String book) throws ServiceException {
        ReviewDTO bdto = this.checkInputData(book);
          
        if (this.getDTO(bdto.getId()) == null) {
            return reviewRepository.save(bdto);
        } 
        throw new ServiceException("book " + bdto.getId() + " already exists");
    }


    protected ReviewDTO updateBook(String book) throws ServiceException {
        try {
            ReviewDTO bdto = this.checkInputData(book);
            this.getById(bdto.getId());
            return reviewRepository.save(bdto);
        } catch (ServiceException e) {
            throw e;
        }
    }



    // ****** Implementing the interface methods ******

    @Override
    public String getByIdToJson(int id) throws ServiceException {
        return SerializersCatalog.getInstance(Serializers.BOOK_JSON)
                .serialize(this.getById(id));
    }

    
    @Override
    public String addFromJson(String book) throws ServiceException {
        this.serializer = SerializersCatalog.getInstance(Serializers.BOOK_JSON);
        return serializer.serialize(this.newBook(book));
    }

    @Override
    public String updateOneFromJson(String book) throws ServiceException {
        this.serializer = SerializersCatalog.getInstance(Serializers.BOOK_JSON);
        return serializer.serialize(this.updateBook(book));
    }

    @Override
    public void deleteById(int id) throws ServiceException {
        try {
            this.getById(id);
            reviewRepository.deleteById(id);
        } catch (ServiceException e) {
            throw e;
        }
    }
}
