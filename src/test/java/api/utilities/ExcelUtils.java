package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	String path;

	public ExcelUtils(String path)
	{
		this.path=path;
	}

	public int getrowcount(String sheetname) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheetname);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}

	public int getcellcount(String sheetname,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheetname);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}

	public String getcelldata(String sheetname,int rownum ,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheetname);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);

		String data;
		
		try {
			data=cell.toString();
			//DataFormatter formatter=new DataFormatter();
			//data=formatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}

	public static void setcelldata(String sheetname,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(sheetname);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheetname);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(sheetname);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}
}

