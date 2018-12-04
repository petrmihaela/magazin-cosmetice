package data_layer.services;

import data_layer.dto.ClientDto;
import data_layer.models.Customer;
import data_layer.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public void saveClient(Customer c) {
        clientRepository.save(c);
    }

    public Customer getClient(ClientDto clientDto) {
        return clientRepository.findByUsernameAndParola(clientDto.getUsername(), clientDto.getParola());
    }
}
