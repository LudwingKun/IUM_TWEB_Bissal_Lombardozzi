package com.bissallombardozzi.springbootserver.Mapper;
import com.bissallombardozzi.springbootserver.Actor.Actor;
import com.bissallombardozzi.springbootserver.ActorDetails.ActorDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ActorMapper {

    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

    ActorDetails toDto(Actor actor);

    Actor toEntity(ActorDetails dto);
}
