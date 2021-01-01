package vishwa.Com.vishwajit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven {
	
	public ArrayList<String> getData( String testcasename ) throws IOException
	{
		ArrayList<String> a=new ArrayList<String>();
		  FileInputStream sheet = new FileInputStream("D:\\Vishwajit\\Book1.xlsx");
		  @SuppressWarnings("resource")
		XSSFWorkbook work = new XSSFWorkbook(sheet);
		     
		  int numsheet=work.getNumberOfSheets();
		  System.out.println("+get the sheets" +numsheet);
		  
		  for (int i=0 ; i<numsheet;i++)
		  {
			 if(work.getSheetName(i).equalsIgnoreCase("Sheet1"))
					 {
				     XSSFSheet sheet1 =  work.getSheetAt(i);
				     
				     Iterator <Row> rows=sheet1.iterator();
				     
				     Row firstrow =rows.next();
				     
				     Iterator<Cell> ce=firstrow.cellIterator();
				    int k=0;
				    int column=0;
				    while(ce.hasNext())
				    {
				    	Cell value=ce.next();
				    	if(value.getStringCellValue().equalsIgnoreCase("Testcase"))
				    	{
				    		column=k;
				    		
				    	}
				    	 k++;	    	
				    
				    }
				    System.out.println(column);
				    
				    while(rows.hasNext())
				    {
				    	Row r= rows.next();
				    	
				    	if(r.getCell(column).getStringCellValue().equalsIgnoreCase("testcasename"))
				    	{
				    	Iterator<Cell> rv=	r.cellIterator();
				    	while(rv.hasNext())
				    	{
				    		Cell c=rv.next();
				    		if (c.getCellTypeEnum()==CellType.STRING)
				    		{
				    			a.add(rv.next().getStringCellValue());
				    		}
				    		
				    		else
				    		{
				    			
				    			a.add(NumberToTextConverter.toText(rv.next().getNumericCellValue()));
				    		

				    		}
				    						    	}
				    	}
				    }
				      return a;
				    
					 }
		  }
		return a;
		     
			}

	


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
}
}