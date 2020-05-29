package repository;

import org.springframework.data.repository.CrudRepository;

import model.Employee;

public interface employeedao extends CrudRepository<Employee, Long>{

}
