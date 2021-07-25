package com.example.token.service;

import com.example.token.bean.MaterialDo;

import java.util.List;

public interface MaterialService {
    MaterialDo GetMaterialByName(String material_id);
    List<MaterialDo> GetAllMaterial();
}
