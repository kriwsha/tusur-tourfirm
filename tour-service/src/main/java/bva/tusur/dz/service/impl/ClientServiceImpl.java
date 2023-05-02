package bva.tusur.dz.service.impl;

import bva.tusur.dz.model.rs.GetAllClientsResponse;
import bva.tusur.dz.model.rs.GetClientInfoResponse;
import bva.tusur.dz.repositories.ClientRepository;
import bva.tusur.dz.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис для работы с данными клиентов
 */
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    /**
     * Заведение нового клиента
     *
     * @param name        ...
     * @param surname     ...
     * @param patronymic  ...
     * @param phoneNumber ...
     */
    @Override
    public void addNewClient(String name, String surname, String patronymic, String phoneNumber) {
        clientRepository.createNewClient(name, surname, patronymic, phoneNumber);
    }

    /**
     * Получение списка клиентов
     *
     * @return информация о клиенте
     */
    @Override
    public GetAllClientsResponse getAllClientsInfo() {
        return new GetAllClientsResponse(clientRepository.getAllClientsFromDb());
    }

    /**
     * Получение информации о клиенте
     *
     * @param name        ...
     * @param phoneNumber ...
     * @return информация о клиенте
     */
    @Override
    public GetClientInfoResponse getClientByRequest(String phoneNumber) {
        return clientRepository.getClientInfoByParams(phoneNumber);
    }
}
