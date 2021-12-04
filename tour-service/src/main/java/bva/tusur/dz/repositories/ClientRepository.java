package bva.tusur.dz.repositories;

import bva.tusur.dz.dto.rs.GetClientInfoResponse;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ClientRepository {

    @Qualifier("DSLContext")
    private DSLContext jooq;

    @Autowired
    public ClientRepository(DSLContext jooq) {
        this.jooq = jooq;
    }

    public void createNewClient(String name, String surname, String patronymic, String phoneNumber) {
        throw new UnsupportedOperationException("not implemented");
    }

    public GetClientInfoResponse getClientInfoByParams(String name, String phoneNumber) {
        // TODO: 04.12.2021 for test
        return new GetClientInfoResponse("alex",
                "bloom",
                "",
                "1234567",
                Collections.emptyList());
    }
}
