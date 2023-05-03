package bva.tusur.dz.model.rq;

import lombok.Data;

@Data
public class NewSaleRequest {
    private int tourId;
    private int clientId;
    private int employeeId;
}
