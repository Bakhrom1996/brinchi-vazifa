package uz.pdp.appspringjpalesson.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
    private Integer id;
    private String corpName;
    private String directorName;
    private Integer addressId;
}
