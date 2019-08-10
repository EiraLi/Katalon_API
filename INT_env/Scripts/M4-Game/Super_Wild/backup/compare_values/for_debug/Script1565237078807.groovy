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

WS.sendRequestAndVerify(findTestObject('Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : Partner
            , ('secret_key') : secret_key, ('userid') : Userid]))

M4_login = WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_Login', [('partner') : Partner, ('game_code') : Game_code, ('session_token') : GlobalVariable.session_token]))

def M4_login_user_id = GlobalVariable.M4_login_user_id

M4_init = WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_init', [('partner') : Partner, ('M4_recorder') : M4_recorder
            , ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

def rgs_session_token = GlobalVariable.rgs_session_token

def M4_spin_reels_symbols = GlobalVariable.M4_spin_reels_symbols

for (int i = 0; i <= 3; i++) {
    spin_result = WS.sendRequestAndVerify(findTestObject('RGS(M4)/1_M4_spin', [('M4_login_user_id') : GlobalVariable.M4_login_user_id
                , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('partner') : Partner]))

    
}

WS.sendRequestAndVerify(findTestObject('RGS(M4)/DEBUG_Round_detail', [('partner') : Partner, ('M4_spin_round_id') : GlobalVariable.M4_spin_round_id]))

def M4_balance = GlobalVariable.M4_round_balance

println(M4_balance.getClass().getName())

Long M4_round_balance = Long.valueOf(M4_balance)

def M4_round_object = GlobalVariable.M4_round_object.spin_results

for (i = 0; i < M4_round_object.size(); i++) {
    def last_spin_result = M4_round_object[i].balance

    println(last_spin_result)

    if (last_spin_result >= M4_round_balance) {
        

        M4_round_balance = last_spin_result
    }
}

WS.sendRequestAndVerify(findTestObject('RGS(M4)/DEBUG_in_game_history_detail', [('partner') : Partner, ('M4_spin_transaction_id') : GlobalVariable.M4_spin_transaction_id, ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))


def M4_history_balance = GlobalVariable.M4_history_balance
long M4_history_balance_result = new Long(M4_history_balance)

println(M4_round_balance)

println(M4_round_balance.getClass().getName())

assert M4_round_balance == M4_history_balance_result

