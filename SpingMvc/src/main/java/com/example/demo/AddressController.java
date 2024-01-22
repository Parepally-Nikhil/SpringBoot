package com.example.demo;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AddressController {
	@Autowired
	private JdbcTemplate jdbctemplate;
	@RequestMapping("address")
	public String address() {
		return "address";
	}
	
	@RequestMapping("insertData")
    public String insertData(Address ad) {
		
        String query = "insert into address1 values(' " + ad.getCity() + " ',' " + ad.getState() + " ')";
        int res = jdbctemplate.update(query);
        if(res>0)
                return "success";
        else
                return "failure";
    }
	
	@RequestMapping("updateData")
    public String updateData(Address ad) {
		
        String query="update address1 set city=' "+ad.getCity()+" '  where state=' "+ad.getState()+" '";
        int res = jdbctemplate.update(query);
        if(res>0)
                return "success";
        else
                return "failure";
    }
	
	@RequestMapping("deleteData")
    public String deleteData(Address ad) {
		
        String query="delete from address1 where city=' "+ad.getCity()+" '";
        int res = jdbctemplate.update(query);
        if(res>0)
                return "success";
        else
                return "failure";
    }
	
	@RequestMapping("selectData")
	public String retrieval(HttpServletRequest req){
		RowMapper<Address> rm=(rs,rmp)->{
			Address a=new Address();
			a.setCity(rs.getString(1));
			a.setState(rs.getString(2));
			return a;
			
		};
		List<Address> adlist=jdbctemplate.query("select * from address1",rm);
		req.setAttribute("show",adlist);
		return "display";
	}
}
