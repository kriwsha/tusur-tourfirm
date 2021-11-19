package bva.tusur.dz.service;

import bva.tusur.dz.dto.rs.GetClientInfoResponse;

public interface ClientService {

    void addNewClient(String name, String surname, String patronymic, String phoneNumber);

    GetClientInfoResponse getClientByRequest(String name, String phoneNumber);

}
