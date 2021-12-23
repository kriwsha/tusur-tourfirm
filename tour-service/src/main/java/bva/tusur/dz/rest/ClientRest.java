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

    @GetMapping()
    @ApiOperation("Получение списка клиентов")
    public GetAllClientsResponse getAllClients() {
        log.debug("getAllClients started");
        GetAllClientsResponse allClientsInfo = clientService.getAllClientsInfo();
        log.debug("getAllClients finished");
        return allClientsInfo;
    }

    @GetMapping("/client")
    @ApiOperation("Получение информации о клиенте")
    public GetClientInfoResponse getClientInfo(
            @RequestParam("name") String name,
            @RequestParam("phone_number") String phoneNumber) {
        return clientService.getClientByRequest(name, phoneNumber);
    }

}
