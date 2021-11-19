package bva.tusur.dz.dto.rq;

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
public class GetClientInfoRequest {

    @JsonProperty(value = "name", required = true)
    @ApiModelProperty(value = "Имя клиента", example = "Иван", required = true)
    private String name;

    @JsonProperty(value = "phone_number", required = true)
    @ApiModelProperty(value = "Номер телефона", example = "89997776655", required = true)
    private String phoneNumber;

}
