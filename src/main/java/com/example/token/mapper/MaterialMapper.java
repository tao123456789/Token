package com.example.token.mapper;

import com.example.token.BO.material.MaterialDo;

import java.util.List;

public interface MaterialMapper {
    MaterialDo GetMaterialByName(String material_id);
    List<MaterialDo> GetAllMaterial();
}
