package com.example.token.Service.MMSService.MaterialService;

import com.example.token.BO.material.MaterialDo;

import java.util.List;

public interface MaterialService {
    MaterialDo GetMaterialByName(String material_id);
    List<MaterialDo> GetAllMaterial();
}
