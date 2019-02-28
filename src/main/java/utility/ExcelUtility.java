package utility;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.*;

public class ExcelUtility {

	// Create a HashMap which will store keys and values
    // from xls file provided
    //  HashMap< String, String > propertiesData = new HashMap< String, String >();

    HashMap<String, List<String>> propertiesData = new HashMap<String, List<String>>();
    String[][] inputData;
    
	    
	public void readExcelFile(String fileName) throws IOException, InvalidFormatException {
        String dataProvider = fileName;
        File file = new File(System.getProperty("user.dir") + dataProvider);
        Workbook workbook = WorkbookFactory.create(file);
        workbook.getNumberOfSheets();
        String[] sheetList= null;
        
        if (System.getProperty("platform").equalsIgnoreCase("ios"))	{
          sheetList = new String[]{"ios"};}
        
        else if (System.getProperty("platform").equalsIgnoreCase("android"))	{
         sheetList = new String[]{"android"};}
        
        Sheet sheet;
        Iterator<Row> rowIterator;
        DataFormatter dataFormatter = new DataFormatter();


        List<String> list = new ArrayList<String>();
        List<String> tempHeaderList = new ArrayList();
        List<String> tempcellValues = new ArrayList();
        List<String> headerList = new ArrayList();

        int temp = 0;

		for (int i = 0; i < sheetList.length; i++) {
            sheet = workbook.getSheet(sheetList[i]);
            rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                if (row.getCell(0) == null) {
                    break;
                }
                temp = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    list.add(dataFormatter.formatCellValue(cell));
                    temp = temp + 1;
                }
                System.out.println();
            }
            for (int j = 0; j < temp; j++) {
                tempHeaderList.add(list.get(j));
                headerList.add(list.get(j));
            }
            for (int j = 0; j < list.size() - temp; j++) {
                tempcellValues.add(list.get(temp + j));
            }
            list.removeAll(list);

            for (int j = 0; j < tempHeaderList.size(); j++) {
                int count = tempcellValues.size() / tempHeaderList.size();
                List values = new ArrayList();
                temp = j;
                for (int k = 0; k < count; k++) {
                    values.add(tempcellValues.get(temp));
                    temp = temp + tempHeaderList.size();
                }
                propertiesData.put(String.valueOf(tempHeaderList.get(j)), values);
                System.out.println();
            }
            tempcellValues.removeAll(tempcellValues);
            tempHeaderList.removeAll(tempHeaderList);
        }

        System.out.println(propertiesData);

        inputData = new String[propertiesData.get("deviceName").size() + 1][propertiesData.keySet().size()];
        //   List<String> set = new ArrayList(propertiesData.keySet());
        for (int i = 0; i < inputData.length; i++) {
            if (i == 0) {
                for (int j = 0; j < headerList.size(); j++) {
                    inputData[i][j] = headerList.get(j);
                }
            } else {
                for (int j = 0; j < propertiesData.size(); j++) {
                    inputData[i][j] = propertiesData.get(headerList.get(j)).get(i - 1);
                }
            }

            System.out.println(inputData);
        }
        
        
        
        
    }

    public void writeToPropertiesFile() throws IOException {

        // Creating a new Properties object
        Properties props = new Properties();
        String dir= " ";
        
        if (System.getProperty("platform").equalsIgnoreCase("ios"))	{
            dir = "/Config/iOS/" ;}
          
          else if (System.getProperty("platform").equalsIgnoreCase("android"))	{
        	  dir = "/Config/Android/" ;} 
        
        // Creating a File object which will point to location of
        // propertiesData file
        for (int i = 1; i < inputData.length; i++) {
        	System.out.println(inputData[i][1]);
        	if (inputData[i][0].equalsIgnoreCase("Y")) {
            File propertiesFile = new File(System.getProperty("user.dir")+dir+inputData[i][2]);
            FileOutputStream xlsFos = new FileOutputStream(propertiesFile);
            for (int j = 0; j < inputData[0].length; j++) {

                props.setProperty(inputData[0][j], inputData[i][j]);

            }
           
            { props.store(xlsFos, null);}
        	}
        }
    }
}
