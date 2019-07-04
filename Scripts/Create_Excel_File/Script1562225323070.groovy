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

String excelTestFile02 = '/Users/eiralee/EiraLi-Katalon_API/Reports/TestFile02.xls'
//建立 excel 檔
ExcelKeywords.createExcelFile(excelTestFile02)

//確認 excel 檔是否有被建立
File testfile = new File(excelTestFile02)
assert testfile.exists() == true

//建立 sheet
workbook01 = ExcelKeywords.getWorkbook(excelTestFile02)
ExcelKeywords.createExcelSheets(workbook01, ['GongXi', 'Jungle'])
ExcelKeywords.saveWorkbook(excelTestFile02, workbook01)

//確認 sheet 是否有被建立
String[] SheetCreated01 = ['Sheet0', 'GongXi', 'Jungle']
workbook01 = ExcelKeywords.getWorkbook(excelTestFile02)
assert SheetCreated01 == ExcelKeywords.getSheetNames(workbook01)

//write some date to sheet
GongXi = ExcelKeywords.getExcelSheet(workbook01, 'GongXi')
Map content = new HashMap<>()
content.putAt('A1', 'Name')
content.putAt('B1', 'Balance')
ExcelKeywords.setValueToCellByAddresses(GongXi, content)
ExcelKeywords.saveWorkbook(excelTestFile02, workbook01)

