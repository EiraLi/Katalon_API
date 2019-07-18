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


RunConfiguration.setExecutionSettingFile('/var/folders/jv/m57cl6r527jgr1mjg5_9h8vw0000gn/T/Katalon/20190626_101813/execution.properties')

TestCaseMain.beforeStart()

        TestCaseMain.runWSVerificationScript(new TestCaseBinding('',[:]), '    \nimport com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory\nimport com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository\nimport com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory\nimport static com.kms.katalon.core.testdata.TestDataFactory.findTestData\nimport static com.kms.katalon.core.testobject.ObjectRepository.findTestObject\nimport static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase\nimport internal.GlobalVariable as GlobalVariable\n\nMap<String, String> evaluatedVariables = [:]\n\n\nevaluatedVariables.put(\"player_id\", GlobalVariable.player_id.toString())\n\nevaluatedVariables.put(\"rgs_session_token\", GlobalVariable.rgs_session_token.toString())\n\nevaluatedVariables.put(\"partner_code\", GlobalVariable.partner_code.toString())\n\nevaluatedVariables.put(\"state_tag\", GlobalVariable.state_tag.toString())\n\nevaluatedVariables.put(\"game_code\", GlobalVariable.game_code.toString())\n\nevaluatedVariables.put(\"url\", \'nurgs.star9ad.com\'.toString())\n\n\nFileOutputStream fos = null\nObjectOutputStream oos = null\ntry {\n   fos = new FileOutputStream(new File(\"/var/folders/jv/m57cl6r527jgr1mjg5_9h8vw0000gn/T/Katalon/variables/variable-eval-8706848796252536276.tmp\"))\n   oos = new ObjectOutputStream(fos);\n   oos.writeObject(evaluatedVariables)\n} catch (Exception e) {\n   e.printStackTrace()\n} finally {\n   if (fos != null) {\n       fos.close()\n   }\n\n   if (oos != null) {\n       oos.close()\n   }\n}\n \n', FailureHandling.STOP_ON_FAILURE, true)

