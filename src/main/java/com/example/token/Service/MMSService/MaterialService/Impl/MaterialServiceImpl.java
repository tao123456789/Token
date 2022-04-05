package com.example.token.Service.MMSService.MaterialService.Impl;

import com.example.token.BO.material.MaterialDo;
import com.example.token.Mapper.MaterialMapper;
import com.example.token.Service.MMSService.MaterialService.MaterialService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("MaterialService1")
public class MaterialServiceImpl implements MaterialService {

    @Resource
    MaterialMapper materialMapper;

    @Override
    public MaterialDo GetMaterialByName(String material_id){
        return materialMapper.GetMaterialByName(material_id);
    };

    @Override
    public List<MaterialDo> GetAllMaterial(){
        return materialMapper.GetAllMaterial();
    };
}
