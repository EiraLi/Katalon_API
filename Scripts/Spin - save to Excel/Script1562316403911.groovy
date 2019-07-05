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

Map content = new HashMap()

content.putAt('A1', 'Balance')

content.putAt('B1', 'transaction_id')

ExcelKeywords.setValueToCellByAddresses(Sheet1, content)

ExcelKeywords.saveWorkbook(excelTestFile01, workbook01)

def spin_balance_result = ''

for (int i = 1; i <= 5; i++) {
    def features = GlobalVariable.features

    def features_type = GlobalVariable.features_type

    def free_spin_pick = GlobalVariable.free_spin_pick

    def free_spin_complete = GlobalVariable.free_spin_complete

    def free_spin_left = GlobalVariable.free_spin_left

    def balance = GlobalVariable.balance

    def round_id = GlobalVariable.round_id

    def transaction_id = GlobalVariable.transaction_id

    if (features == null) {
        spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_Base_spin', [('url_nurgs') : url_nurgs, ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code
                    , ('game_code') : GlobalVariable.game_code, ('rgs_session_token') : GlobalVariable.rgs_session_token
                    , ('state_tag') : GlobalVariable.state_tag]))
    } else if ((features != null) && 'PICK'.equals(features_type)) {
        if (free_spin_pick != true) {
            spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_pick', [('url_nurgs') : url_nurgs, ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code
                        , ('game_code') : GlobalVariable.game_code, ('rgs_session_token') : GlobalVariable.rgs_session_token
                        , ('state_tag') : GlobalVariable.state_tag, ('choice') : choice]))
        } else if (free_spin_pick == true) {
            if (free_spin_complete == true) {
                spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_Base_spin', [('url_nurgs') : url_nurgs, ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code
                            , ('game_code') : GlobalVariable.game_code, ('rgs_session_token') : GlobalVariable.rgs_session_token
                            , ('state_tag') : GlobalVariable.state_tag]))
            } else if (free_spin_complete != true) {
                spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_free_spin_left', [('url_nurgs') : url_nurgs, ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code
                            , ('game_code') : GlobalVariable.game_code, ('rgs_session_token') : GlobalVariable.rgs_session_token
                            , ('state_tag') : GlobalVariable.state_tag]))
            }
        }
    } else if (((features != null) && 'FREE_SPIN'.equals(features_type)) && (free_spin_complete != true)) {
        spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_free_spin_left', [('url_nurgs') : url_nurgs, ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code
                    , ('game_code') : GlobalVariable.game_code, ('rgs_session_token') : GlobalVariable.rgs_session_token
                    , ('state_tag') : GlobalVariable.state_tag]))
    } else if (((features != null) && 'FREE_SPIN'.equals(features_type)) && (free_spin_complete == true)) {
        spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_Base_spin', [('url_nurgs') : url_nurgs, ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code
                    , ('game_code') : GlobalVariable.game_code, ('rgs_session_token') : GlobalVariable.rgs_session_token
                    , ('state_tag') : GlobalVariable.state_tag]))
    }
    
    log.logInfo(balance.toPlainString())

    spin_balance_result = balance.toPlainString()

    ExcelKeywords.setValueToCellByIndex(Sheet1, 0 + i, 0, spin_balance_result)

    ExcelKeywords.setValueToCellByIndex(Sheet1, 0 + i, 1, transaction_id)
}

ExcelKeywords.setValueToCellByAddresses(Sheet1, content)
ExcelKeywords.saveWorkbook(excelTestFile01, workbook01)

