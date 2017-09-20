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
 
public class ExcelApiTest
{
    public FileInputStream fis = null;
    public FileOutputStream fos = null;
    public static XSSFWorkbook workbook = null;
    public static XSSFSheet sheet = null;
    public static XSSFRow row = null;
    public static XSSFCell cell = null;
    String xlFilePath;
	private static final String FILE_NAME ="D:\\email1.xlsx";
	
	
 
    public ExcelApiTest(String xlFilePath) throws Exception
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
 
    public boolean setCellData(String sheetName, String colName, int rowNum, String value)
    {
        try
        {
            int col_Num = -1;
            sheet = workbook.getSheet(sheetName);
 
            row = sheet.getRow(0);
            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equals(colName))
                {
                    col_Num = i;
                }
            }
 
            sheet.autoSizeColumn(col_Num);
            row = sheet.getRow(rowNum - 1);
            if(row==null)
                row = sheet.createRow(rowNum - 1);
 
            cell = row.getCell(col_Num);
            if(cell == null)
                cell = row.createCell(col_Num);
 
            cell.setCellValue(value);
 
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
    
    public static void readXLSXFile() throws IOException
   	{
    	
    	
    	FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        XSSFSheet sheet = workbook.getSheetAt(0);
        DataFormatter df = new DataFormatter();
        
        
        
        
        try
        {
            int colnum = 0;
         
 
            row = sheet.getRow(0);
            
            // to print total number of colnms
            System.out.println("Total number of column in excel  "+row.getLastCellNum());
            
            for(int i = 0; i < row.getLastCellNum(); i++)
            {
            	
            	if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase("Username"))
            	{
            		
            		colnum=i;
            		
            		
            		// to literally assign the row number of the colunm number.
                        		
            		System.out.println("the column numner of username for user identification  "+(colnum+1));
            	
            	 }
            }  	
 
            int row = sheet.getLastRowNum();
            
    		

            
            for(int i=1; i<=row; i++)
            {
            	// fetch the data
            	
            }
    
           
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            
        }
        
        
      /*  
        
       
    	row= sheet.getRow(0);
    	 int u=row.getLastCellNum();
    	
    	int colnum=0;
    	
    	int rowd = sheet.getLastRowNum();
    	System.out.println("Total number of columns  "+rowd);
    	
    	// to get total number of rows in the sheet
    	 int s= sheet.getPhysicalNumberOfRows();
    	System.out.println("Total number of rows in the row 0 that is header  "+u);
    	
    	
    	
       
        
        for(int i = 0; i < row.getLastCellNum(); i++)
        {
        	
        	if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase("result"))
        	{
        		
        		colnum=i;
        		
        		
        		// to literally assign the row number of the colunm number.
        		//rownumber++;
        		
        		System.out.println("the column numner of username for user identification  "+colnum);
        		
          		System.out.println("Total number of column in excel  "+row.getLastCellNum());
        	 }
        }  	
          		
          for( int j=0;j<s;j++)		
          {
        	  
        	  cell = row.getCell(j);
        	System.out.println("The value in the cell   "+cell);
        	  
        	//  CellReference cellRef = new CellReference(j.getRowNum(), cell.getColumnIndex());
        	 // String text = formatter.formatCellValue(cell);
             // System.out.println(text);*/
        	  
          
          
          	
  	}//readxl file close 
    
    public static void  readcheck() throws Exception //working
    {

    	
    	FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        XSSFSheet sheet = workbook.getSheetAt(0);
        DataFormatter df = new DataFormatter();
        
        int rowStart = sheet.getFirstRowNum();
        int rowEnd = sheet.getLastRowNum();
        int d = 0;
        int col=0;
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

        System.out.println("The excel values username----"+st);
        // to get password     
        String st1= df.formatCellValue(sheet.getRow(x).getCell((col+1)));
        System.out.println("The excel values in password----"+st1);
        
        
        // to get the column value to print result for corresponding row ((col+2)) and send to method
        /* code for login and logout
       
         */

        // search result tab in d row =o
        //col+2  print status=
        
      
        
        }
   
    }
    
    
    public boolean setCellDatamy(String sheetName, String colName, int rowNum, String value)
    {
    	
    	 //red.setCellDatamy("ben","Result",4,"check"); 
    	int d = 0;
        int col=0;
    	int col_Num = 0;
    	sheet = workbook.getSheet(sheetName);
    	int rowStart = sheet.getFirstRowNum();
        int rowEnd = sheet.getLastRowNum();
        DataFormatter df = new DataFormatter();

        System.out.println("rowstart---"+ rowStart);
        System.out.println("rowend  ---"+rowEnd);
        
      // String c=null;
        try
        {
        	 for (int rowNum1 = rowStart; rowNum < rowEnd; rowNum++) 
             {
             	   Row r = sheet.getRow(rowNum);
             	   
           // 	int lastColumn =  r.getLastCellNum();// to get physical number of columns
           	//   System.out.println("last column  ---"+lastColumn);
             	             		 
             		 
               	   for (int cn = 0; cn <rowEnd; cn++) 
               	   
               	   {  
               		   
               		// cell=  (XSSFCell) r.getCell(cn);
               		
               		//String cd=df.formatCellValue(r.getCell(cn));
               		
               	      Cell c = r.getCell(cn, Row.RETURN_NULL_AND_BLANK);
               	      
               	   System.out.println(c+"  the value from cell");
               	      
               	      if (cell != null) 
               	      {
               	         // The spreadsheet is empty in this cell
                       	  System.out.println("c is null");

               	      } 
               	      else 
               	      {
               	    	  String text = df.formatCellValue(r.getCell(cn));
               	    	  System.out.println(text);
               	    	  
               	    	  if(text.equalsIgnoreCase("colName")) // to check the result column
                         	{  
                           	  System.out.println("if loop working");
                           	  
                           	 // set the value to the cell         	  
                           	row = sheet.getRow(rowNum);
                            if(row==null)
                                row = sheet.createRow(rowNum);
                        
                            cell = row.getCell(col_Num);
                            if(cell == null)
                                cell = row.createCell(col_Num);
                 
                            cell.setCellValue(value);
                           	  
                           	 
                         	}
               	    	  }
               	      } 
             	 }
                                    
 
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
    
    
    
    
	public static void main(String args[]) throws Exception
    {
        ExcelApiTest red = new ExcelApiTest(FILE_NAME);
        
     //red.setCellData("ben","Result",13,"8.10.2017");
        
      red.setCellDatamy("ben","Result",5,"check99");
       
       String workdir = System.getProperty("user.dir");
       
       System.out.println("the current working directory   "+workdir);
       
       
        
       readXLSXFile();
        
      readcheck();
    }
}