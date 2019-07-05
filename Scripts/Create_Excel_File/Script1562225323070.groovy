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
import net.bytebuddy.implementation.bytecode.constant.NullConstant as NullConstant
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import groovy.json.JsonSlurper
//below for exporting to excel
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


KeywordLogger log = new KeywordLogger()

String excelTestFile01 = '/Users/eiralee/EiraLi-Katalon_API/Reports/TestFile01.xls'
//建立 excel 檔
ExcelKeywords.createExcelFile(excelTestFile01)

//確認 excel 檔是否有被建立
File testfile = new File(excelTestFile01)
assert testfile.exists() == true

//建立 sheet
workbook01 = ExcelKeywords.getWorkbook(excelTestFile01)
ExcelKeywords.createExcelSheets(workbook01, ['Sheet1', 'Sheet2'])
ExcelKeywords.saveWorkbook(excelTestFile01, workbook01)

//確認 sheet 是否有被建立
String[] SheetCreated01 = ['Sheet0', 'Sheet1', 'Sheet2']
workbook01 = ExcelKeywords.getWorkbook(excelTestFile01)
assert SheetCreated01 == ExcelKeywords.getSheetNames(workbook01)

//write some date to sheet1
Sheet1 = ExcelKeywords.getExcelSheet(workbook01, 'Sheet1')
Map content = new HashMap<>()
content.putAt('A1', 'Balance')
content.putAt('B1', 'transaction_id')
ExcelKeywords.setValueToCellByAddresses(Sheet1, content)
ExcelKeywords.saveWorkbook(excelTestFile01, workbook01)

//write some date to sheet2
Sheet2 = ExcelKeywords.getExcelSheet(workbook01, 'Sheet2')
Map content1 = new HashMap<>()
content1.putAt('A1', 'Balance')
content1.putAt('B1', 'transaction_id')
ExcelKeywords.setValueToCellByAddresses(Sheet2, content1)
ExcelKeywords.saveWorkbook(excelTestFile01, workbook01)

