package com.example.Models.Review.Appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.Exceptions.BuildException;
import com.example.Exceptions.ServiceException;
import com.example.Models.Review.DTO.ReviewDTO;
import com.example.Models.Review.Mapper.ReviewMapper;
import com.example.Models.Review.Persistance.ReviewRepository;
import com.example.sharedkernel.appservices.serializers.Serializer;
import com.example.sharedkernel.appservices.serializers.Serializers;
import com.example.sharedkernel.appservices.serializers.SerializersCatalog;

@Controller
public class ReviewServicesImpl implements ReviewServices{

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
    
    
    protected ReviewDTO checkInputData(String review) throws ServiceException {
        try {
            ReviewDTO bdto = (ReviewDTO) this.serializer.deserialize(review, ReviewDTO.class);
            ReviewMapper.reviewFromDTO(bdto);
            return bdto;
        } catch (BuildException e) {
            throw new ServiceException("error in the input book data: " + e.getMessage());
        }
    }


    protected ReviewDTO newReview(String review) throws ServiceException {
        ReviewDTO bdto = this.checkInputData(review);
          
        if (this.getDTO(bdto.getReviewId()) == null) {
            return reviewRepository.save(bdto);
        } 
        throw new ServiceException("review " + bdto.getReviewId() + " already exists");
    }


    protected ReviewDTO updateReview(String review) throws ServiceException {
        try {
            ReviewDTO bdto = this.checkInputData(review);
            this.getById(bdto.getReviewId());
            return reviewRepository.save(bdto);
        } catch (ServiceException e) {
            throw e;
        }
    }



    // ****** Implementing the interface methods ******

    @Override
    public String getByIdToJson(int id) throws ServiceException {
        return SerializersCatalog.getInstance(Serializers.REVIEW_JSON)
                .serialize(this.getById(id));
    }

    
    @Override
    public String addFromJson(String review) throws ServiceException {
        this.serializer = SerializersCatalog.getInstance(Serializers.REVIEW_JSON);
        return serializer.serialize(this.newReview(review));
    }

    @Override
    public String updateOneFromJson(String review) throws ServiceException {
        this.serializer = SerializersCatalog.getInstance(Serializers.REVIEW_JSON);
        return serializer.serialize(this.updateReview(review));
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
