package com.example.demo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.Country;



@SpringBootApplication
public class SpringRestHandson2Application {	
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringRestHandson2Application.class, args);
		
	}
	
	public Country displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("india.xml"); 
		Country country = (Country) context.getBean("in", Country.class);
		return country;
	}
	 
	
	public List<Country> displayCountries()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> list=context.getBean("countryList",java.util.ArrayList.class);
		return list;
		
	}

}
