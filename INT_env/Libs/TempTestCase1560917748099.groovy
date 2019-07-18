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


RunConfiguration.setExecutionSettingFile('/var/folders/jv/m57cl6r527jgr1mjg5_9h8vw0000gn/T/Katalon/20190619_121548/execution.properties')

TestCaseMain.beforeStart()

        TestCaseMain.runWSVerificationScript(new TestCaseBinding('',[:]), 'import static org.assertj.core.api.Assertions.*\n\nimport com.kms.katalon.core.testobject.RequestObject\nimport com.kms.katalon.core.testobject.ResponseObject\nimport com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS\nimport com.kms.katalon.core.webservice.verification.WSResponseManager\n\nimport groovy.json.JsonSlurper\nimport internal.GlobalVariable as GlobalVariable\n\nRequestObject request = WSResponseManager.getInstance().getCurrentRequest()\n\n\nResponseObject response = WSResponseManager.getInstance().getCurrentResponse()\n\nWS.verifyResponseStatusCode(response, 200)\n\nassertThat(response.getStatusCode()).isEqualTo(200)\n\ndef login = new groovy.json.JsonSlurper()\ndef result_login = login.parseText(response.getResponseBodyContent())\n\ndef rgssessiontoken = result_login.state.session_token\nprintln (\"...value extracted is :\"+rgssessiontoken)\nGlobalVariable.rgs_session_token = rgssessiontoken\nprintln (\"RGS Session is :\"+GlobalVariable.rgs_session_token)\n\ndef features = result_login.state.features\nprintln (\"...value extracted is :\"+features)\nGlobalVariable.features = features\nprintln (\"Features is :\"+GlobalVariable.features)\n\ndef rgsgamecode = result_login.state.game_code\nprintln (\"...value extracted is :\"+rgsgamecode)\nGlobalVariable.rgs_game_code = rgsgamecode\nprintln (\"game code is :\"+GlobalVariable.rgs_game_code)\n\ndef statetag = result_login.state.state_tag\nprintln (\"...value extracted is :\"+statetag)\nGlobalVariable.state_tag = statetag\nprintln (\"State Tag is :\"+GlobalVariable.state_tag)\n\ndef playerid = result_login.state.player_id\nprintln (\"...value extracted is :\"+playerid)\nGlobalVariable.player_id = playerid\nprintln (\"Player ID is :\"+GlobalVariable.player_id)\n\ndef partner_code = result_login.state.partner_code\nprintln (\"...value extracted is :\"+partner_code)\nGlobalVariable.partner_code = partner_code\nprintln (\"Partner Code is :\"+GlobalVariable.partner_code)\n\nif (features != null) {\n\tdef features_type = result_login.state.features[0].type\n\tprintln (\"...value extracted is :\"+features_type)\n\tGlobalVariable.features_type = features_type\n\t\n\tif (\"PICK\".equals(features_type)) {\n\t\tdef free_spin_pick = result_login.state.features[0].complete\n\t\tprintln (\"...value extracted is :\"+free_spin_pick)\n\t\tGlobalVariable.free_spin_pick = free_spin_pick\n\t\tprintln (\"Pick complete is :\"+GlobalVariable.free_spin_pick)\n\n\t\t\t\tif (free_spin_pick == true) {\t\t// free spin picked\n\t\t\t\t\tdef free_spin_complete = result_login.state.features[1].complete\n\t\t\t\t\tprintln (\"...value extracted is :\"+free_spin_complete)\n\t\t\t\t\tGlobalVariable.free_spin_complete = free_spin_complete\n\t\t\t\t\tprintln (\"Pick complete is :\"+GlobalVariable.free_spin_complete)\n\t\t\t\t\n\t\t\t\t\tdef free_spin_left = result_login.state.features[1].feature_state.free_spins_left\n\t\t\t\t\tprintln (\"...value extracted is :\"+free_spin_left)\n\t\t\t\t\tGlobalVariable.free_spin_left = free_spin_left\n\t\t\t\t\tprintln (\"Free Spin Left is :\"+GlobalVariable.free_spin_left)\n\t\t\t}\n\t}\n}', FailureHandling.STOP_ON_FAILURE, true)

