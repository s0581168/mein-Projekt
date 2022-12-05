package htw.webtech.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TerminRepository extends JpaRepository<TerminEnity, Long> {

    List<TerminEnity> findAllByFirstName(String firstName);
}
