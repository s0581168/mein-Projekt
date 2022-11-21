package htw.webtech.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface KundeRepository extends JpaRepository<KundeEnity, Long> {

     List<KundeEnity> findAllByFirstName(String firstName);
}
