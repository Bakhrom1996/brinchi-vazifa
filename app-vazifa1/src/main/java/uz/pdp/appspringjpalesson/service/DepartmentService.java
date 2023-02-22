package uz.pdp.appspringjpalesson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appspringjpalesson.dto.DepartmentDTO;
import uz.pdp.appspringjpalesson.model.Company;
import uz.pdp.appspringjpalesson.model.Department;
import uz.pdp.appspringjpalesson.repository.CompanyRepository;
import uz.pdp.appspringjpalesson.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department getById(Integer id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.orElse(null);
    }

    public String addDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setName(departmentDTO.getName());
        Optional<Company> company = companyRepository.findById(departmentDTO.getCompanyId());
        if (company.isEmpty()) {
            return "Bunday company topilmadi";
        }
        department.setCompany(company.get());
        departmentRepository.save(department);
        return "Yangi company saqlandi";
    }

    public String updateDepartment(Integer id, DepartmentDTO departmentDTO) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isEmpty()) {
            return "Bunday department topilmadi";
        }
        department.get().setName(departmentDTO.getName());
        Optional<Company> company = companyRepository.findById(departmentDTO.getCompanyId());
        if (company.isEmpty()) {
            return "Bunday kompaniya topilmadi";
        }
        department.get().setCompany(company.get());
        departmentRepository.save(department.get());
        return "Department o'zgartirildi";
    }

    public String deleteDepartment(Integer id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isEmpty()) {
            return "Bunday department topilmadi";
        }
        departmentRepository.delete(department.get());
        return "department o'chirildi";
    }
}
