package com.labouardy.resources;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.sql.DataSource;

import com.labouardy.model.Customer;

@ManagedBean(name="customerBean")
@SessionScoped
public class CustomerBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/mydb")
	private DataSource ds;
	
	public List<Customer> getCustomerList() throws SQLException{
		
		if(ds==null)
			throw new SQLException("Can't get data source");
		
		//get database connection
		Connection con = ds.getConnection();
		
		if(con==null)
			throw new SQLException("Can't get database connection");
		
		PreparedStatement ps 
			= con.prepareStatement(
			   "select customer_id, name, address, created_date from customer"); 
		
		//get customer data from database
		ResultSet result =  ps.executeQuery();
		
		List<Customer> list = new ArrayList<Customer>();
		
		while(result.next()){
			Customer cust = new Customer();
			
			cust.setId(result.getInt("id"));
			cust.setName(result.getString("name"));
			cust.setAddress(result.getString("address"));
			cust.setCreated_at(result.getDate("created_date"));
			
			//store all data into a List
			list.add(cust);
		}
			
		return list;
	}

}
