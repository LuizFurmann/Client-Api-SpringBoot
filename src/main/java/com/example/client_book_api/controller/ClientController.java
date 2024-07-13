package com.example.client_book_api.controller;

import com.example.client_book_api.dto.ClientDto;
import com.example.client_book_api.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/client")
    public ResponseEntity<?> postClient(@ModelAttribute ClientDto clientDto) throws IOException {
        boolean success = clientService.postClient(clientDto);
        if(success){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            return new ResponseEntity<>("O e-mail já existe!", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/clients")
    public ResponseEntity<?> getAllClients(){
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long clientId){
        ClientDto clientDto = clientService.getClientById(clientId);
        return ResponseEntity.ok(clientDto);
    }

    @PutMapping("/client/{clientId}")
    public ResponseEntity<Void> updateAluno(@PathVariable Long clientId, @ModelAttribute ClientDto clientDto) throws IOException{
        try {
            boolean success = clientService.updateClient(clientId, clientDto);
            if(success) return ResponseEntity.status(HttpStatus.OK).build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
