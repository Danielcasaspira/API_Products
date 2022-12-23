package com.learn.spring.persistence.mapper;

import com.learn.spring.domain.Category;
import com.learn.spring.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active"),
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration //Mapeo inverso sin necesidad de volver a mapear los atributos
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
