package bva.tusur.dz.service;

import bva.tusur.dz.dto.rs.GetClientInfoResponse;

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
     * Получение информации о клиенте
     *
     * @param name        ...
     * @param phoneNumber ...
     * @return информация о клиенте
     */
    GetClientInfoResponse getClientByRequest(String name, String phoneNumber);

}
