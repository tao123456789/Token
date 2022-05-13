package com.example.token.Mapper;

import com.example.token.Entity.BO.subscriber.SubscriberBO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SubscriberMapper {
    List<SubscriberBO> getSubscriberByType(String type);
}
