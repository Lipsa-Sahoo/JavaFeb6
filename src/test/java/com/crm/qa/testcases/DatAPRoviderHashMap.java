package com.crm.qa.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DatAPRoviderHashMap {
@Test(dataProvider = "data")
  public void ReadingFromXLSTest(Map<Object, Object> map) {
    System.out.println("-------------Test case started ----------------");
    System.out.println(map.get("firstname"));
    System.out.println(map.get("lastname"));
    System.out.println(map.get("company"));

    System.out.println("-------------Test case Ended ----------------");

  }

@DataProvider(name = "data")
public Object[][] dataSupplier() throws IOException {

  File file = new File("C:\\Users\\lisahoo\\git\\JavaFeb6\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx");
  FileInputStream fis = new FileInputStream(file);

  XSSFWorkbook wb = new XSSFWorkbook(fis);
  XSSFSheet sheet = wb.getSheetAt(0);
  
  int lastRowNum = sheet.getLastRowNum() ;
  int lastCellNum = sheet.getRow(0).getLastCellNum();
  Object[][] obj = new Object[lastRowNum][1];

  for (int i = 0; i < lastRowNum; i++) {
    Map<Object, Object> datamap = new HashMap<Object, Object>();
    for (int j = 0; j < lastCellNum; j++) {
      datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
    }
    obj[i][0] = datamap;

  }
  return  obj;
}
}
