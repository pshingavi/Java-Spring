package com.pshingavi.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.pshingavi.spring.dao.OffersDAO;
import com.pshingavi.spring.model.Offer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        OffersDAO offersDAO = ctx.getBean("offersDAO", OffersDAO.class);
        try {
        	List<Offer> allOffers = offersDAO.getOffers();
        	for(Offer offer : allOffers) {
	        	System.out.println(offer);
	        }
        	//System.out.println(offersDAO.deleteById(1));
        	Offer offer1 = new Offer(4, "test1_update", "test1_update@test.com", "test1_update text");
        	System.out.println(offersDAO.update(offer1));
        	allOffers = offersDAO.getOffers();
        	for(Offer offer : allOffers) {
	        	System.out.println(offer);
	        }
		} catch (DataAccessException e) {	// Any DB related exceptions are thrown into DataAccessException parent exception class
			System.out.println(e.getMessage());
			System.out.println(e.getClass());	// Exact class of exception
		}
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
