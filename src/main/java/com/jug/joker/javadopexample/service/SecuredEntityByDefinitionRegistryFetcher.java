package com.jug.joker.javadopexample.service;

import com.jug.joker.javadopexample.api.dto.definition.*;
import com.jug.joker.javadopexample.model.SecuredEntity;
import com.jug.joker.javadopexample.repository.CustomerRepository;
import com.jug.joker.javadopexample.repository.ProductRepository;
import com.jug.joker.javadopexample.repository.PurchaseRepository;
import com.jug.joker.javadopexample.service.integration.ProductPropertiesIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class SecuredEntityByDefinitionRegistryFetcher {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;
    private final ProductPropertiesIntegrationService productPropertiesIntegrationService;

    public Optional<? extends SecuredEntity> findEntityByDefinition(EntityDefinition entityDefinition) {
        Optional<? extends SecuredEntity> result;

        if (entityDefinition instanceof LongIdEntityDefinition) {
            var longIdEntityDefinition = (LongIdEntityDefinition) entityDefinition;
            if (longIdEntityDefinition instanceof ProductDefinition) {
                result = productRepository.findById(
                        ((ProductDefinition) longIdEntityDefinition).getId()
                );
            } else if (longIdEntityDefinition instanceof PurchaseDefinition) {
                result = purchaseRepository.findById(
                        ((PurchaseDefinition) longIdEntityDefinition).getId()
                );
            } else if (longIdEntityDefinition instanceof ProductPropertiesDefinition) {
                result = productPropertiesIntegrationService.findById(
                        ((ProductPropertiesDefinition) longIdEntityDefinition).getId()
                );
            } else {
                throw new RuntimeException("Absurdly impossible");
            }
        } else if (entityDefinition instanceof UUIDEntityDefinition) {
            var uuidEntityDefinition = (UUIDEntityDefinition) entityDefinition;
            if (uuidEntityDefinition instanceof CustomerDefinition) {
                result = customerRepository.findById(((CustomerDefinition) entityDefinition).getId());
            } else {
                throw new RuntimeException("Absurdly impossible");
            }
        } else {
            throw new RuntimeException("Absurdly impossible");
        }
        return result;
    }
}
