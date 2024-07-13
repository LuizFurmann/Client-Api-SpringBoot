package com.example.client_book_api.service.client;

import com.example.client_book_api.dto.ClientDto;
import com.example.client_book_api.entity.Client;
import com.example.client_book_api.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;

    @Override
    public boolean postClient(ClientDto clientDto) {
        try {
            Client client = new Client();
            client.setName(clientDto.getName());
            client.setFantasyName(clientDto.getFantasyName());
            clientRepository.save(client);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream().map(Client::getClientDto).collect(Collectors.toList());
    }

    @Override
    public ClientDto getClientById(Long clientId) {
        Optional<Client> optionalAluno = clientRepository.findById(clientId);
        return optionalAluno.map(Client::getClientDto).orElse(null);
    }

    @Override
    public boolean updateClient(Long clientId, ClientDto clientDto) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if(optionalClient.isPresent()){
            Client existngClient = optionalClient.get();
            existngClient.setName(clientDto.getName());
            existngClient.setFantasyName(clientDto.getFantasyName());
            clientRepository.save(existngClient);
            return  true;
        }else{
            return false;
        }
    }
}
