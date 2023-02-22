package uz.pdp.appspringjpalesson.dto;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.appspringjpalesson.model.Company;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private  Integer id;
    private String name;
    private Integer companyId;
}
