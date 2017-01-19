package genericfunction;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

public class GetConfig {

	private static File confile;
	private static FileInputStream inputstream;
	private static Workbook conworkbook;
	private static Sheet consheet;
	private static Row rowname;

	private static String conFilePath = "D:\\seleniumFile\\";
	private static String conFileName = "Config.xlsx";
	private static String confSheetName = "ConfigData";
	private static String value = null;



	private static String getData(String key) 
	{
		try 
		{
			confile = new File(conFilePath+conFileName);
			inputstream = new FileInputStream(confile);
			conworkbook = new XSSFWorkbook(inputstream);
			consheet = conworkbook.getSheet(confSheetName);

			int rowCount = consheet.getLastRowNum()-consheet.getFirstRowNum();

			for(int i=0; i<rowCount+1; i++)
			{
				Row row = consheet.getRow(i);
				if(row.getCell(0).getStringCellValue().equals(key))
				{
					value = row.getCell(1).getStringCellValue();
					break;
				}
			}

		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not read the excel File");

			e.printStackTrace();
		}
		catch (IOException e)
		{	 
			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}
		return value;

	}
	
	
	public static String getTestFilePath() throws Exception
	{
		String filePath = getData("FilePath");
		
		return filePath;
	}
	
	public static String getTestFileName() throws Exception
	{
		String fileName = getData("FileName");
		
		return fileName;
	}
	
	



}
