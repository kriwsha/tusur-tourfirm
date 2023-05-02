package bva.tusur.dz.service;

import bva.tusur.dz.model.rs.GetAllClientsResponse;
import bva.tusur.dz.model.rs.GetClientInfoResponse;

/**
 * Сервис для работы с данными клиентов
 */
public interface ClientService {

    /**
     * Заведение нового клиента
     *
     * @param name        ...
     * @param surname     ...
     * @param patronymic  ...
     * @param phoneNumber ...
     */
    void addNewClient(String name, String surname, String patronymic, String phoneNumber);

    /**
     * Получение списка клиентов
     *
     * @return информация о клиенте
     */
    GetAllClientsResponse getAllClientsInfo();

    /**
     * Получение информации о клиенте
     *
     * @param name        ...
     * @param phoneNumber ...
     * @return информация о клиенте
     */
    GetClientInfoResponse getClientByRequest(String phoneNumber);

}
