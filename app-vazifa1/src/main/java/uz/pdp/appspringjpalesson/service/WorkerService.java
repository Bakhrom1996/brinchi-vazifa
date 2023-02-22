package uz.pdp.appspringjpalesson.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appspringjpalesson.dto.WorkerDTO;
import uz.pdp.appspringjpalesson.model.Address;
import uz.pdp.appspringjpalesson.model.Department;
import uz.pdp.appspringjpalesson.model.Worker;
import uz.pdp.appspringjpalesson.repository.AddressRepository;
import uz.pdp.appspringjpalesson.repository.DepartmentRepository;
import uz.pdp.appspringjpalesson.repository.WorkerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    public Worker getWorkerById(Integer id) {
        Optional<Worker> worker = workerRepository.findById(id);
        return worker.orElse(null);
    }

    public String addWorker(WorkerDTO workerDTO) {
        Worker worker = new Worker();
        worker.setName(workerDTO.getName());
        worker.setPhoneNumber(workerDTO.getPhoneNumber());
        Optional<Department> department = departmentRepository.findById(workerDTO.getDepartmentId());
        if (department.isEmpty()) {
            return "Bunday department topilmadi";
        }
        worker.setDepartment(department.get());
        Optional<Address> address = addressRepository.findById(workerDTO.getAddressId());
        if (address.isEmpty()) {
            return "Bunday manzil topilmadi";
        }
        worker.setAddress(address.get());
        workerRepository.save(worker);
        return "Yangi ishchi saqlandi";
    }

    public String updateWorker(Integer id, WorkerDTO workerDTO) {
        Optional<Worker> worker = workerRepository.findById(id);
        if (worker.isEmpty()) {
            return "Bunday ishchi topilmadi";
        }
        worker.get().setName(workerDTO.getName());
        worker.get().setPhoneNumber(workerDTO.getPhoneNumber());
        Optional<Department> department = departmentRepository.findById(workerDTO.getDepartmentId());
        if (department.isEmpty()) {
            return "Bunday bo'lim topilmadi";
        }
        worker.get().setDepartment(department.get());
        Optional<Address> address = addressRepository.findById(workerDTO.getAddressId());
        if (address.isEmpty()) {
            return "Bunday manzil topilmadi";
        }
        worker.get().setAddress(address.get());
        workerRepository.save(worker.get());
        return "Ishchi o'zgartirildi";
    }


    public String deleteWorker(Integer id) {
        Optional<Worker> worker = workerRepository.findById(id);
        if (worker.isEmpty()) {
            return "Bunday ishchi topilmadi";
        }
        workerRepository.delete(worker.get());
        return "Ishchi o'chirildi";
    }
}
