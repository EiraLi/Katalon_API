import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.contribution.WebUiDriverCleaner
import com.kms.katalon.core.mobile.contribution.MobileDriverCleaner
import com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner


DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())


RunConfiguration.setExecutionSettingFile('/var/folders/jv/m57cl6r527jgr1mjg5_9h8vw0000gn/T/Katalon/20190528_112531/execution.properties')

TestCaseMain.beforeStart()

        TestCaseMain.runWSVerificationScript(new TestCaseBinding('',[:]), 'import static org.assertj.core.api.Assertions.*\n\nimport com.kms.katalon.core.testobject.RequestObject\nimport com.kms.katalon.core.testobject.ResponseObject\nimport com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS\nimport com.kms.katalon.core.webservice.verification.WSResponseManager\n\n\nRequestObject request = WSResponseManager.getInstance().getCurrentRequest()\n\nResponseObject response = WSResponseManager.getInstance().getCurrentResponse()\n\nimport groovy.json.JsonSlurper\nimport internal.GlobalVariable as GlobalVariable\n\n\nWS.verifyResponseStatusCode(response, 200)\n\nassertThat(response.getStatusCode()).isEqualTo(200)\nassertThat(response.getResponseText()).contains(\'session_token\')\n\ndef getsession = new groovy.json.JsonSlurper()\ndef result_getsession = getsession.parseText(response.getResponseBodyContent())\n\ndef session_token = result_getsession.session_token\nprintln (\"...value extracted is :\"+session_token)\n\nGlobalVariable.session_token = session_token\nprintln (\"GlobalVariable is :\"+GlobalVariable.session_token)', FailureHandling.STOP_ON_FAILURE, true)

