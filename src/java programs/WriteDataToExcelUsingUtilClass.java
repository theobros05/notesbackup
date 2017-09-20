package com.excel;



import com.excel.ExcelApiTest;

public class WriteDataToExcelUsingUtilClass
{
    public static void main(String args[]) throws Exception
    {
        ExcelApiTest eat = new ExcelApiTest("D:\\email.xlsx");
        eat.setCellData("ben","comment",3,"hai buddy");
    }
}