package data_layer.services;

import data_layer.dto.ProductDto;
import data_layer.models.Imagine;
import data_layer.models.Produs;
import data_layer.repositories.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdusService {

    @Autowired
    ProdusRepository produsRepository;

    public List<Produs> getAllProducts() {
        return produsRepository.findAll();
    }

    public List<Produs> getTypeProducts(String n) {

        return produsRepository.findByNumeContainingIgnoreCase(n);
    }

    public List<ProductDto> getProductImages() {

        List<Produs> produse = produsRepository.getAllProdus();
        List<ProductDto> produseDto = new ArrayList<>();

        for (Produs p : produse) {
            List<String> urls = produsRepository.getUrlForProduct(p.getId());
            ProductDto produsDto = new ProductDto(p.getId(), p.getNume(), p.getPret(), p.getDescriere(), urls);
            produseDto.add(produsDto);
        }
        return produseDto;
    }
}
