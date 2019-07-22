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

WS.sendRequestAndVerify(findTestObject('Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : partner
            , ('secret_key') : secret_key, ('userid') : userid]))

WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_Login', [('partner') : partner, ('env') : env, ('game_code') : game_code
            , ('session_token') : GlobalVariable.session_token]))

WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_init', [('partner') : partner, ('env') : env, ('M4_recorder') : M4_recorder
            , ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

println('M4_login_user_id is: ' + GlobalVariable.M4_login_user_id)

println('GlobalVariable.M4_init_balance is: ' + GlobalVariable.M4_init_balance)

//ArrayList<String> wild_scatter = new ArrayList<String>()
//wild_scatter.add("WILD_Expanding")
//wild_scatter.add("WILD_Normal")
//wild_scatter.add("WILD_Double")
//wild_scatter.add("WILD_ExtraFG")
//wild_scatter.add("WILD_Triple")
//
//ArrayList<String> other_scatter = new ArrayList<String>()
//wild_scatter.add("A")
//wild_scatter.add("K")
//wild_scatter.add("Q")
//wild_scatter.add("J")
//wild_scatter.add("PIC1")
//wild_scatter.add("PIC2")
//wild_scatter.add("PIC3")
//for (int i=0; i<=10; i++){
//if (M4_reel3_symbol1.contains(other_scatter) && M4_reel3_symbol2.contains(other_scatter) && M4_reel3_symbol2.contains(other_scatter)){
//	spin_result = WS.sendRequestAndVerify(findTestObject('Object Repository/RGS(M4)/M4_spin'))
//	break
//	println("Success!!!!")
//}
//}
//
//for (int i=0; i < M4_reels_spin_result.reels.size(); i++) {
//	def M4_reels_spin_result = GlobalVariable.M4_reels_spin_result
//    for (int j=0; j < M4_reels_spin_result.reels[i].symbols.size(); j++) {
//		Println(M4_reels_spin_result.reels[i].symbols[j])
//    }
//}
for (int i = 0; i < M4_reels_spin_result.reels.size(); i++) {
    spin_result = WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_spin', [('partner') : partner, ('env') : env, ('rgs_session_token') : GlobalVariable.rgs_session_token
                , ('M4_Login_user_id') : GlobalVariable.M4_login_user_id]))

    for (int j = 0; j < M4_reels_spin_result.reels[i].symbols.size(); j++) {
        Println(M4_reels_spin_result.reels[i].symbols[j])
    }
}

