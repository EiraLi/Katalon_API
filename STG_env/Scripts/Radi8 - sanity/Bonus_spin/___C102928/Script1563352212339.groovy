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
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
//below for exporting to excel
import java.io.FileInputStream as FileInputStream
import java.io.FileNotFoundException as FileNotFoundException
import java.io.IOException as IOException
import java.util.Date as Date
import org.apache.poi.xssf.usermodel.XSSFCell as XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow as XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import java.lang.String as String
import static groovy.test.GroovyAssert.shouldFail
import static groovy.test.GroovyAssert.assertNotNull

String excelTestFile102928 = '/Users/eiralee/EiraLi-Katalon_API/Reports/TestFile102928.xls'

//建立 excel 檔
ExcelKeywords.createExcelFile(excelTestFile102928)

//確認 excel 檔是否有被建立
File testfile = new File(excelTestFile102928)

assert testfile.exists() == true

//建立 sheet
workbook01 = ExcelKeywords.getWorkbook(excelTestFile102928)

ExcelKeywords.createExcelSheets(workbook01, ['game_history', 'bo_transaction_detail'])

ExcelKeywords.saveWorkbook(excelTestFile102928, workbook01)

//確認 sheet 是否有被建立
String[] SheetCreated01 = ['Sheet0', 'game_history', 'bo_transaction_detail']

workbook01 = ExcelKeywords.getWorkbook(excelTestFile102928)

assert SheetCreated01 == ExcelKeywords.getSheetNames(workbook01)

//write some date to sheet1
game_history = ExcelKeywords.getExcelSheet(workbook01, 'game_history')

Map content = new HashMap()

content.putAt('A1', 'WinLoss')

content.putAt('B1', 'Bet Paid')

content.putAt('C1', 'Bet Value')

content.putAt('D1', 'Win')

content.putAt('E1', 'Balance')

ExcelKeywords.setValueToCellByAddresses(game_history, content)

ExcelKeywords.saveWorkbook(excelTestFile102928, workbook01)

//write some date to sheet2
bopth = ExcelKeywords.getExcelSheet(workbook01, 'bo_transaction_detail')

Map content1 = new HashMap()

content1.putAt('A1', 'WinLoss')

content1.putAt('B1', 'Bet Paid')

content1.putAt('C1', 'Bet Value')

content1.putAt('D1', 'Win')

content1.putAt('E1', 'Balance')

ExcelKeywords.setValueToCellByAddresses(bo_transaction_detail, content1)

ExcelKeywords.saveWorkbook(excelTestFile102928, workbook01)

get_session = WS.sendRequestAndVerify(findTestObject('Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : partner
            , ('secret_key') : secret_key, ('userid') : userid]))

login = WS.sendRequestAndVerify(findTestObject('NuRGS/Login_Final', [('url_nurgs') : url_nurgs, ('partner') : partner, ('session_token') : GlobalVariable.session_token
            , ('game_code') : game_code]))

println('login_balance is: ' + GlobalVariable.login_balance)

String newline = System.getProperty('line.separator')

for (int i = 0; i <= 4; i++) {
    def balance = GlobalVariable.balance

    def features = GlobalVariable.features

    def features_type = GlobalVariable.features_type

    def free_spin_pick = GlobalVariable.free_spin_pick

    def free_spin_complete = GlobalVariable.free_spin_complete

    def free_spin_left = GlobalVariable.free_spin_left

    def round_id = GlobalVariable.round_id

    def transaction_id = GlobalVariable.transaction_id

    def rgs_session_token = GlobalVariable.rgs_session_token

    def state_tag = GlobalVariable.state_tag

    def win_amount = GlobalVariable.win_amount

    if ((features != null) && 'PICK'.equals(features_type)) {
        if (free_spin_pick != true) {
            spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_pick', [('url_nurgs') : url_nurgs, ('player_id') : GlobalVariable.player_id
                        , ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code, ('rgs_session_token') : GlobalVariable.rgs_session_token
                        , ('state_tag') : GlobalVariable.state_tag, ('choice') : choice])) //            if (free_spin_complete == true) {
            //                spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_Base_spin', [('url_nurgs') : url_nurgs
            //                            , ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code
            //                            , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('state_tag') : GlobalVariable.state_tag]))
        } else if (free_spin_pick == true) {
            if (free_spin_complete != true) {
                spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_free_spin_left', [('url_nurgs') : url_nurgs
                            , ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code
                            , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('state_tag') : GlobalVariable.state_tag]))
            }
        }
    } else if (((features != null) && 'FREE_SPIN'.equals(features_type)) && (free_spin_complete != true)) {
        spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_free_spin_left', [('url_nurgs') : url_nurgs
                    , ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code
                    , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('state_tag') : GlobalVariable.state_tag]))
    } else if (((features != null) && 'FREE_SPIN'.equals(features_type)) && (free_spin_complete == true)) {
        spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_Base_spin', [('url_nurgs') : url_nurgs, ('player_id') : GlobalVariable.player_id
                    , ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code, ('rgs_session_token') : GlobalVariable.rgs_session_token
                    , ('state_tag') : GlobalVariable.state_tag]))
    }
}

println(('@@@@@@GlobalVariable.round_id is:@@@@@@' + newline) + GlobalVariable.round_id)

def round_id = GlobalVariable.round_id

//In-game history check
WS.sendRequestAndVerify(findTestObject('NuRGS/RoundId_detail api', [('partner') : partner, ('round_id') : GlobalVariable.round_id
            , ('game_code') : game_code, ('partner_code') : partner_code]))

free_spin_win_amount = (GlobalVariable.round_detail_balance + GlobalVariable.round_total_free_spin_win_amount)

//convert Long to String()
//String free_spin_win_amount_total_balance = Long.toString(free_spin_win_amount)
def WinLoss = GlobalVariable.round_total_win - GlobalVariable.round_total_bet

println('*****WinLoss is: ******' + WinLoss)

ExcelKeywords.setValueToCellByIndex(game_history, 1, 0, WinLoss)

ExcelKeywords.setValueToCellByIndex(game_history, 1, 1, GlobalVariable.bet_amount)

ExcelKeywords.setValueToCellByIndex(game_history, 1, 2, GlobalVariable.bet_value)

ExcelKeywords.setValueToCellByIndex(game_history, 1, 3, GlobalVariable.win_amount)

ExcelKeywords.setValueToCellByIndex(game_history, 1, 4, GlobalVariable.balance)

ExcelKeywords.setValueToCellByAddresses(game_history, content)

ExcelKeywords.saveWorkbook(excelTestFile102928, workbook01)

println('free_spin_win_amount_total_balance is: ' + free_spin_win_amount_total_balance.getClass().getName())

println(('*****GlobalVariable.round_detail_balance****' + newline) + GlobalVariable.round_detail_balance)

println(('*****GlobalVariable.round_total_free_spin_win_amount*****' + newline) + GlobalVariable.round_total_free_spin_win_amount)

println(('****GlobalVariable.round_bet_value****' + newline) + GlobalVariable.round_bet_value)

println('*****free_spin_win_amount_total_balance is:******' + free_spin_win_amount_total_balance)

get_session = WS.sendRequestAndVerify(findTestObject('Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : partner
            , ('secret_key') : secret_key, ('userid') : userid]))

login = WS.sendRequestAndVerify(findTestObject('NuRGS/Login_Final', [('url_nurgs') : url_nurgs, ('partner') : partner, ('session_token') : GlobalVariable.session_token
            , ('game_code') : game_code]))

println('******GlobalVariable.login_balance is: ********' + GlobalVariable.login_balance)

println('******GlobalVariable.login_balance is: ********' + GlobalVariable.login_balance.getClass().getName())

//check BOPTH api
WS.sendRequestAndVerify(findTestObject('BOPTH', [('url_krug') : url_krug, ('userid') : userid, ('partner') : partner, ('start_date') : start_date, ('end_date') : end_date]))


ExcelKeywords.setValueToCellByIndex(bo_transaction_detail, 1, 0, GlobalVariable.bo_winLoss)

ExcelKeywords.setValueToCellByIndex(bo_transaction_detail, 1, 1, GlobalVariable.bet_amount)

ExcelKeywords.setValueToCellByIndex(bo_transaction_detail, 1, 2, GlobalVariable.bo_betValue)

ExcelKeywords.setValueToCellByIndex(bo_transaction_detail, 1, 3, GlobalVariable.win_amount)

ExcelKeywords.setValueToCellByIndex(bo_transaction_detail, 1, 4, GlobalVariable.latest_bo_balance)

ExcelKeywords.setValueToCellByAddresses(bo_transaction_detail, content1)

ExcelKeywords.saveWorkbook(excelTestFile102928, workbook01)
