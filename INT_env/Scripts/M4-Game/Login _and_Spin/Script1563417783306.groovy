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

WS.sendRequestAndVerify(findTestObject('Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : partner
            , ('secret_key') : secret_key, ('userid') : userid]))

WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_Login', [('partner') : partner, ('env') : env, ('game_code') : game_code
            , ('session_token') : GlobalVariable.session_token]))

WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_init', [('partner') : partner, ('env') : env, ('M4_recorder') : M4_recorder
            , ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

println('M4_login_user_id is: ' + GlobalVariable.M4_login_user_id)

println('GlobalVariable.M4_init_balance is: ' + GlobalVariable.M4_init_balance)

//WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_spin_backup', [('partner') : partner, ('env') : env, ('rgs_session_token') : GlobalVariable.rgs_session_token, ('M4_Login_user_id') : GlobalVariable.M4_login_user_id]))



for (int i = 1; i <= 600; i++) {
    def M4_total_bonus_spins = GlobalVariable.M4_total_bonus_spins

   
        spin_result = WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_spin_backup', [('partner') : partner, ('env') : env, ('rgs_session_token') : GlobalVariable.rgs_session_token
                    , ('M4_Login_user_id') : GlobalVariable.M4_login_user_id]))
   
}
println("rgs_session_token"+GlobalVariable.rgs_session_token)
println('M4_login_user_id'+ GlobalVariable.M4_login_user_id)
println('GlobalVariable.M4_spin_current_balance is:' + GlobalVariable.M4_spin_current_balance)
println('GlobalVariable.M4_spin_transaction_id is:' + GlobalVariable.M4_spin_transaction_id)

