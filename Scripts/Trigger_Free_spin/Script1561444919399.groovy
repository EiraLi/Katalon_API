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

WS.sendRequestAndVerify(findTestObject('Trigger-free-spin/Get_session_token', [('url') : 'krug-gw.star0ad.com', ('player_id') : 'NewBBINTEST_TestUserCNY', ('partner') : 'f0841d74-6a7d-f0a0-8779-df0dc556f150', ('secretkey') : 'cac491ae-bc9e-4385-80d3-d1093803a266']))

WS.sendRequestAndVerify(findTestObject('Trigger-free-spin/Login', [('url') : 'nurgs.star0ad.com', ('partner') : 'f0841d74-6a7d-f0a0-8779-df0dc556f150', ('session_token') : GlobalVariable.session_token, ('game_code') : 'NG-1012']))

for (int i = 1; i <= 70; i++) {
    response = WS.sendRequestAndVerify(findTestObject('Trigger-free-spin/Take_turn_base_spin', [('url') : 'nurgs.star0ad.com', ('player_id') : GlobalVariable.player_id, ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code, ('rgs_session_token') : GlobalVariable.rgs_session_token, ('state_tag') : GlobalVariable.state_tag]))
}

