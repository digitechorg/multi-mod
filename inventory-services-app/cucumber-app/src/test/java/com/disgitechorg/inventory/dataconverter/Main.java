package com.disgitechorg.inventory.dataconverter;

import io.cucumber.datatable.DataTable;

import java.util.List;

public class Main {

    public void DatatableTest(String file, DataTable dataTable){
        List<FileTransferDataTable> fileTransferDataTableList = dataTable.asList(FileTransferDataTable.class);
        for(FileTransferDataTable fileTransferDataTableLists : fileTransferDataTableList){
            String src = fileTransferDataTableList.get(0).getFileSourceLocation();
            String tar = fileTransferDataTableList.get(0).getFileTargetLocation();
            Boolean isExist = fileTransferDataTableList.get(0).isDontSentFile();

        }
    }
}
