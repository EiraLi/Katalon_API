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
import com.kms.katalon.core.logging.KeywordLogger


KeywordLogger log = new KeywordLogger()
WS.sendRequestAndVerify(findTestObject('Eira_Free_spin/Get_Session_Token', [('url') : 'krug-gw-colo.star9ad.com'
            , ('partner') : 'c304afdf-2f61-6369-c088-924f99e1be1a', ('secretkey') : '418184e911563cd861e90db6233d7d6c', ('userid1') : 'eira_bbin_0001'
            , ('userid2') : '86586680', ('session_token') : GlobalVariable.session_token]))

WS.sendRequestAndVerify(findTestObject('Eira_Free_spin/Login', [('url') : 'nurgs.star9ad.com', ('partner') : 'c304afdf-2f61-6369-c088-924f99e1be1a'
            , ('session_token') : GlobalVariable.session_token, ('game_code') : 'NG-0063']))


    def features = GlobalVariable.features

    def features_type = GlobalVariable.features_type

    def free_spin_pick = GlobalVariable.free_spin_pick

    def free_spin_complete = GlobalVariable.free_spin_complete

    def free_spin_left = GlobalVariable.free_spin_left

for (int i=1; i<=3; i++){
	if (features == null) {
        // Free Spin Not Triggered
        println('features = ' + features)
		log.logInfo(features)
        spin_result = WS.sendRequestAndVerify(findTestObject('Eira_Free_spin/Take_turn_base_spin', [('url') : 'nurgs.star9ad.com'
                    , ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code
                    , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('state_tag') : GlobalVariable.state_tag])) // Features Triggered but Type is not Free Spin
        // Features Triggered and Type is Free Spin
        // Free Spin Not Pick Yet
        // Free Spin Picked
        // Free Spin Not Completed
        // Free Spin Completed
    } else if ((features != null) && !('PICK'.equals(features_type))) {
        println('features = ' + features)

        spin_result = WS.sendRequestAndVerify(findTestObject('take-turn_BaseSpin', [('player_id') : GlobalVariable.player_id
                    , ('partner_code') : GlobalVariable.partner_code, ('rgs_session_token') : GlobalVariable.rgs_session_token
                    , ('state_tag') : GlobalVariable.state_tag]))
    } else if ((features != null) && 'PICK'.equals(features_type)) {
        println('features = ' + features)

        println('free spin pick is = ' + free_spin_pick)

        if (free_spin_pick != true) {
            WS.sendRequestAndVerify(findTestObject('Eira_Free_spin/Take_turn_pick', [('url') : 'nurgs.star9ad.com', ('player_id') : GlobalVariable.player_id
                        , ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code, ('rgs_session_token') : GlobalVariable.rgs_session_token
                        , ('state_tag') : GlobalVariable.state_tag, ('choice') : 'FS_20']))
        } else if (free_spin_pick == true) {
            println('features = ' + features)

            println('free spin pick is = ' + free_spin_pick)

            if (free_spin_complete != true) {
                WS.sendRequestAndVerify(findTestObject('Eira_Free_spin/Take_turn_free_spin_left', [('url') : 'nurgs.star9ad.com'
                            , ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code
                            , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('state_tag') : GlobalVariable.state_tag]))

                println('free spin left  = ' + free_spin_left)
            } else if (free_spin_complete == true) {
                println('features = ' + features)

                WS.sendRequestAndVerify(findTestObject('Eira_Free_spin/Take_turn_base_spin', [('url') : 'nurgs.star9ad.com'
                            , ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code
                            , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('state_tag') : GlobalVariable.state_tag]))
            }
        }
    }


}
