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

KeywordLogger log = new KeywordLogger()

WS.sendRequestAndVerify(findTestObject('Wallet/Get_Session_Token', [('url') : 'krug-gw-colo.star9ad.com', ('partner') : 'c304afdf-2f61-6369-c088-924f99e1be1a'
            , ('secretkey') : '418184e911563cd861e90db6233d7d6c', ('userid1') : 'eira_bbin_0001', ('session_token') : GlobalVariable.session_token]))

WS.sendRequestAndVerify(findTestObject('NuRGS/Login_Final', [('url') : 'nurgs.star9ad.com', ('partner') : 'c304afdf-2f61-6369-c088-924f99e1be1a'
            , ('session_token') : GlobalVariable.session_token, ('game_code') : 'NG-1012']))

def features = GlobalVariable.features

def features_type = GlobalVariable.features_type

def free_spin_pick = GlobalVariable.free_spin_pick

def free_spin_complete = GlobalVariable.free_spin_complete

def free_spin_left = GlobalVariable.free_spin_left

def balance = GlobalVariable.balance

def player_id = GlobalVariable.player_id

def game_code = GlobalVariable.game_code

for (int i = 1; i <= 3; i++) {
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
                spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_free_spin_left', [('url') : 'nurgs.star9ad.com'
                            , ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code
                            , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('state_tag') : GlobalVariable.state_tag]))
            }
        }
    } else if ((features != null) && ('FREE_SPIN'.equals(features_type)) && (free_spin_complete != true)) {
    } else {
        ((features != null) && ('FREE_SPIN'.equals(features_type)) && (free_spin_complete == true)){ 
                spin_result = WS.sendRequestAndVerify(findTestObject('Object Repository/NuRGS/Take turn_Base_spin'))
            }
    }
}

partner_query_history = WS.sendRequestAndVerify(findTestObject('Partner_query_history - Copy', [('url') : 'rp-gt.star9ad.com'
            , ('start_date') : '2019-07-03T00:00:00.000Z', ('end_date') : '2019-07-04T23:59:00.000Z', ('partner') : 'c304afdf-2f61-6369-c088-924f99e1be1a']))

def aaa = new groovy.json.JsonSlurper()

def result_partner_query_history = aaa.parseText(partner_query_history.getResponseText())

def partner_query_user_id = GlobalVariable.partner_query_user_id

def partner_query_game_id = GlobalVariable.partner_query_game_id

def partner_query_balance = GlobalVariable.partner_query_balance

def partner_query_round_id = GlobalVariable.partner_query_round_id

log.logInfo(result_partner_query_history.toString())

log.logInfo(result_partner_query_history.data.toString())

def data = result_partner_query_history.data

log.logInfo(player_id.toString())

log.logInfo(game_code.toString())

log.logInfo(data.size().toString())

for (int i = 0; i < data.size(); i++) {
    def userId = data[i].user_id

    def gameId = data[i].game_id
	
	def roundId = data[i].roundid

    log.logInfo(userId)

    log.logInfo(gameId)

    if ((userId.equals(player_id)) && (gameId.equals(game_code)) && (roundId.equals(partner_query_round_id))) {
        def bal = data[i].balance

        balance_result = balance.toPlainString()

        assert balance_result == bal

        log.logInfo(data[i].toString())
    }
}

