package com.example.token.Api.MMS.Material;

import com.example.token.Entity.BO.material.MaterialBO;
import com.example.token.Utils.file.ImportServiceImpl;
import com.example.token.Config.Interface.UserLoginToken;
import com.example.token.Service.MMSService.MaterialService.MaterialService;
import com.example.token.Utils.file.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("MaterialService1")
    private MaterialService materialService;

    @Autowired
    private ImportServiceImpl importService;

    @Autowired
    private FileUtil fileService;

    @UserLoginToken
    @GetMapping("/getAllMaterial")
    @ResponseBody
    @ApiOperation("获取物料信息")
    public List<MaterialBO> getAllMaterial(){
        return materialService.GetAllMaterial();
    }

    @UserLoginToken
    @GetMapping("/getAllMaterial/{id}")
    @ResponseBody
    @ApiOperation("获取某个物料信息")
    public MaterialBO getAllMaterialByName(@PathVariable String material_id){
        return materialService.GetMaterialByName(material_id);
    }

    @PostMapping("/uploadFile")
    @ApiOperation("上传文件")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws Exception{
        if(file.isEmpty()){
            return "文件名不能为空";
        }
        InputStream inputStream=file.getInputStream();
        log.info("stream:"+inputStream);
        fileService.uploadFile(file,"/user/data/upload");
        try {
            List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
            inputStream.close();
        }catch (Exception e){
            log.info(String.valueOf(e));
        }
        return "上传成功！";
    }
}
