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

def M4_login_user_id = GlobalVariable.M4_login_user_id
def rgs_session_token = GlobalVariable.rgs_session_token

WS.sendRequestAndVerify(findTestObject('Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : partner
            , ('secret_key') : secret_key, ('userid') : userid]))

WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_Login', [('partner') : partner, ('game_code') : game_code, ('session_token') : GlobalVariable.session_token]))

WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_init', [('partner') : partner, ('M4_recorder') : M4_recorder, ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

println('GlobalVariable.M4_login_user_id is:' + GlobalVariable.M4_login_user_id)

println('GlobalVariable.rgs_session_token is' + GlobalVariable.rgs_session_token)

for (int i=0; i<=50; i++){
	spin_result = WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_spin', [('partner') : partner, ('rgs_session_token') : GlobalVariable.rgs_session_token
            , ('M4_Login_user_id') : GlobalVariable.M4_login_user_id]))
	if (GlobalVariable.counter[0] >= 1 && GlobalVariable.counter[1] >= 1 && GlobalVariable.counter[2] >= 1){
		break
	}
}

println("partner:"+partner)

println("GlobalVariable.counter is: "+GlobalVariable.counter)



