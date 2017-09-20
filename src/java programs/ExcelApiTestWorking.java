package com.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
 
public class ExcelApiTestWorking
{
    public FileInputStream fis = null;
    public static FileOutputStream fos = null;
    public static XSSFWorkbook workbook = null;
    public static XSSFSheet sheet = null;
    public static XSSFRow row = null;
    public static XSSFCell cell = null;
    static String xlFilePath;
    public static DataFormatter df = new DataFormatter();
	private static final String FILE_NAME ="D:\\email.xlsx";
	
	
 
    public ExcelApiTestWorking(String xlFilePath) throws Exception //To check the file available or not
    {
    	try {
    	
        this.xlFilePath = FILE_NAME;
        fis = new FileInputStream(xlFilePath);
        workbook = new XSSFWorkbook(fis);
        fis.close();
    	}
    	
    	catch (FileNotFoundException e)
        {
            System.out.println("File not found"+e);  
           
        }
    	
    	
    }
 
    public static boolean setCellData(String colName, int rowNum, String status) // to set the value to the sheet
    {
        try
        {
            int col_Num =0;
            sheet = workbook.getSheetAt(0);
 
            row = sheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
            	
            	//String text = df.formatCellValue(r.getCell(cn));
            	
            	String t=df.formatCellValue(row.getCell(i));
            	
                if (t.equalsIgnoreCase(colName))
                {
                    col_Num = i;
                    
                    System.out.println("column number of result"+col_Num);

                }
            }
 
          
            row = sheet.getRow(rowNum);
            if(row==null)
                row = sheet.createRow(rowNum);
 
            cell = row.getCell(col_Num);
            if(cell == null)
                cell = row.createCell(col_Num);
 
            cell.setCellValue(status);
 
            fos = new FileOutputStream(xlFilePath);
            workbook.write(fos);
            fos.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return  false;
        }
        return true;
    }
    
    
    
    public static void  readcheck() throws Exception // to read username and password
    {

    	
    	FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        XSSFSheet sheet = workbook.getSheetAt(0);
        
        int rowStart = sheet.getFirstRowNum();
        int rowEnd = sheet.getLastRowNum();
        int d = 0;
        int col=0;
        int crrow=0;
     //   String status="";
        System.out.println("rowstart---"+ rowStart);
        System.out.println("rowend  ---"+rowEnd);
        
        
        for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) 
        {
        	   Row r = sheet.getRow(rowNum);
        	   
        	//   int lastColumn = r.getLastCellNum();
        	 //  System.out.println("last column  ---"+lastColumn);

        	   for (int cn = 0; cn <=rowEnd; cn++) {
        		 
        	      Cell c = r.getCell(cn, Row.RETURN_BLANK_AS_NULL);
        	      if (c == null) 
        	      {
        	         // The spreadsheet is empty in this cell
        	      } else {
        	    	  
        	    	 // String text = formatter.formatCellValue(c);
                     // System.out.println(text);
        	         // Do something useful with the cell's contents
        	    	  
        	    	  String text = df.formatCellValue(r.getCell(cn));
        	    	  System.out.println(text+"---from data formatter");
        	    	  
        	    	  if(text.equalsIgnoreCase("username"))
                      
                    //  if(r.getCell(cn).getStringCellValue().trim().equalsIgnoreCase("username"))
                  	{  
                    	  System.out.println("if loop working");
                    	  
                    	  //r.getCell(cn).getRow();                    	  
                    	 
                    	  
                    	 d=r.getCell(cn).getRowIndex();
                    	 
                    	 col=r.getCell(cn).getColumnIndex();
                    	 
                    	//getRowIndex());	  
                    	 System.out.println("the d row index value row  "+d);	 
                    	 //getColumnIndex());
                    	 System.out.println("the col columnindex value col  "+col);	
                  	}
                  	
        	       }
        	   }
        }
        
        
        
        // to read the values from the excel sheet.
        
        for(int x=(d+1); x<=rowEnd;x++)
        {
        
        //	String text = df.formatCellValue(sheet.getRow(x).getCell(col));
        	
        	 
        	
        // to get user name	
        String st= df.formatCellValue(sheet.getRow(x).getCell(col));  // the row value for row 

        System.out.println("The excel values in column"+col+"----"+st);
        // to get password     
        String st1= df.formatCellValue(sheet.getRow(x).getCell((col+1)));
        System.out.println("The excel values in column"+(col+1)+"----"+st1);
        
        
        // to get the column value to print result for corresponding row ((col+2)) and send to method
        /* code for login and logout
       
         */

        // search result tab in d row =o
        //col+2  set the status.
        
        
        
        crrow=x;// pointing to the result cell of 1,2,3,
        
        String s="logical prob"+(x);
        
        System.out.println("The value of current row to send to setdata method    "+x);
        
        setCellData("Result",crrow,s);
        
        }
   
    }
    
    
     
    
    
	public static void main(String args[]) throws Exception
    {
        ExcelApiTestWorking red = new ExcelApiTestWorking(FILE_NAME);
        
     //red.setCellData("Result",3,"10.10.2017");
        
      //red.setCellDatamy("ben","Result",5,"check99");
       
       String workdir = System.getProperty("user.dir");
       
       System.out.println("the current working directory   "+workdir);
       
      readcheck();
    }
}