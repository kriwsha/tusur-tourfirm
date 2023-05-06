package bva.tusur.dz.repositories;

import bva.tusur.dz.jooq.generated.tables.Clients;
import bva.tusur.dz.jooq.generated.tables.records.ClientsRecord;
import bva.tusur.dz.model.rs.GetClientInfoResponse;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.Result;
import org.jooq.tools.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClientRepository {

    /**
     * jooq.
     */
    @Qualifier("DSLContext")
    private final DSLContext jooq;

    private static final Clients CLIENTS = Clients.CLIENTS;

    @Autowired
    public ClientRepository(DSLContext jooq) {
        this.jooq = jooq;
    }

    /**
     * Create new client.
     * @param name ...
     * @param surname ...
     * @param patronymic ...
     * @param phoneNumber ...
     */
    public void createNewClient(String name, String surname, String patronymic, String phoneNumber) {
        // TODO: 03.01.2022 Решить, как передавать ФИО
        jooq.insertInto(CLIENTS,
                        CLIENTS.NAME, CLIENTS.PHONE, CLIENTS.EMAIL)
                .values(String.format("%s %s %s", name, patronymic, surname), phoneNumber, StringUtils.EMPTY)
                .execute();
    }

    /**
     * Get list of clients.
     * @return list of clients.
     */
    public List<GetClientInfoResponse> getAllClientsFromDb() {
        String fullName = "fullName";
        String phone = "phone";
        Result<Record2<String, String>> records = jooq.select(
                        CLIENTS.NAME.as(fullName),
                        CLIENTS.PHONE.as(phone))
                .from(CLIENTS)
                .fetch();

        return records.stream()
                .map(record -> new GetClientInfoResponse(
                        Optional.ofNullable(record.get(fullName)).orElse("unknown").toString(),
                        Optional.ofNullable(record.get(phone)).orElse("unknown").toString(),
                        Collections.emptyList()
                ))
                .collect(Collectors.toList());
    }

    /**
     * Get client by phone number.
     * @param phoneNumber phone number.
     * @return client.
     */
    public GetClientInfoResponse getClientInfoByParams(String phoneNumber) {
        Result<ClientsRecord> fetch = jooq.selectFrom(CLIENTS)
                .where(CLIENTS.PHONE.eq(phoneNumber))
                .fetch();
        List<GetClientInfoResponse> lst = fetch.stream()
                .map(
                        x -> new GetClientInfoResponse(
                                x.get(CLIENTS.NAME),
                                x.get(CLIENTS.PHONE),
                                Collections.emptyList()
                                // TODO: 06.05.2023 add collection of tours
                        )
                )
                .collect(Collectors.toList());
        return lst.isEmpty() ? null : lst.get(0);
    }
}
