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
    private String fullName;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @Deprecated
    @JsonProperty("tours")
    private List<TourDto> tours;
}
