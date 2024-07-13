package com.example.client_book_api.entity;

import com.example.client_book_api.dto.ClientDto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(nullable = false)
    private String name;

    private String fantasyName;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long alunoId) {
        this.clientId = alunoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public ClientDto getClientDto(){
        ClientDto clientDto = new ClientDto();
        clientDto.setClientId(clientId);
        clientDto.setName(name);
        clientDto.setFantasyName(fantasyName);
        return clientDto;
    }
}
