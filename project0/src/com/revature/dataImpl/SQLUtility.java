package com.revature.dataImpl;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.beans.Car;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.OfferBean;

public class SQLUtility {

	//creates a static reference to the logger
	private static Logger log = Logger.getRootLogger();
	
	//references to DAO implementations
	static EmployeeDAOImpl edi = new EmployeeDAOImpl();
	static CustomerDAOImpl cdi = new CustomerDAOImpl();
	static CarDAOImpl cardi = new CarDAOImpl(); 
	static OffersDAOImpl odi = new OffersDAOImpl();
	
	public static void tryCreateNewEmployeeSQL(Employee e) {
		
		try {
			edi.createNewEmployeeSQL(e);
		} catch (SQLException e1) {
			e1.printStackTrace();
			log.fatal("SQL exception thrown when adding an employee to database"+ e1.getStackTrace());
		}
	}
	
	public static void tryReturnEmployeesSQL() {
		try {
			edi.returnEmployeesSQL();
		} catch (SQLException e) {
			e.printStackTrace();
			log.fatal("SQL exception thrown when populating Employee hashmap from database"+ e.getStackTrace());
		}
	}

	public static void tryCreateNewCustomer(Customer c) {
		try {
			cdi.createNewCustomer(c);
		} catch (SQLException e) {
			log.fatal("SQL exception thrown when adding a customer to database"+ e.getStackTrace());
			e.printStackTrace();
		}
	}
	
	public static void tryReturnCustomersSQL() {
		try {
			cdi.returnCustomersSQL();
		} catch (SQLException e) {
			log.fatal("SQL exception thrown when populating customer hashmap from database"+ e.getStackTrace());
			e.printStackTrace();
		}
	}
	
	public static void tryAddNewCarSQL(Car c) {
		try {
			cardi.addNewCarSQL(c);
		} catch (SQLException e) {
			log.fatal("SQL exception thrown when adding car to database"+ e.getStackTrace());
			e.printStackTrace();
		}
	}
	
	public static void tryPopulateCarLotSQL() {
		try {
			cardi.populateCarLotSQL();
		} catch (SQLException e) {
			log.fatal("SQL exception thrown when populating car list from database"+ e.getStackTrace());
			e.printStackTrace();
		}
	}
	
	public static void tryRemoveCarFromLotSQL(Car c) {
		try {
			cardi.removeCarFromLotSQL(c);
		} catch (SQLException e) {
			log.fatal("SQL exception thrown when removing car from database"+ e.getStackTrace());
			e.printStackTrace();
		}
	}
	
	public static void tryCreateNewOffer(OfferBean o) {
		try {
			odi.createNewOffer(o);
		} catch (SQLException e) {
			log.fatal("SQL exception thrown when adding offer to database"+ e.getStackTrace());
			e.printStackTrace();
		}
	}
	
	public static void tryPopulateOfferMap() {
		try {
			odi.returnOffers();
		} catch (SQLException e) {
			log.fatal("SQL exception thrown when populating offer map from database"+ e.getStackTrace());
			e.printStackTrace();
		}
	}
}
