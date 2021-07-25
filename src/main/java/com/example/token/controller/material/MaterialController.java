package com.example.token.controller.material;

import com.example.token.Impl.MaterialServiceImpl;
import com.example.token.Interface.UserLoginToken;
import com.example.token.bean.MaterialDo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/material")
@Api(tags = "物料信息")
public class MaterialController {
    @Autowired
    private MaterialServiceImpl materialService;

    @UserLoginToken
    @GetMapping("/getAllMaterial")
    @ResponseBody
    @ApiOperation("获取物料信息")
    public List<MaterialDo> getAllMaterial(){
        return materialService.GetAllMaterial();
    }

    @UserLoginToken
    @GetMapping("/getAllMaterial/{id}")
    @ResponseBody
    @ApiOperation("获取某个物料信息")
    public MaterialDo getAllMaterialByName(@PathVariable String material_id){
        return materialService.GetMaterialByName(material_id);
    }
}
