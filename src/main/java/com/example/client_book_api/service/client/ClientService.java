package com.example.client_book_api.service.client;

import com.example.client_book_api.dto.ClientDto;

import java.util.List;

public interface ClientService {

    boolean postClient(ClientDto clientDto);

    List<ClientDto> getAllClients();


    ClientDto getClientById(Long clientId);

    boolean updateClient(Long clientId, ClientDto clientDto);
}
