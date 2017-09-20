package com.excel;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

public class ApachePOIExcelRead {
	
	private static final String FILE_NAME = "D:\\email.xlsx";
	private static Object XSSFRow;
	private static Object XSSFCell;
	
	public static void readXLSXFile() throws IOException
	{

        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();
            
            XSSFRow row=null;
            XSSFCell cell =null;
            int col =-1;
            
            row= sheet.getRow(0);
            
            for(int i=0;i<row.getLastCellNum();i++)
            {
            	
            	if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase("result"))
            	{
            		
            		col=i;
            		
            		System.out.println("the column numner is result  "+col);
            		
            		
            		System.out.println("Total number of column in excel  "+row.getLastCellNum());
            	}
            	
            }
            row= sheet.getRow(1);                 // points to first row
            if(row==null)                        // to check is row is available
            	row=sheet.createRow(1);          // if row not available create a row for best practice
            
            //  creating the cell and writing the value to the cell
            cell=row.getCell(col);
            if(cell==null)
            	cell=row.createCell(col);
            cell.setCellValue("pass");
            
            FileOutputStream  fos = new FileOutputStream(FILE_NAME);
            workbook.write(fos);
            fos.close();
            
            
          /*  
            Sheet sheet1 = workbook.getSheetAt(0);
            for (Row row : sheet1) {
                for (Cell cell : row) {
                	
                    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                    
                    System.out.print(cellRef.formatAsString());
                    System.out.print(" - ");

                    // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
                    String text = formatter.formatCellValue(cell);
                    System.out.println(text);
                }}
            
            
            
            
            
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
           
                while (cellIterator.hasNext()) {
                	
                    Cell currentCell = cellIterator.next();
                    String text1 = formatter.formatCellValue(currentCell);
                    System.out.println(text1);
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                   // if (currentCell.getCellTypeEnum() == CellType.STRING) {
                  //      System.out.print(currentCell.getStringCellValue() + " \t ");
                  //  } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                   //     System.out.print(currentCell.getNumericCellValue() + "  ");
                   // }

                }
                System.out.println();*/

            
            
            
            //excelFile.close();
        }
                
         catch (FileNotFoundException e) {
        	
        	System.out.print(e);
           // e.printStackTrace();
        } catch (IOException e) {
        	System.out.print(e);
           // e.printStackTrace();
        }

    }
	
	public static void writeXLSXFile() throws IOException
	{
		
		
		
		
	}
	
	
	
	
	
	

    public static void main(String[] args) throws IOException {
    	
    	readXLSXFile();
    	writeXLSXFile();

    	
    	
    }
}