package com.levi9.code9.product.messaging;

import com.levi9.code9.product.Product;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

import static java.time.OffsetDateTime.now;

@UtilityClass
@Slf4j
public class MessageFactory {

    public static ProductsUserMessage createProductUserMessage(List<Product> product, String mail) {
        return ProductsUserMessage.builder()
                .email(mail)
                .notificationType(NotificationType.EMAIL.name())
                .products(product.stream()
                        .map(p -> p.getName() + ":" + p.getPrice() + " rsd")
                        .collect(Collectors.toList()))
                .sendingTime(now().toString())
                .version(1).build();
    }


}
