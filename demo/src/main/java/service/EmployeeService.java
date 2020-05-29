package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import model.Employee;
import repository.employeedao;

@RestController
@RequestMapping(path="/demo")
public class EmployeeService {
	
	@Autowired
	private employeedao dao;
	
	 @PostMapping(path="/add") 
	 public @ResponseBody String addNewUser (@RequestParam String name)
	 {
		  Employee emp = new Employee();
		    emp.setName(name);
		    dao.save(emp);
		    return "Saved";
	 }
	@GetMapping(path="/get")
	public Iterable<Employee> getemployee()
	{
		return dao.findAll();
	}

}
