package com.jug.joker.javadopexample.service.fetcher;

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
public class SecuredEntityByDefinitionRegistryFetcher_DopImpl implements SecuredEntityByDefinitionRegistryFetcher {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;
    private final ProductPropertiesIntegrationService productPropertiesIntegrationService;

    @SuppressWarnings("unchecked")
    @Override
    public <T> Optional<? extends SecuredEntity<T>> findEntityByDefinition(EntityDefinition<T> entityDefinition) {
        Optional<? extends SecuredEntity<?>> result;

        if (entityDefinition instanceof LongIdEntityDefinition) {
            var longIdEntityDefinition = (LongIdEntityDefinition) entityDefinition;
            if (longIdEntityDefinition instanceof ProductDefinition) {
                result = productRepository.findById(
                        longIdEntityDefinition.getId()
                );
            } else if (longIdEntityDefinition instanceof PurchaseDefinition) {
                result = purchaseRepository.findById(
                        longIdEntityDefinition.getId()
                );
            } else if (longIdEntityDefinition instanceof ProductPropertiesDefinition) {
                result = productPropertiesIntegrationService.findById(
                        longIdEntityDefinition.getId()
                );
            } else {
                throw new RuntimeException("Not expected");
            }
        } else if (entityDefinition instanceof UUIDEntityDefinition) {
            var uuidEntityDefinition = (UUIDEntityDefinition) entityDefinition;
            if (uuidEntityDefinition instanceof CustomerDefinition) {
                var customerDefinition = (CustomerDefinition) uuidEntityDefinition;
                result = customerRepository.findById(customerDefinition.getId());
            } else {
                throw new RuntimeException("Not expected");
            }
        } else {
            throw new RuntimeException("Not expected");
        }
        return (Optional<? extends SecuredEntity<T>>) result;
    }
}
