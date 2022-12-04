
package com.github.click.nd.rest.uds.service.mapper;

import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface EntityMapper<D, E> {
    E toEntity(D var1);

    D toDto(E var1);

    List<E> toEntity(List<D> var1);

    List<D> toDto(List<E> var1);

    @BeanMapping(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
    )
    E update(D var1, @MappingTarget E var2);
}
