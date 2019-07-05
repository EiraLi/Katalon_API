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
ExcelKeywords.createExcelSheets(workbook01, ['GongXi', 'Jungle'])
ExcelKeywords.saveWorkbook(excelTestFile01, workbook01)

//確認 sheet 是否有被建立
String[] SheetCreated01 = ['Sheet0', 'GongXi', 'Jungle']
workbook01 = ExcelKeywords.getWorkbook(excelTestFile01)
assert SheetCreated01 == ExcelKeywords.getSheetNames(workbook01)

//write some date to sheet
GongXi = ExcelKeywords.getExcelSheet(workbook01, 'GongXi')
Map content = new HashMap<>()
content.putAt('A1', 'Name')
content.putAt('B1', 'Balance')
ExcelKeywords.setValueToCellByAddresses(GongXi, content)
ExcelKeywords.saveWorkbook(excelTestFile01, workbook01)


WS.sendRequestAndVerify(findTestObject('Wallet/Get_Session_Token', [('url') : 'krug-gw-colo.star9ad.com', ('partner') : 'c304afdf-2f61-6369-c088-924f99e1be1a'
            , ('secretkey') : '418184e911563cd861e90db6233d7d6c', ('userid1') : 'eira_bbin_0001'
            , ('session_token') : GlobalVariable.session_token]))

WS.sendRequestAndVerify(findTestObject('NuRGS/Login_Final', [('url') : 'nurgs.star9ad.com', ('partner') : 'c304afdf-2f61-6369-c088-924f99e1be1a'
            , ('session_token') : GlobalVariable.session_token, ('game_code') : 'NG-0063']))



for (int i = 1; i <= 3; i++) {
	def features = GlobalVariable.features
	
	def features_type = GlobalVariable.features_type
	
	def free_spin_pick = GlobalVariable.free_spin_pick
	
	def free_spin_complete = GlobalVariable.free_spin_complete
	
	def free_spin_left = GlobalVariable.free_spin_left
	
	def balance = GlobalVariable.balance
    
	if (features == null) {
        spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_Base_spin', [('url') : 'nurgs.star9ad.com'
                    , ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code
                    , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('state_tag') : GlobalVariable.state_tag]))
    } else if ((features != null) && 'PICK'.equals(features_type)) {
        if (free_spin_pick != true) {
            spin_result = WS.sendRequestAndVerify(findTestObject('Object Repository/NuRGS/Take turn_pick'))
        } else if (free_spin_pick == true) {
            if (free_spin_complete == true) {
                spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_Base_spin', [('url') : 'nurgs.star9ad.com'
                            , ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code
                            , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('state_tag') : GlobalVariable.state_tag]))
            } else if (free_spin_complete != true) {
                spin_result = WS.sendRequestAndVerify(findTestObject('Object Repository/NuRGS/Take turn_free_spin_left'))
            }
        }
    } else if ((features != null) && ('FREE_SPIN'.equals(features_type)) && (free_spin_complete != true)) {
        spin_result = WS.sendRequestAndVerify(findTestObject('Object Repository/NuRGS/Take turn_free_spin_left'))
    } else ((features != null) && ('FREE_SPIN'.equals(features_type)) && (free_spin_complete == true)){ 
                spin_result = WS.sendRequestAndVerify(findTestObject('Object Repository/NuRGS/Take turn_Base_spin'))
            }
	
	log.logInfo(balance.toPlainString())
	balance_value = balance.toPlainString()
	ExcelKeywords.setValueToCellByIndex(GongXi, 0+i, 1, balance_value)
	
	}




ExcelKeywords.setValueToCellByAddresses(GongXi, content)
ExcelKeywords.saveWorkbook(excelTestFile01, workbook01)

