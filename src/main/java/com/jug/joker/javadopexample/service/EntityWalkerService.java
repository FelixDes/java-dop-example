package com.jug.joker.javadopexample.service;

import com.jug.joker.javadopexample.model.entity.Customer;
import com.jug.joker.javadopexample.model.entity.Purchase;
import com.jug.joker.javadopexample.model.entity.PurchasePart;
import com.jug.joker.javadopexample.model.entity.SecuredEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
@Service
public class EntityWalkerService<T> {
    private Stream<T> processEntityTreeToStream(
            SecuredEntity<?> entity,
            Function<SecuredEntity<?>, T> mapper
    ) {
        var result = Stream.of(mapper.apply(entity));

        switch (entity) {
            case Purchase purchase -> {
                var beneathLayerResult = Stream.concat(
                        purchase.getPurchaseParts()
                                .stream()
                                .flatMap(p -> processEntityTreeToStream(p, mapper)),
                        purchase.getCustomers()
                                .stream()
                                .flatMap(p -> processEntityTreeToStream(p, mapper))
                );

                result = Stream.concat(
                        result,
                        beneathLayerResult
                );
            }
            case PurchasePart _, Customer _ -> {
            }
        }

        return result;
    }

    public List<T> processEntityTree(
            SecuredEntity<?> entity,
            Function<SecuredEntity<?>, T> mapper
    ) {
        return processEntityTreeToStream(entity, mapper).toList();
    }
}

