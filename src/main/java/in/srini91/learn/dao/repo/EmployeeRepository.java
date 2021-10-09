package in.srini91.learn.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.srini91.learn.dao.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
