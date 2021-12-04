package bva.tusur.dz.rest;

import bva.tusur.dz.dto.rq.CreateClientRequest;
import bva.tusur.dz.dto.rs.GetClientInfoResponse;
import bva.tusur.dz.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@Api(tags = "Клиенты")
public class ClientRest {

    private final ClientService clientService;

    @Autowired
    public ClientRest(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add")
    @ApiOperation("Добавление клиента")
    public ResponseEntity<?> createClient(@RequestBody CreateClientRequest request) {
        try {
            clientService.addNewClient(
                    request.getName(),
                    request.getSurname(),
                    request.getPatronymic(),
                    request.getPhoneNumber());
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/get_client")
    @ApiOperation("Получение информации о клиенте")
    public GetClientInfoResponse getClientInfo(
            @RequestParam("name") String name,
            @RequestParam("phone_number") String phoneNumber) {
        return clientService.getClientByRequest(name, phoneNumber);
    }

}
