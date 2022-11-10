package htw.webtech.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonRepository extends JpaRepository<PersonEnity, Long> {

     List<PersonEnity> findAllByFirstName(String firstName);
}
