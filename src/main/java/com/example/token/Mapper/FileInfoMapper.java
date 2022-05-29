package com.example.token.Mapper;

import com.example.token.Entity.BO.netdisk.FileInfoBO;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface FileInfoMapper{
    List<FileInfoBO> getFileList(@Param("userid") int userid,@Param("url") String url);
    Boolean insertFileInfo(FileInfoBO fileInfoBO);
}
