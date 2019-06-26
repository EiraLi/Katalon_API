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

    if (features == null) {		// Free Spin Not Triggered
        println('features = ' + features)
        spin_result = WS.sendRequestAndVerify(findTestObject('take-turn_BaseSpin'))
    } else if ((features != null) && !('PICK'.equals(features_type))) {		// Features Triggered but Type is not Free Spin
        println('features = ' + features)
        spin_result = WS.sendRequestAndVerify(findTestObject('take-turn_BaseSpin'))
		
    } else if ((features != null) && 'PICK'.equals(features_type)) {		// Features Triggered and Type is Free Spin
        println('features = ' + features)
        println('free spin pick is = ' + free_spin_pick)

        if (free_spin_pick != true) {		// Free Spin Not Pick Yet
            WS.sendRequestAndVerify(findTestObject('take-turn_Pick'))
        } else if (free_spin_pick == true) {		// Free Spin Picked
            println('features = ' + features)
            println('free spin pick is = ' + free_spin_pick)

            if (free_spin_complete != true) {		        // Free Spin Not Completed
                WS.sendRequestAndVerify(findTestObject('take-turn_FreeSpin'))
                println('free spin left  = ' + free_spin_left)
            } else if (free_spin_complete == true) {		        // Free Spin Completed
                println('features = ' + features)
                WS.sendRequestAndVerify(findTestObject('take-turn_BaseSpin'))
            }
        }
    }
}

