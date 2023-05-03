package bva.tusur.dz.rest;

import bva.tusur.dz.model.rq.CreateClientRequest;
import bva.tusur.dz.model.rs.GetAllClientsResponse;
import bva.tusur.dz.model.rs.GetClientInfoResponse;
import bva.tusur.dz.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@Api(tags = "Клиенты")
@Slf4j
public class ClientRest {

    private final ClientService clientService;

    @Autowired
    public ClientRest(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping()
    @ApiOperation("Добавление клиента")
    public ResponseEntity<?> createClient(@RequestBody CreateClientRequest request) {
        clientService.addNewClient(
                request.getName(),
                request.getSurname(),
                request.getPatronymic(),
                request.getPhoneNumber());
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    @ApiOperation("Получение списка клиентов")
    public ResponseEntity<GetAllClientsResponse> getAllClients() {
        GetAllClientsResponse allClientsInfo = clientService.getAllClientsInfo();
        return ResponseEntity.ok(allClientsInfo);
    }

    @GetMapping("/client-info")
    @ApiOperation("Получение информации о клиенте")
    public ResponseEntity<GetClientInfoResponse> getClientInfo(
            @RequestParam("phone_number") String phoneNumber) {
        GetClientInfoResponse rs = clientService.getClientByRequest(phoneNumber);
        return ResponseEntity.ok(rs);
    }

}
