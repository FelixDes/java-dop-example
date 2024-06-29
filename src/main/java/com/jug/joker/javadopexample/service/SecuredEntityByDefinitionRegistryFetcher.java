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
        return switch (entityDefinition) {
            case LongIdEntityDefinition longIdEntityDefinition -> {
                yield switch (longIdEntityDefinition) {
                    case ProductDefinition(long id) -> productRepository.findById(id);
                    case PurchaseDefinition(long id) -> purchaseRepository.findById(id);
                    case ProductPropertiesDefinition(long id) -> productPropertiesIntegrationService.findById(id);
                };
            }
            case UUIDEntityDefinition uuidEntityDefinition -> switch (uuidEntityDefinition) {
                case CustomerDefinition(UUID id) -> customerRepository.findById(id);
            };
        };
    }
}
