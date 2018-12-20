package data_layer.services;

import data_layer.models.Comanda;
import data_layer.models.ProdCom;
import data_layer.repositories.ComandaRepository;
import data_layer.repositories.ProdComRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComandaService {
    @Autowired
    ComandaRepository comandaRepository;
    @Autowired
    ProdComRepository prodComRepository;

    public void saveComanda(Comanda c) {
        comandaRepository.save(c);
    }

    public void saveProdCom(ProdCom c) {
        prodComRepository.save(c);
    }

}
