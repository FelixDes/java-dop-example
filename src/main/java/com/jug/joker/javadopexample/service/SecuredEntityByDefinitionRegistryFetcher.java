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
import java.util.UUID;

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

        if (entityDefinition instanceof LongIdEntityDefinition longIdEntityDefinition) {
            if (longIdEntityDefinition instanceof ProductDefinition def) {
                result = productRepository.findById(def.id());
            } else if (longIdEntityDefinition instanceof PurchaseDefinition def) {
                result = purchaseRepository.findById(def.id());
            } else if (longIdEntityDefinition instanceof ProductPropertiesDefinition def) {
                result = productPropertiesIntegrationService.findById(def.id());
            } else {
                throw new RuntimeException("Absurdly impossible");
            }
        } else if (entityDefinition instanceof UUIDEntityDefinition uuidEntityDefinition) {
            if (uuidEntityDefinition instanceof CustomerDefinition def) {
                result = customerRepository.findById(def.id());
            } else {
                throw new RuntimeException("Absurdly impossible");
            }
        } else {
            throw new RuntimeException("Absurdly impossible");
        }
        return result;
    }
}
