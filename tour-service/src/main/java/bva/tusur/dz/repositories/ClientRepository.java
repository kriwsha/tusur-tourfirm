package bva.tusur.dz.repositories;

import bva.tusur.dz.jooq.generated.tables.Clients;
import bva.tusur.dz.model.rs.GetAllClientsResponse;
import bva.tusur.dz.model.rs.GetClientInfoResponse;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.Result;
import org.jooq.SelectJoinStep;
import org.jooq.tools.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ClientRepository {

    @Qualifier("DSLContext")
    private final DSLContext jooq;

    private static final Clients CLIENTS = Clients.CLIENTS;

    @Autowired
    public ClientRepository(DSLContext jooq) {
        this.jooq = jooq;
    }

    public void createNewClient(String name, String surname, String patronymic, String phoneNumber) {
        // TODO: 03.01.2022 Решить, как передавать ФИО
        jooq.insertInto(CLIENTS,
                        CLIENTS.NAME, CLIENTS.PHONE, CLIENTS.EMAIL)
                .values(String.format("%s %s %s", name, patronymic, surname), phoneNumber, StringUtils.EMPTY)
                .execute();
    }

    public List<GetClientInfoResponse> getAllClientsFromDb() {
        String fullName = "fullName";
        String phone = "phone";
        Result<Record2<String, String>> records = jooq.select(
                        CLIENTS.NAME.as(fullName),
                        CLIENTS.PHONE.as(phone))
                .from(CLIENTS)
                .fetch();

        List<GetClientInfoResponse> clientsList = new ArrayList<>();
        for (Record2<String, String> record : records) {
            clientsList.add(
                    new GetClientInfoResponse(
                            Optional.ofNullable(record.get(fullName)).orElse("unknown").toString(),
                            Optional.ofNullable(record.get(phone)).orElse("unknown").toString(),
                            Collections.emptyList()
                    )
            );
        }

        return clientsList;
    }

    public GetClientInfoResponse getClientInfoByParams(String phoneNumber) {
        // TODO: 04.12.2021 for test
        return new GetClientInfoResponse("alex bloom",
                "1234567",
                Collections.emptyList());
    }
}
