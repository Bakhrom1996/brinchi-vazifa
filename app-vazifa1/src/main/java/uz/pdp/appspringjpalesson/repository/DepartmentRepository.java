package uz.pdp.appspringjpalesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appspringjpalesson.model.Department;

@Repository
public interface DepartmentRepository  extends JpaRepository<Department, Integer> {
}
