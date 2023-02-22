package uz.pdp.appspringjpalesson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appspringjpalesson.model.Address;
import uz.pdp.appspringjpalesson.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        if (addresses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Integer id) {
        Address address = addressService.getAddressById(id);
        if (address == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        Address addedAddress = addressService.addAddress(address);
        return new ResponseEntity<>(addedAddress, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable("id") Integer id, @RequestBody Address address) {
        boolean result = addressService.updateAddress(id, address);
        if (result) {
            return new ResponseEntity<>("Manzil muvaffaqiyatli yangilandi", HttpStatus.OK);
        }
        return new ResponseEntity<>("Manzil topilmadi", HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable("id") Integer id) {
        boolean result = addressService.deleteAddress(id);
        if (result) {
            return new ResponseEntity<>("Manzil muvaffaqiyatli oʻchirildi", HttpStatus.OK);
        }
        return new ResponseEntity<>("Manzil topilmadi", HttpStatus.NOT_FOUND);
    }
}

