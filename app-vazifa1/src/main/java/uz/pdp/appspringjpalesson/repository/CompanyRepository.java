package uz.pdp.appspringjpalesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appspringjpalesson.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
