package uz.pdp.appspringjpalesson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appspringjpalesson.dto.CompanyDTO;
import uz.pdp.appspringjpalesson.model.Company;
import uz.pdp.appspringjpalesson.service.CompanyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping
    public List<Company> getAllCompany() {
        return companyService.getAllCompany();
    }
    @GetMapping("/{id}")
    public Optional<Company> getAllById(@PathVariable Integer id) {
        return Optional.ofNullable(companyService.getById(id));
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody CompanyDTO companyDto) {
        String result = companyService.createCompany(companyDto);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Integer id, @RequestBody CompanyDTO companyDto) {
        String result = companyService.updateCompany(id, companyDto);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Integer id) {
        String result = companyService.deleteCompany(id);
        return ResponseEntity.ok().body(result);
    }
}
