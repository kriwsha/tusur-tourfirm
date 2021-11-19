package bva.tusur.dz.dto.rs;

import bva.tusur.dz.dto.TourDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class GetClientInfoResponse {
    private String name;
    private String surname;
    private String patronymic;
    private String phoneNumber;
    private List<TourDto> tours;
}
