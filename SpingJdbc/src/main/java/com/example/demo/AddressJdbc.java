package com.example.demo;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressJdbc {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int saveEmployee(Address e){
        String query="insert into address values(' "+ e.getCity()+" ',' "+e.getCountry()+" ')";
        return jdbcTemplate.update(query);
    }
	public int updateEmployee(Address e) {
		String query="update address set city=' "+e.getCity()+" '  where country=' "+e.getCountry()+" '";
		//String query="update address set city='"+e.getCity()+"' where country='"+e.getCountry()+"'";
		  return jdbcTemplate.update(query);
	}
	public int deleteEmployee(Address e) {
		String query="delete from address where city=' "+e.getCity()+" '";
		
		  return jdbcTemplate.update(query);
	}
	
	public List<Address> retrieval(){
		RowMapper<Address> rm=(rs,rmp)->{
			Address a=new Address();
			a.setCity(rs.getString(1));
			a.setCountry(rs.getString(2));
			return a;
			
		};
		return jdbcTemplate.query("select * from address",rm);
	}
	
}
