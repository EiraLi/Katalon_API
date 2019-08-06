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

WS.sendRequestAndVerify(findTestObject('Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : Partner
            , ('secret_key') : secret_key, ('userid') : Userid]))

M4_login = WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_Login', [('partner') : Partner, ('game_code') : Game_code, ('session_token') : GlobalVariable.session_token]))

def M4_login_user_id = GlobalVariable.M4_login_user_id

M4_init = WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_init', [('partner') : Partner, ('M4_recorder') : M4_recorder
            , ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

def rgs_session_token = GlobalVariable.rgs_session_token


for (int i = 0; i <= 500; i++) {
    spin_result = WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_spin_backup', [('M4_login_user_id') : GlobalVariable.M4_login_user_id
                , ('partner') : Partner, ('rgs_session_token') : GlobalVariable.rgs_session_token]))
    if ((((GlobalVariable.free_spin_reel_counter[0]) >= 1) && ((GlobalVariable.free_spin_reel_counter[1]) >= 1)) && ((GlobalVariable.free_spin_reel_counter[2]) >= 1)) {
        break
	//or 
//	if (GlobalVariable.M4_total_bonus_spins != "0"){
//			break 
    }
}


println('GlobalVariable.free_spin_reel_counter is: ' + GlobalVariable.free_spin_reel_counter)
println("GlobalVariable.M4_total_bonus_spins is: "+GlobalVariable.M4_total_bonus_spins)


