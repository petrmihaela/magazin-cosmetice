package data_layer.services;

import data_layer.models.Produs;
import data_layer.repositories.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdusService {

    @Autowired
    ProdusRepository produsRepository;

    public List<Produs> getAllProducts() {
        return produsRepository.findAll();
    }
}
