/* COPYRIGHT (C) 2013 Puncak Tegap Sdn Bhd. All Rights Reserved. */

package com.ptsb.tutorial.tutorialjsf.web.form;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import com.ptsb.tutorial.tutorialjsf.domain.Car;
import javax.faces.application.FacesMessage;
import java.io.Serializable;


/**
 * @author Nicholas
 */
@SuppressWarnings("serial")
@ManagedBean(name="BorangKereta")
@SessionScoped
//@ViewScoped
public class CarForm implements Serializable{

    // ================================================================================
    // Instance variables
    // ================================================================================
    //private Car car;
    private Car car = new Car();//new object
    private List<Car> cars;//list

    //testtttttt
   
    //hsahshahsa
    // ================================================================================
    // Methods
    // ================================================================================

    /**
     * This method will be trigger upon page view
     */
    @PostConstruct
    public void initForm() {
        // TODO: initialize necessary instance variable
    	storeToSession(cars);
    }

    /**
     * This method is to store cars to session.
     * 
     * @param cars
     */
    private void storeToSession(final List<Car> cars) {
        final FacesContext facesContext = FacesContext.getCurrentInstance();
        final ExternalContext externalContext = facesContext.getExternalContext();

        externalContext.getSessionMap().put("carList", cars);
    }

    /**
     * This method is to retreive back the cars from session.
     * 
     * @return cars
     */
    @SuppressWarnings("unchecked")
    private List<Car> getFromSession() {
        final FacesContext facesContext = FacesContext.getCurrentInstance();
        final ExternalContext externalContext = facesContext.getExternalContext();

        return (List<Car>) externalContext.getSessionMap().get("carList");
    }

    // ================================================================================
    // Getters and Setters
    // ================================================================================
    public Car getCar() {
        return car;
    }

    public void setCar(final Car car) {
        this.car = car;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(final List<Car> cars) {
        this.cars = cars;
    }
    
    public void saveCar() {
    
        
    	FacesContext.getCurrentInstance().addMessage("sticky-key", 
    			new FacesMessage (FacesMessage.SEVERITY_INFO, "Sticky Message", "Saved successfully"));
        
    }
    
    public void submit()
    {
    	getFromSession();
    	saveCar();
    	if(cars == null)
    	{
    		cars = new ArrayList<Car>();
    	}
    	cars.add(car);
   
    	storeToSession(cars);
    	//displayMessage();
    	car = new Car();
    	
    	//return null;
    }
    


}
