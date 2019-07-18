import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/Spin_the_game')

suiteProperties.put('name', 'Spin_the_game')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("/Users/eiralee/EiraLi-Katalon_API/Reports/Spin_the_game/20190708_115956/execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/Spin_the_game', suiteProperties, [new TestCaseBinding('Test Cases/Login - Iteration 1', 'Test Cases/Login',  [ 'userid' : 'eira_bbin_0001' , 'secret_key' : '418184e911563cd861e90db6233d7d6c' , 'url_krug_gw' : 'krug-gw-colo.star9ad.com' , 'url_nurgs' : 'nurgs.star9ad.com' , 'partner' : 'c304afdf-2f61-6369-c088-924f99e1be1a' , 'game_code' : 'NG-0063' ,  ]), new TestCaseBinding('Test Cases/Login - Iteration 2', 'Test Cases/Login',  [ 'userid' : 'Eira_BG_stg_01' , 'secret_key' : '69035e6c-7aec-4dec-af6d-fa81c26588b6' , 'url_krug_gw' : 'krug-gw-colo.star9ad.com' , 'url_nurgs' : 'nurgs.star9ad.com' , 'partner' : '72bbe33f-0ed2-af05-4930-577a01649c48' , 'game_code' : 'NG-0063' ,  ]), new TestCaseBinding('Test Cases/Login - Iteration 3', 'Test Cases/Login',  [ 'userid' : 'Radi8_stg_01' , 'secret_key' : '1461871a-3e65-4edb-9f88-0e267948ed39' , 'url_krug_gw' : 'krug-gw-colo.star9ad.com' , 'url_nurgs' : 'nurgs.star9ad.com' , 'partner' : 'dcd887e5-5069-45d1-8a5a-b9af9b646f15' , 'game_code' : 'NG-0063' ,  ]), new TestCaseBinding('Test Cases/Spin - Iteration 1', 'Test Cases/Spin',  [ 'choice' : 'FS_20' , 'url_nurgs' : 'nurgs.star9ad.com' , 'player_id' : 'eira_bbin_0001' , 'game_code' : 'NG-0063' , 'partner_code' : 'BBIN' ,  ]), new TestCaseBinding('Test Cases/Spin - Iteration 2', 'Test Cases/Spin',  [ 'choice' : 'FS_20' , 'url_nurgs' : 'nurgs.star9ad.com' , 'player_id' : 'Eira_BG_stg_01' , 'game_code' : 'NG-0063' , 'partner_code' : 'BG' ,  ]), new TestCaseBinding('Test Cases/Spin - Iteration 3', 'Test Cases/Spin',  [ 'choice' : 'FS_20' , 'url_nurgs' : 'nurgs.star9ad.com' , 'player_id' : 'Radi8_stg_01' , 'game_code' : 'NG-0063' , 'partner_code' : 'GT_Radi8' ,  ])])
