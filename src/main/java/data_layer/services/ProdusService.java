package data_layer.services;

import data_layer.dto.ProductDto;
import data_layer.models.Imagine;
import data_layer.models.Produs;
import data_layer.repositories.ImagineRepository;
import data_layer.repositories.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdusService {

    @Autowired
    ProdusRepository produsRepository;

    @Autowired
    ImagineRepository imagineRepository;

    public List<Produs> getAllProducts() {
        return produsRepository.findAll();
    }

    public List<ProductDto> fromProdusToDto(List<Produs> old) {

        List<ProductDto> produseDto = new ArrayList<>();

        for (Produs p : old) {
            List<String> urls = imagineRepository.getUrlForProduct(p.getId());
            ProductDto produsDto = new ProductDto(p.getId(), p.getNume(), p.getPret(), p.getDescriere(), urls);
            produseDto.add(produsDto);
        }
        return produseDto;

    }

    public List<ProductDto> getTypeProducts(String n) {

        List<Produs> produse = produsRepository.findByNumeContainingIgnoreCase(n);
        return fromProdusToDto(produse);
    }

    public List<ProductDto> getProductImages() {

        List<Produs> produse = produsRepository.findAll();
        List<ProductDto> produseDto = new ArrayList<>();

        produseDto = fromProdusToDto(produse);
        return produseDto;
    }
}
