package com.jug.joker.javadopexample.service;

import com.jug.joker.javadopexample.api.dto.definition.*;
import com.jug.joker.javadopexample.model.SecuredEntity;
import com.jug.joker.javadopexample.repository.CustomerRepository;
import com.jug.joker.javadopexample.repository.ProductRepository;
import com.jug.joker.javadopexample.repository.PurchaseRepository;
import com.jug.joker.javadopexample.service.integration.ProductPropertiesIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SecuredEntityByDefinitionRegistryFetcher {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;
    private final ProductPropertiesIntegrationService productPropertiesIntegrationService;

    Optional<? extends SecuredEntity> findEntityByDefinition(EntityDefinition entityDefinition) {
        return switch (entityDefinition) {
            case LongIdEntityDefinition longIdEntityDefinition -> {
                yield switch (longIdEntityDefinition) {
                    case ProductDefinition def -> productRepository.findById(def.id());
                    case PurchaseDefinition def -> purchaseRepository.findById(def.id());
                    case ProductPropertiesDefinition def -> productPropertiesIntegrationService.findById(def.id());
                };
            }
            case UUIDEntityDefinition uuidEntityDefinition -> switch (uuidEntityDefinition) {
                case CustomerDefinition def -> customerRepository.findById(def.id());
            };
        };
    }
}
