package com.example.token.Mapper;

import com.example.token.Entity.VO.user.UserModuleVO;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ModuleMapper {
    List<UserModuleVO> getUserModuleByUserId(@Param("userid") int userid);
    Boolean insetUserModule(@Param("userid") int userid,@Param("moduleid") int moduleid);
}
