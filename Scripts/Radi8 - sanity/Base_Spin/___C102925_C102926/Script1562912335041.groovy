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

get_session = WS.sendRequestAndVerify(findTestObject('Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : partner
            , ('secret_key') : secret_key, ('userid') : userid]))

login = WS.sendRequestAndVerify(findTestObject('NuRGS/Login_Final', [('url_nurgs') : url_nurgs, ('partner') : partner, ('session_token') : GlobalVariable.session_token
            , ('game_code') : game_code]))

String newline = System.getProperty('line.separator')

for (int i = 1; i <= 3; i++) {
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
	
    if (features == null) {
        spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_Base_spin', [('url_nurgs') : url_nurgs, ('player_id') : GlobalVariable.player_id
                    , ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code, ('rgs_session_token') : GlobalVariable.rgs_session_token
                    , ('state_tag') : GlobalVariable.state_tag]))
    } else if ((features != null) && 'PICK'.equals(features_type)) {
        if (free_spin_pick != true) {
            spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_pick', [('url_nurgs') : url_nurgs, ('player_id') : GlobalVariable.player_id
                        , ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code, ('rgs_session_token') : GlobalVariable.rgs_session_token
                        , ('state_tag') : GlobalVariable.state_tag, ('choice') : choice]))
        } else if (free_spin_pick == true) {
            if (free_spin_complete == true) {
                spin_result = WS.sendRequestAndVerify(findTestObject('NuRGS/Take turn_Base_spin', [('url_nurgs') : url_nurgs
                            , ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code
                            , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('state_tag') : GlobalVariable.state_tag]))
            } else if (free_spin_complete != true) {
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

//def last_balance = GlobalVariable.balance
//
//balance = last_balance.toPlainString()
//
//println(('**** spin_balance_result is: ****' + newline) + balance)

get_session = WS.sendRequestAndVerify(findTestObject('Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : partner
            , ('secret_key') : secret_key, ('userid') : userid]))

login = WS.sendRequestAndVerify(findTestObject('NuRGS/Login_Final', [('url_nurgs') : url_nurgs, ('partner') : partner, ('session_token') : GlobalVariable.session_token
            , ('game_code') : game_code]))

def login_balance = GlobalVariable.login_balance
def balance = GlobalVariable.balance

//login_balance_result = login_balance.toPlainString()

println('login_balance is: ' + login_balance)
println('balance is: ' + balance)
println('login_win_amount is: ' + GlobalVariable.login_win_amount)
println('win_amount is: ' + GlobalVariable.win_amount)

//assert balance == login_balance_result
assert GlobalVariable.login_balance == GlobalVariable.balance && GlobalVariable.login_win_amount == GlobalVariable.win_amount


//*****check (bet, balance, symbols)
  

