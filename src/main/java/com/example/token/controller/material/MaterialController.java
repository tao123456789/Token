package com.example.token.controller.material;

import com.example.token.Impl.ImportServiceImpl;
import com.example.token.Impl.MaterialServiceImpl;
import com.example.token.Interface.UserLoginToken;
import com.example.token.bean.MaterialDo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/material")
@Api(tags = "物料信息")
public class MaterialController {
    @Autowired
    private MaterialServiceImpl materialService;

    @Autowired
    private ImportServiceImpl importService;

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

    @PostMapping("/uploadFile")
    @ApiOperation("上传文件")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws Exception{
        String fileName=file.getOriginalFilename();
        log.info("文件名称："+fileName);
        log.info("文件大小："+file.getSize());
        if(file.isEmpty()){
            return "文件名不能为空";
        }
        InputStream inputStream=file.getInputStream();
        log.info("stream:"+inputStream);
        try {
            List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
            inputStream.close();
        }catch (Exception e){
            log.info(String.valueOf(e));
        }
        return "上传成功！";
    }
}
