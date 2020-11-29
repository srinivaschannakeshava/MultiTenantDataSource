package in.srini91.learn.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.srini91.learn.dao.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
