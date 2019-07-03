import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import java.io.File as File
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords

/**
 * Example for interact with excel using custom keywords
 *  Scenarios:
 *  - Create two files: File01.xlsx, File02.xlsx
 *  - Add some content to file File01
 *  - Read data from file File01, then set these values to File02
 *  - Compare File01 with File02 (cell, row, sheet, file)
 *  - Clean up data (delete all files)
 */

//檔案路徑


String excelTestFile01 = '/Users/eiralee/EiraLi-Katalon_API/Reports/TestFile01.xls'

//建立 excel 檔
ExcelKeywords.createExcelFile(excelTestFile01)

//確認 excel 檔是否有被建立
File testfile = new File(excelTestFile01)
assert testfile.exists() == true

//建立 sheet
workbook01 = ExcelKeywords.getWorkbook(excelTestFile01)
ExcelKeywords.createExcelSheets(workbook01, ['Fruits', 'Veg'])
ExcelKeywords.saveWorkbook(excelTestFile01, workbook01)

//確認 sheet 是否有被建立
String[] SheetCreated01 = ['Sheet0', 'Fruits', 'Veg']
workbook01 = ExcelKeywords.getWorkbook(excelTestFile01)
assert SheetCreated01 == ExcelKeywords.getSheetNames(workbook01)

//write some date to sheet
Fruits = ExcelKeywords.getExcelSheet(workbook01, 'Fruits')
paragraph = "This is a test. \n" + 'Automation for Katalon. \n'
Map content = new HashMap<>()
content.putAt('A1', 'Name')
content.putAt('B1', 'Price')
content.putAt('C1', 'Quantity')
content.putAt('A2', 'Apple')
content.putAt('B2', 10)
content.putAt('C2', 1)
content.putAt('A3', 'Banana')
content.putAt('B3', 5)
content.putAt('C3', 1)
content.putAt('A6', paragraph)
ExcelKeywords.setValueToCellByAddresses(Fruits, content)
ExcelKeywords.saveWorkbook(excelTestFile01, workbook01)

//建立第二個 excel file
String excelTestFile02 = '/Users/eiralee/EiraLi-Katalon_API/Reports/TestFile02.xls'
ExcelKeywords.createExcelFile(excelTestFile02)
File testfile02 = new File(excelTestFile02)
assert testfile02.exists() == true

workbook02 = ExcelKeywords.getWorkbook(excelTestFile02)
ExcelKeywords.createExcelSheets(workbook02, ['Sports', 'Spots'])
ExcelKeywords.saveWorkbook(excelTestFile02, workbook02)

String[] SheetCreated02 = ['Sheet0','Sports', 'Spots']
workbook02  = ExcelKeywords.getWorkbook(excelTestFile02)
assert SheetCreated02 == ExcelKeywords.getSheetNames(workbook02)

//Read data from File01 and copy to File02
workbook01 = ExcelKeywords.getWorkbook(excelTestFile01)
workbook02 = ExcelKeywords.getWorkbook(excelTestFile02)
Fruits = ExcelKeywords.getExcelSheet(workbook01, 'Fruits')
Sports = ExcelKeywords.getExcelSheet(workbook02, 'Sports')

//copy certain cell A1,B1,C1
A1_01 = ExcelKeywords.getCellByAddress(Fruits, 'A1')
B1_01 = ExcelKeywords.getCellByAddress(Fruits, 'B1')
C1_01 = ExcelKeywords.getCellByAddress(Fruits, 'C1')


Map content02 = new HashMap<>()
content02.putAt("A1", A1_01)
content02.putAt("B1", B1_01)
content02.putAt("C1", C1_01)
ExcelKeywords.setValueToCellByAddresses(Sports, content02)
ExcelKeywords.saveWorkbook(excelTestFile02, workbook02)

A1 = ExcelKeywords.getCellByAddress(Sports, 'A1')
B1 = ExcelKeywords.getCellByAddress(Sports, 'B1')
C1 = ExcelKeywords.getCellByAddress(Sports, 'C1')

//compare cells of File01sheet01 & File02sheet01
compareA1_result = ExcelKeywords.compareTwoCells(A1_01, B1)
println(compareA1_result)
println(A1_01)
println(B1)

compareA1_result1 = ExcelKeywords.compareTwoCells(A1_01, A1)
println(compareA1_result1)
println(A1_01)
println(A1)

//compare rows
for (int i  = 0; i < 2; i++){
	row_01 = Fruits.getRow(i)
	row_02 = Sports.getRow(i)
	CompareRow_result = ExcelKeywords.compareTwoRows(row_01, row_02)
	println("Compare row "+ i +" of File01Sheet01 and File02Sheet01 is: " + CompareRow_result)
}


//compare sheets
CompareSheet_result = ExcelKeywords.compareTwoSheets(Fruits, Sports)
println("Result of compare sheet01 of File01Sheet01 and File02Sheet01 is: " + CompareSheet_result)

//compare workbook
CompareFile_result = ExcelKeywords.compareTwoExcels(workbook01, workbook02)
println("Result of compare File01 and File02 is: " + CompareFile_result)
