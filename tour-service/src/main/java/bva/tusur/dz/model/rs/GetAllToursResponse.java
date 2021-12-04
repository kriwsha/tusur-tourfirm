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
public class GetAllToursResponse {

    @JsonProperty("tour_list")
    private List<TourDto> tourList;
}
