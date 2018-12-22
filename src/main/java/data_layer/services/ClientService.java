package data_layer.services;

import data_layer.dto.ClientDto;
import data_layer.dto.LoggedClient;
import data_layer.exceptions.NotFoundException;
import data_layer.models.Customer;
import data_layer.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public int saveClient(Customer c) {
        Customer added = clientRepository.saveAndFlush(c);
        return added.getId();
    }

    public LoggedClient getClient(ClientDto clientDto) throws NotFoundException {
        Customer customer = clientRepository.findByUsernameAndParola(clientDto.getUsername(), clientDto.getParola());
        if(customer == null){
            throw new NotFoundException("Username or password is wrong!");
        }

        LoggedClient loggedClient=new LoggedClient(customer.getId(),customer.getNume(),customer.getPrenume(),customer.getTelefon(),customer.getAdresa());
        return loggedClient;
    }
}
