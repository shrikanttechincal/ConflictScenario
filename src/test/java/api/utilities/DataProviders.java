package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Data")
	public String[][] getdata() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testdata//Userdata.xlsx";
		 ExcelUtils xlutil = new ExcelUtils(path); 

	        int totalrows = xlutil.getrowcount("Sheet1");
	        int totalcols = xlutil.getcellcount("Sheet1", 1);

	        // Created for two-dimensional array which can store data
	        String logindata[][] = new String[totalrows][totalcols]; 

	        // Read the data from xl storing in two-dimensional array
	        for(int i = 1; i <= totalrows; i++) // i is rows
	        { 
	            for(int j = 0; j < totalcols; j++) // j is columns
	            { 
	                logindata[i - 1][j] = xlutil.getcelldata("Sheet1", i, j); // 1,0
	            }
	        }

	        return logindata; // Returning two-dimensional array
	      
	        
	    }
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testdata//Userdata.xlsx";
		 ExcelUtils xlutil = new ExcelUtils(path); 

	        int totalrows = xlutil.getrowcount("Sheet1");
	        //int totalcols = xlutil.getcellcount("Sheet1", 1);
	        // Created for two-dimensional array which can store data
	        String logindata[] = new String[totalrows]; 

	        // Read the data from xl storing in two-dimensional array
	        for(int i = 1; i <= totalrows; i++) // i is rows
	        { 
	            
	                logindata[i - 1] = xlutil.getcelldata("Sheet1", i, 1); // 1,0
	            }
	        return logindata; // Returning two-dimensional array
	    }
	}
