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
//below for exporting to excel
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.io.File as File
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords


String excelTestFile02 = '/Users/eiralee/EiraLi-Katalon_API/INT_env/Reports/TestFile02.xls'

ExcelKeywords.createExcelFile(excelTestFile02)

File testfile = new File(excelTestFile02)
assert testfile.exists() == true

workbook01 = ExcelKeywords.getWorkbook(excelTestFile02)
ExcelKeywords.createExcelSheets(workbook01, ['NuRGS', 'M4_historyOrOthersAPI'])
ExcelKeywords.saveWorkbook(excelTestFile02, workbook01)

String[] SheetCreated01 = ['Sheet0', 'NuRGS', 'M4_historyOrOthersAPI']
workbook01 = ExcelKeywords.getWorkbook(excelTestFile02)
assert SheetCreated01 == ExcelKeywords.getSheetNames(workbook01)

NuRGS = ExcelKeywords.getExcelSheet(workbook01, 'NuRGS')
Map content = new HashMap<>()
content.putAt('A1', 'currency')
content.putAt('A2', 'round_id')
content.putAt('A3', 'balance')
content.putAt('A4', 'bet_value')
content.putAt('A5', "feature_trigger_complete")
//content.putAt('A6', "free_spins_left")
//content.putAt('A7', 'total_free_spin_count')
//content.putAt('A8', "total_free_spin_win_amount")
//content.putAt('A9', "feature_trigger_type1")
//content.putAt('A10', "feature_trigger_type2")
//content.putAt('A11', "feature_trigger_type3")
//content.putAt('A12', "feature_trigger_type4")
content.putAt('A6', "total_bet")
content.putAt('A7', "total_win")
content.putAt('A8', "transaction_id")
content.putAt('A9', "transaction_type")
content.putAt('A10', "reels0_01_symbols")
content.putAt('A11', "reels0_02_symbols")
content.putAt('A12', "reels0_03_symbols")
content.putAt('A13', "reels1_01_symbols")
content.putAt('A14', "reels1_02_symbols")
content.putAt('A15', "reels1_03_symbols")
content.putAt('A16', "reels2_01_symbols")
content.putAt('A17', "reels2_02_symbols")
content.putAt('A18', "reels2_03_symbols")
content.putAt('A19', "reels3_01_symbols")
content.putAt('A20', "reels3_02_symbols")
content.putAt('A21', "reels3_03_symbols")
content.putAt('A22', "reels4_01_symbols")
content.putAt('A23', "reels4_02_symbols")
content.putAt('A24', "reels4_03_symbols")




ExcelKeywords.setValueToCellByAddresses(NuRGS, content)
ExcelKeywords.saveWorkbook(excelTestFile02, workbook01)


M4_historyOrOthersAPI = ExcelKeywords.getExcelSheet(workbook01, 'M4_historyOrOthersAPI')
Map content1 = new HashMap<>()
content1.putAt('A1', 'currency')
content1.putAt('A2', 'round_id')
content1.putAt('A3', 'balance')
content1.putAt('A4', 'bet_value')
content1.putAt('A5', "feature_trigger_complete")
//content1.putAt('A6', "free_spins_left")
//content1.putAt('A7', 'total_free_spin_count')
//content1.putAt('A8', "total_free_spin_win_amount")
//content1.putAt('A9', "feature_trigger_type1")
//content1.putAt('A10', "feature_trigger_type2")
//content1.putAt('A11', "feature_trigger_type3")
//content1.putAt('A12', "feature_trigger_type4")
content1.putAt('A6', "total_bet")
content1.putAt('A7', "total_win")
content1.putAt('A8', "transaction_id")
content1.putAt('A9', "transaction_type")
content1.putAt('A10', "reels0_01_symbols")
content1.putAt('A11', "reels0_02_symbols")
content1.putAt('A12', "reels0_03_symbols")
content1.putAt('A13', "reels1_01_symbols")
content1.putAt('A14', "reels1_02_symbols")
content1.putAt('A15', "reels1_03_symbols")
content1.putAt('A16', "reels2_01_symbols")
content1.putAt('A17', "reels2_02_symbols")
content1.putAt('A18', "reels2_03_symbols")
content1.putAt('A19', "reels3_01_symbols")
content1.putAt('A20', "reels3_02_symbols")
content1.putAt('A21', "reels3_03_symbols")
content1.putAt('A22', "reels4_01_symbols")
content1.putAt('A23', "reels4_02_symbols")
content1.putAt('A24', "reels4_03_symbols")


ExcelKeywords.setValueToCellByAddresses(M4_historyOrOthersAPI, content1)
ExcelKeywords.saveWorkbook(excelTestFile02, workbook01)


WS.sendRequestAndVerify(findTestObject('Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : Partner
            , ('secret_key') : secret_key, ('userid') : Userid]))

M4_login = WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_Login', [('partner') : Partner, ('game_code') : Game_code, ('session_token') : GlobalVariable.session_token]))

def M4_login_user_id = GlobalVariable.M4_login_user_id

M4_init = WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_init', [('partner') : Partner, ('M4_recorder') : M4_recorder
            , ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

def rgs_session_token = GlobalVariable.rgs_session_token

def M4_spin_reels_symbols = GlobalVariable.M4_spin_reels_symbols

for (int i = 0; i <= 300; i++) {
    spin_result = WS.sendRequestAndVerify(findTestObject('RGS(M4)/1_M4_spin', [('M4_login_user_id') : GlobalVariable.M4_login_user_id
                , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('partner') : Partner]))

    if ((((GlobalVariable.free_spin_reel_counter[0]) >= 1) && ((GlobalVariable.free_spin_reel_counter[1]) >= 1)) && ((GlobalVariable.free_spin_reel_counter[
    2]) >= 1)) {
        break
    }	
}

WS.sendRequestAndVerify(findTestObject('RGS(M4)/1_Round_detail', [('partner') : Partner, ('M4_spin_round_id') : GlobalVariable.M4_spin_round_id]))

WS.sendRequestAndVerify(findTestObject('RGS(M4)/in_game_history_detail', [('partner') : Partner, ('M4_spin_transaction_id') : GlobalVariable.M4_spin_transaction_id, ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

def M4_round_reels = GlobalVariable.M4_round_reels

//Round detail
reels01 = GlobalVariable.M4_round_reels.symbols[0].symbol
//reels01Values = reels01.values()
println(reels01.getClass().getName())
println(reels01)
reels02 = GlobalVariable.M4_round_reels.symbols[1].symbol
reels03 = GlobalVariable.M4_round_reels.symbols[2].symbol

reels11 = GlobalVariable.M4_round_reels1.symbols[0].symbol
reels12 = GlobalVariable.M4_round_reels1.symbols[1].symbol
reels13 = GlobalVariable.M4_round_reels1.symbols[2].symbol

reels21 = GlobalVariable.M4_round_reels2.symbols[0].symbol
reels22 = GlobalVariable.M4_round_reels2.symbols[1].symbol
reels23 = GlobalVariable.M4_round_reels2.symbols[2].symbol

reels31 = GlobalVariable.M4_round_reels3.symbols[0].symbol
reels32 = GlobalVariable.M4_round_reels3.symbols[1].symbol
reels33 = GlobalVariable.M4_round_reels3.symbols[2].symbol

reels41 = GlobalVariable.M4_round_reels4.symbols[0].symbol
reels42 = GlobalVariable.M4_round_reels4.symbols[1].symbol
reels43 = GlobalVariable.M4_round_reels4.symbols[2].symbol

//M4 history
M4reels01 = GlobalVariable.M4_history_reels[0].symbols[0].symbol
println(M4reels01)
M4reels02 = GlobalVariable.M4_history_reels[0].symbols[1].symbol
M4reels03 = GlobalVariable.M4_history_reels[0].symbols[2].symbol

M4reels11 = GlobalVariable.M4_history_reels[1].symbols[0].symbol
M4reels12 = GlobalVariable.M4_history_reels[1].symbols[1].symbol
M4reels13 = GlobalVariable.M4_history_reels[1].symbols[2].symbol

M4reels21 = GlobalVariable.M4_history_reels[2].symbols[0].symbol
M4reels22 = GlobalVariable.M4_history_reels[2].symbols[1].symbol
M4reels23 = GlobalVariable.M4_history_reels[2].symbols[2].symbol

M4reels31 = GlobalVariable.M4_history_reels[3].symbols[0].symbol
M4reels32 = GlobalVariable.M4_history_reels[3].symbols[1].symbol
M4reels33 = GlobalVariable.M4_history_reels[3].symbols[2].symbol

M4reels41 = GlobalVariable.M4_history_reels[4].symbols[0].symbol
M4reels42 = GlobalVariable.M4_history_reels[4].symbols[1].symbol
M4reels43 = GlobalVariable.M4_history_reels[4].symbols[2].symbol


ExcelKeywords.setValueToCellByIndex(NuRGS, 0, 1, GlobalVariable.M4_round_currency)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 0, 1, GlobalVariable.M4_history_currency)
ExcelKeywords.setValueToCellByIndex(NuRGS, 1, 1, GlobalVariable.M4_round_id)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 1, 1, GlobalVariable.M4_history_round_id)
ExcelKeywords.setValueToCellByIndex(NuRGS, 2, 1, GlobalVariable.M4_round_balance)
String M4_balance = Long.toString(GlobalVariable.M4_history_balance);
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 2, 1, M4_balance)
ExcelKeywords.setValueToCellByIndex(NuRGS, 3, 1, GlobalVariable.M4_round_bet_value)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 3, 1, GlobalVariable.M4_history_total_bet)

ExcelKeywords.setValueToCellByIndex(NuRGS, 4, 1, GlobalVariable.M4_round_features_complete[0])
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 4, 1, "FALSE")
//ExcelKeywords.setValueToCellByIndex(NuRGS, 5, 1, GlobalVariable.M4_round_free_spins_left[0])
//ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 5, 1, "false")
//ExcelKeywords.setValueToCellByIndex(NuRGS, 6, 1, GlobalVariable.M4_round_total_free_spin_count[0])
//ExcelKeywords.setValueToCellByIndex(NuRGS, 7, 1, GlobalVariable.M4_round_total_free_spin_win_amount[0])

//ExcelKeywords.setValueToCellByIndex(NuRGS, 8, 1, GlobalVariable.M4_round_features_type[0])
//ExcelKeywords.setValueToCellByIndex(NuRGS, 9, 1, GlobalVariable.M4_round_features_type[1])
//ExcelKeywords.setValueToCellByIndex(NuRGS, 10, 1, GlobalVariable.M4_round_features_type[2])
//ExcelKeywords.setValueToCellByIndex(NuRGS, 11, 1, GlobalVariable.M4_round_features_type[3])
ExcelKeywords.setValueToCellByIndex(NuRGS, 5, 1, GlobalVariable.M4_round_total_bet)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 5, 1, GlobalVariable.M4_history_total_bet)
ExcelKeywords.setValueToCellByIndex(NuRGS, 6, 1, GlobalVariable.M4_round_total_win)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 6, 1, GlobalVariable.M4_history_total_won)
ExcelKeywords.setValueToCellByIndex(NuRGS, 7, 1, GlobalVariable.M4_round_transaction_id)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 7, 1, GlobalVariable.M4_history_spin_transaction)

ExcelKeywords.setValueToCellByIndex(NuRGS, 8, 1, GlobalVariable.M4_round_transaction_type)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 8, 1, "BASE")

ExcelKeywords.setValueToCellByIndex(NuRGS, 9, 1, reels01)
ExcelKeywords.setValueToCellByIndex(NuRGS, 10, 1, reels02)
ExcelKeywords.setValueToCellByIndex(NuRGS, 11, 1, reels03)
ExcelKeywords.setValueToCellByIndex(NuRGS, 12, 1, reels11)
ExcelKeywords.setValueToCellByIndex(NuRGS, 13, 1, reels12)
ExcelKeywords.setValueToCellByIndex(NuRGS, 14, 1, reels13)
ExcelKeywords.setValueToCellByIndex(NuRGS, 15, 1, reels21)
ExcelKeywords.setValueToCellByIndex(NuRGS, 16, 1, reels22)
ExcelKeywords.setValueToCellByIndex(NuRGS, 17, 1, reels23)
ExcelKeywords.setValueToCellByIndex(NuRGS, 18, 1, reels31)
ExcelKeywords.setValueToCellByIndex(NuRGS, 19, 1, reels32)
ExcelKeywords.setValueToCellByIndex(NuRGS, 20, 1, reels33)
ExcelKeywords.setValueToCellByIndex(NuRGS, 21, 1, reels41)
ExcelKeywords.setValueToCellByIndex(NuRGS, 22, 1, reels42)
ExcelKeywords.setValueToCellByIndex(NuRGS, 23, 1, reels43)

ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 9, 1, M4reels01)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 10, 1, M4reels02)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 11, 1, M4reels03)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 12, 1, M4reels11)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 13, 1, M4reels12)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 14, 1, M4reels13)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 15, 1, M4reels21)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 16, 1, M4reels22)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 17, 1, M4reels23)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 18, 1, M4reels31)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 19, 1, M4reels32)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 20, 1, M4reels33)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 21, 1, M4reels41)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 22, 1, M4reels42)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 23, 1, M4reels43)

ExcelKeywords.setValueToCellByAddresses(M4_historyOrOthersAPI, content1)
ExcelKeywords.setValueToCellByAddresses(NuRGS, content)
ExcelKeywords.saveWorkbook(excelTestFile02, workbook01)

CompareSheet_result = ExcelKeywords.compareTwoSheets(NuRGS, M4_historyOrOthersAPI)
println("Result of compare sheet01 of File01Sheet01 and File02Sheet01 is: " + CompareSheet_result)

//assert GlobalVariable.M4_round_booster_type == null
//ExcelKeywords.setValueToCellByIndex(NuRGS, 0, 1, GlobalVariable.M4_round_currency)
//ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 0, 1, GlobalVariable.M4_history_currency)

assert reels01 == M4reels01