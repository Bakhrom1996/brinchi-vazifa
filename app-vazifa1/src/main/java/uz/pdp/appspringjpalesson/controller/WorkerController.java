package uz.pdp.appspringjpalesson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appspringjpalesson.dto.WorkerDTO;
import uz.pdp.appspringjpalesson.model.Worker;
import uz.pdp.appspringjpalesson.service.WorkerService;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    @GetMapping
    public ResponseEntity<List<Worker>> getAllWorkers() {
        List<Worker> workers = workerService.getAllWorkers();
        return new ResponseEntity<>(workers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable("id") Integer id) {
        Worker worker = workerService.getWorkerById(id);
        if (worker == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createWorker(@RequestBody WorkerDTO workerDTO) {
        String result = workerService.addWorker(workerDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateWorker(@PathVariable("id") Integer id, @RequestBody WorkerDTO workerDTO) {
        String result = workerService.updateWorker(id, workerDTO);
        if (result.equals("Worker not found")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorker(@PathVariable("id") Integer id) {
        String result = workerService.deleteWorker(id);
        if (result.equals("Worker not found")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
