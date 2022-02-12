package com.example.token.Service.MMSService;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.InputStream;
import java.util.List;

public interface ImportService {
    List getBankListByExcel(InputStream in, String fileName) throws Exception;

    Workbook getWorkbook(InputStream inStr, String fileName) throws Exception;
}
