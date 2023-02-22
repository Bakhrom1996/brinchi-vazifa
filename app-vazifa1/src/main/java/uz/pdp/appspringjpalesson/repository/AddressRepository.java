package uz.pdp.appspringjpalesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appspringjpalesson.model.Address;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Integer> {
}
