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

//***Free booster can be used when using booster in NG game***
WS.sendRequestAndVerify(findTestObject('Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : partner
            , ('secret_key') : secret_key, ('userid') : userid]))

WS.sendRequestAndVerify(findTestObject('NuRGS/Login_Final', [('url_nurgs') : url_nurgs, ('partner') : partner, ('session_token') : GlobalVariable.session_token
            , ('game_code') : game_code]))

def login_balance = GlobalVariable.login_balance

WS.sendRequestAndVerify(findTestObject('GenPlus/Add_GenCoin', [('url_genplus') : url_genplus, ('partner_code') : partner_code
            , ('userid') : userid]))

//購買的booster 數量要大於等於 loop 的次數
WS.sendRequestAndVerify(findTestObject('NuRGS/Buy_Booster', [('url_nurgs') : url_nurgs, ('game_code') : game_code, ('partner_code') : partner_code, ('userid') : userid, ('rgs_session_token') : GlobalVariable.rgs_session_token]))

for (int i = 1; i <= 25; i++) {
    def features = GlobalVariable.features

    def features_type = GlobalVariable.features_type

    def free_spin_pick = GlobalVariable.free_spin_pick

    def free_spin_complete = GlobalVariable.free_spin_complete

    def free_spin_left = GlobalVariable.free_spin_left

    def provider = GlobalVariable.provider

    def balance = GlobalVariable.balance

    def booster_round_win = GlobalVariable.booster_round_win

    if (features == null) {
        spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_Free_round', [('url_nurgs') : url_nurgs, ('game_code') : GlobalVariable.game_code
                    , ('partner_code') : GlobalVariable.partner_code, ('player_id') : GlobalVariable.player_id, ('rgs_session_token') : GlobalVariable.rgs_session_token
                    , ('state_tag') : GlobalVariable.state_tag]))
    } else if ((features != null) && 'PICK'.equals(features_type)) {
        if (free_spin_pick != true) {
            spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_pick', [('url_nurgs') : url_nurgs, ('player_id') : GlobalVariable.player_id
                        , ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code, ('rgs_session_token') : GlobalVariable.rgs_session_token
                        , ('state_tag') : GlobalVariable.state_tag, ('choice') : choice]))
        } else if (free_spin_pick == true) {
            println('free_spin_pick is:' + free_spin_pick)

            if (free_spin_complete != true) {
                spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_free_spin_left', [('url_nurgs') : url_nurgs
                            , ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code
                            , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('state_tag') : GlobalVariable.state_tag]))
            } else if (free_spin_complete == true) {
                spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_Free_round', [('url_nurgs') : url_nurgs
                            , ('game_code') : GlobalVariable.game_code, ('partner_code') : GlobalVariable.partner_code, ('player_id') : GlobalVariable.player_id
                            , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('state_tag') : GlobalVariable.state_tag]))
            }
        }
    }
    
    println('booster round win is:' + GlobalVariable.booster_round_win)
}

WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_Free_round', [('url_nurgs') : url_nurgs, ('game_code') : GlobalVariable.game_code
            , ('partner_code') : GlobalVariable.partner_code, ('player_id') : GlobalVariable.player_id, ('rgs_session_token') : GlobalVariable.rgs_session_token
            , ('state_tag') : GlobalVariable.state_tag]))

//比對 provider 裡面是否有值 和 booster 數量是否有減少
assert GlobalVariable.provider != null && 

println('provider is:' + GlobalVariable.provider)

