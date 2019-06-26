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

response = WS.sendRequestAndVerify(findTestObject('Eira_Free_spin/Get_Session_Token', [('url') : 'krug-gw-colo.star9ad.com'
            , ('partner') : 'c304afdf-2f61-6369-c088-924f99e1be1a', ('secretkey') : '418184e911563cd861e90db6233d7d6c', ('userid1') : 'eira_bbin_0001'
            , ('userid2') : '86586680']))

login = WS.sendRequestAndVerify(findTestObject('Eira_Free_spin/Login', [('url') : 'nurgs.star9ad.com', ('partner') : 'c304afdf-2f61-6369-c088-924f99e1be1a'
            , ('session_token') : GlobalVariable.session_token, ('gamecode') : 'NG-0063']))

WS.sendRequest(findTestObject('Eira_Free_spin/Take_turn_base_spin', [('url') : 'nurgs.star9ad.com', ('player_id') : GlobalVariable.player_id
            , ('partner_code') : GlobalVariable.partner_code, ('game_code') : GlobalVariable.game_code, ('rgs_session_token') : GlobalVariable.rgs_session_token
            , ('state_tag') : GlobalVariable.state_tag]))

