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
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger


KeywordLogger log = new KeywordLogger()

WS.sendRequestAndVerify(findTestObject('Wallet/Get_Session_Token', [('url') : 'krug-gw-colo.star9ad.com', ('partner') : 'c304afdf-2f61-6369-c088-924f99e1be1a'
            , ('secretkey') : '418184e911563cd861e90db6233d7d6c', ('userid1') : 'eira_bbin_0001', ('session_token') : GlobalVariable.session_token]))

WS.sendRequestAndVerify(findTestObject('NuRGS/Login _free_spin_PICK', [('url') : 'nurgs.star9ad.com', ('partner') : 'c304afdf-2f61-6369-c088-924f99e1be1a'
            , ('session_token') : GlobalVariable.session_token, ('game_code') : 'NG-0063']))

for (int i = 1; i <= 5; i++) {
    def features = GlobalVariable.features

    def features_type = GlobalVariable.features_type

    def free_spin_pick = GlobalVariable.free_spin_pick

    def free_spin_complete = GlobalVariable.free_spin_complete

    def free_spin_left = GlobalVariable.free_spin_left

    if (features == null) {
        spin_result = WS.sendRequestAndVerify(findTestObject('Object Repository/NuRGS/Take turn_Free_round'))
    } else if ((features != null) && 'PICK'.equals(features_type)) {
        if (free_spin_pick != true) {
            spin_result = WS.sendRequestAndVerify(findTestObject('Object Repository/NuRGS/Take turn_pick'))
        } else if (free_spin_pick == true) {
            log.logInfo(free_spin_pick.toString())

            if (free_spin_complete != true) {
                spin_result = WS.sendRequestAndVerify(findTestObject('Object Repository/NuRGS/Take turn_free_spin_left'))
            } else if (free_spin_complete == true) {
                spin_result = WS.sendRequestAndVerify(findTestObject('Object Repository/NuRGS/Take turn_Free_round'))
            }
        }
    }
}

