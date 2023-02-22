package uz.pdp.appspringjpalesson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import uz.pdp.appspringjpalesson.dto.CompanyDTO;
import uz.pdp.appspringjpalesson.model.Address;
import uz.pdp.appspringjpalesson.model.Company;
import uz.pdp.appspringjpalesson.repository.AddressRepository;
import uz.pdp.appspringjpalesson.repository.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    public Company getById(Integer id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.orElse(null);
    }


    public String createCompany(CompanyDTO companyDto) {
        Company company = new Company();
        company.setCorpName(companyDto.getCorpName());
        company.setDirectorName(companyDto.getDirectorName());
        Optional<Address> address = addressRepository.findById(companyDto.getAddressId());
        if (address.isEmpty()) {
            return "Bunday manzil topilmadi";
        }
        company.setAddress(address.get());
        companyRepository.save(company);
        return "Yangi kompaniya saqlandi: ";
    }

    public String updateCompany(Integer id, CompanyDTO companyDto) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isEmpty()) {
            return "Bunday kompaniya topilmadi";
        }
        Company company = optionalCompany.get();
        company.setCorpName(companyDto.getCorpName());
        company.setDirectorName(companyDto.getDirectorName());
        Optional<Address> address = addressRepository.findById(companyDto.getAddressId());
        if (address.isEmpty()) {
            return "Bunday manzil topilmadi";
        }
        company.setAddress(address.get());
        companyRepository.save(company);
        return "Kompaniya muvaffaqiyatli yangilandi";
    }

    public String deleteCompany(Integer id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isEmpty()) {
            return "Bunday kompaniya topilmadi";
        }
        Company company = optionalCompany.get();
        companyRepository.delete(company);
        return "Kompaniya muvaffaqiyatli o'chirildi";
    }
}
