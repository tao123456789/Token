package com.example.token.Mapper;

import com.example.token.Entity.BO.module.ModuleBO;
import com.example.token.Entity.VO.user.UserModuleVO;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ModuleMapper {
    List<UserModuleVO> getUserModuleByUserId(@Param("userid") int userid);
    Boolean insertUserModule (@Param("userid") int userid, @Param("moduleid") int moduleid);
    Boolean removeModuleByID(@Param("id") int id);
    List<ModuleBO> getAllModuleList();
}
