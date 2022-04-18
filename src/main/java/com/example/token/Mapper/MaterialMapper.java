package com.example.token.Mapper;

import com.example.token.BO.material.MaterialBO;

import java.util.List;

public interface MaterialMapper {
    MaterialBO GetMaterialByName(String material_id);
    List<MaterialBO> GetAllMaterial();
}
