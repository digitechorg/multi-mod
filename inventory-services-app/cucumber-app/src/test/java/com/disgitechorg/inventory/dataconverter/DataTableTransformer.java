package com.disgitechorg.inventory.dataconverter;

import io.cucumber.java.DataTableType;

import java.util.Locale;
import java.util.Map;

public class DataTableTransformer {

    public Locale locale(){
        return Locale.ENGLISH;
    }

    @DataTableType
    public FileTransferDataTable defineFileTransferDataTable(Map<String,String> row){
        FileTransferDataTable fileTransferDataTable = new FileTransferDataTable(
                row.get("fileSourceLocation"),
                row.get("fileTargetLocation"),
              Boolean.valueOf(row.get("dontSentFile"))
        );
        return fileTransferDataTable;
    }
}
