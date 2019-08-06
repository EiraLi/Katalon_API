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

//NG game Keys need to be compared with round  detail api
WS.sendRequestAndVerify(findTestObject('Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : Partner
            , ('secret_key') : secret_key, ('userid') : Userid]))

M4_login = WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_Login', [('partner') : Partner, ('game_code') : Game_code, ('session_token') : GlobalVariable.session_token]))

def M4_login_user_id = GlobalVariable.M4_login_user_id

M4_init = WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_init', [('partner') : Partner, ('M4_recorder') : M4_recorder
            , ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

def rgs_session_token = GlobalVariable.rgs_session_token

for (int i = 0; i <= 500; i++) {
    def M4_spin_line_wins = GlobalVariable.M4_spin_line_wins

    def M4_spin_total_bonus_win_this_round = GlobalVariable.M4_spin_total_bonus_win_this_round

    spin_result = WS.sendRequestAndVerify(findTestObject('RGS(M4)/1_M4_spin', [('M4_login_user_id') : GlobalVariable.M4_login_user_id
                , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('partner') : Partner]))

    if ((GlobalVariable.M4_total_bonus_spins != 0) && (GlobalVariable.M4_spin_line_wins.size() != 0)) {
        break
    }
}

WS.sendRequestAndVerify(findTestObject('RGS(M4)/2_Round_detail', [('partner') : Partner, ('M4_spin_round_id') : GlobalVariable.M4_spin_round_id]))

WS.sendRequestAndVerify(findTestObject('RGS(M4)/2_in_game_history_detail', [('partner') : Partner, ('M4_spin_transaction_id') : GlobalVariable.M4_spin_transaction_id, ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

//def M4_round_All_values = GlobalVariable.M4_round_reel_wins.values()
//ArrayList<String> listOfValues = new ArrayList<String>(M4_round_All_values)
//println("listOfValues is: "+listOfValues)
//println("reel_wins_list"+reel_wins)
//assert reel_wins.equals(listofKeys)
println('GlobalVariable.M4_round_reel_wins_line_number is: ' + GlobalVariable.M4_round_reel_wins_line_number)

println('GlobalVariable.M4_history_line_win_line is: ' + GlobalVariable.M4_history_line_win_line)

println('GlobalVariable.M4_round_reel_wins_line_number is: ' + GlobalVariable.M4_round_reel_wins_line_number)

println('GlobalVariable.M4_history_line_win_line is: ' + GlobalVariable.M4_history_line_win_line)

println('GlobalVariable.M4_round_reel_wins_prize is: ' + GlobalVariable.M4_round_reel_wins_prize)

println('GlobalVariable.M4_history_prize is: ' + GlobalVariable.M4_history_prize)

println('GlobalVariable.M4_round_reel_wins_symbol is: ' + GlobalVariable.M4_round_reel_wins_symbol)

println('GlobalVariable.M4_history_line_win_symbol is: ' + GlobalVariable.M4_history_line_win_symbol)

assert GlobalVariable.M4_round_reel_wins_of_kind == GlobalVariable.M4_history_kind

assert GlobalVariable.M4_round_reel_wins_line_number == GlobalVariable.M4_history_line_win_line

assert GlobalVariable.M4_round_reel_wins_prize == GlobalVariable.M4_history_prize

assert GlobalVariable.M4_round_reel_wins_symbol == GlobalVariable.M4_history_line_win_symbol

