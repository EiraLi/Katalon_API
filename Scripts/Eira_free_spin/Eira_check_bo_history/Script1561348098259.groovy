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

get_session_token = WS.sendRequestAndVerify(findTestObject('Get_Session_Token'))

login = WS.sendRequestAndVerify(findTestObject('Login'))

for (int i = 1; i <= 2; i++) {
    def features = GlobalVariable.features

    def features_type = GlobalVariable.features_type

    def free_spin_pick = GlobalVariable.free_spin_pick

    def free_spin_complete = GlobalVariable.free_spin_complete

    def free_spin_left = GlobalVariable.free_spin_left
	
	def balance = GlobalVariable.balance
	
	def playerid = GlobalVariable.player_id
	
	def gamecode = GlobalVariable.game_code

      if (features == null) {		// Free Spin Not Triggered
        println('features = ' + features)
        spin_result = WS.sendRequestAndVerify(findTestObject('take-turn_BaseSpin'))
		println("balance is: "+balance, "player id is:" +playerid, "game code is: "+gamecode)
    } else if ((features != null) && !('PICK'.equals(features_type))) {		// Features Triggered but Type is not Free Spin
        println('features = ' + features)
        spin_result = WS.sendRequestAndVerify(findTestObject('take-turn_BaseSpin'))
		println("balance is: "+balance, "player id is:" +playerid, "game code is: "+gamecode)
		
    } else if ((features != null) && 'PICK'.equals(features_type)) {		// Features Triggered and Type is Free Spin
        println('features = ' + features)
        println('free spin pick is = ' + free_spin_pick)
		println("balance is: "+balance, "player id is:" +playerid, "game code is: "+gamecode)
		
        if (free_spin_pick != true) {		// Free Spin Not Pick Yet
            WS.sendRequestAndVerify(findTestObject('take-turn_Pick'))
			println("balance is: "+balance, "player id is:" +playerid, "game code is: "+gamecode)
        } else if (free_spin_pick == true) {		// Free Spin Picked
            println('features = ' + features)
            println('free spin pick is = ' + free_spin_pick)
			println("balance is: "+balance, "player id is:" +playerid, "game code is: "+gamecode)
			
            if (free_spin_complete != true) {		        // Free Spin Not Completed
                WS.sendRequestAndVerify(findTestObject('take-turn_FreeSpin'))
                println('free spin left  = ' + free_spin_left)
				println("balance is: "+balance, "player id is:" +playerid, "game code is: "+gamecode)
				
            } else if (free_spin_complete == true) {		        // Free Spin Completed
                println('features = ' + features)
                WS.sendRequestAndVerify(findTestObject('take-turn_BaseSpin'))
				println("balance is: "+balance, "player id is:" +playerid, "game code is: "+gamecode)
            }
        }
    }
}

partner_query_history = WS.sendRequestAndVerify(findTestObject('Eira_Free_spin/Partner_query_history', [('url') : 'rp-gt.star9ad.com'
            , ('start_date') : '2019-06-24T00:00:00.000Z', ('end_date') : '2019-06-24T23:59:00.000Z']))
	def partner_query_user_id = GlobalVariable.partner_query_user_id
	
    def partner_query_game_id = GlobalVariable.partner_query_game_id

    def partner_query_balance = GlobalVariable.partner_query_balance

assert partner_query_user_id == player_id && partner_query_game_id == gamecode && partner_query_balance == balance;

