package uz.pdp.appspringjpalesson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appspringjpalesson.model.Address;
import uz.pdp.appspringjpalesson.repository.AddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Integer id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.orElse(null);
    }

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public boolean updateAddress(Integer id, Address address) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            Address existingAddress = optionalAddress.get();
            existingAddress.setStreet(address.getStreet());
            existingAddress.setHomeNumber(address.getHomeNumber());
            addressRepository.save(existingAddress);
            return true;
        }
        return false;
    }

    public boolean deleteAddress(Integer id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            addressRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


