package data_layer.services;

import data_layer.models.Customer;
import data_layer.repositories.ClientRepository;
import data_layer.repositories.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public void saveClient(Customer c){
        clientRepository.save(c);
    }
}
