package bva.tusur.dz.model.rs;

import bva.tusur.dz.model.dto.TourDto;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("patronymic")
    private String patronymic;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("tours")
    private List<TourDto> tours;
}
