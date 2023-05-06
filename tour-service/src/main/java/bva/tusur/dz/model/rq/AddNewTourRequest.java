package bva.tusur.dz.model.rq;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AddNewTourRequest {
    @JsonProperty(value = "hotel_id", required = true)
    @ApiModelProperty(value = "Идентификатор отеля", example = "10", required = true)
    private String hotelId;
    @JsonProperty(value = "transport_id", required = true)
    @ApiModelProperty(value = "Идентификатор транспорта", example = "100", required = true)
    private int transportId;
    @JsonProperty(value = "start_date", required = true)
    @ApiModelProperty(value = "Дата начала", example = "2020-10-10", required = true)
    private String dateFrom;
    @JsonProperty(value = "end_date", required = true)
    @ApiModelProperty(value = "Дата начала", example = "2020-10-20", required = true)
    private String dateTo;
    @JsonProperty(value = "price", required = true)
    @ApiModelProperty(value = "Стоимость", example = "1500", required = true)
    private int price;
}
