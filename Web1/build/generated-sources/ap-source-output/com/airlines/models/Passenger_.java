package com.airlines.models;

import com.airlines.models.FlightClass;
import com.airlines.models.Gender;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-10-17T18:21:51")
@StaticMetamodel(Passenger.class)
public class Passenger_ { 

    public static volatile SingularAttribute<Passenger, String> firstName;
    public static volatile SingularAttribute<Passenger, String> lastName;
    public static volatile SingularAttribute<Passenger, Gender> gender;
    public static volatile SingularAttribute<Passenger, Date> dob;
    public static volatile SingularAttribute<Passenger, FlightClass> flightClass;
    public static volatile SingularAttribute<Passenger, Long> id;

}