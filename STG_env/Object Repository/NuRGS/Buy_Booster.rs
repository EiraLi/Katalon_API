<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Buy_Booster</name>
   <tag></tag>
   <elementGuidId>37b42efb-e371-4237-b41c-f20fd9d2b45a</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t\&quot;action\&quot;: \&quot;BUY_BOOSTER\&quot;,\n\t\&quot;booster_id\&quot;: \&quot;FreeSpinBooster-005\&quot;,\n\t\&quot;booster_type\&quot;: \&quot;REGULAR\&quot;,\n\t\&quot;game_code\&quot;: \&quot;${game_code}\&quot;,\n\t\&quot;partner_code\&quot;: \&quot;${partner_code}\&quot;,\n\t\&quot;player_id\&quot;: \&quot;${userid}\&quot;,\n\t\&quot;quantity\&quot;: 10,\n\t\&quot;session_token\&quot;: \&quot;${rgs_session_token}\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://${url_nurgs}/ng/take-turn/</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(9, 1)</defaultValue>
      <description></description>
      <id>d5b2d7d5-4dfe-483d-bef9-5b7638505fe1</id>
      <masked>false</masked>
      <name>url_nurgs</name>
   </variables>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(5, 1)</defaultValue>
      <description></description>
      <id>2ad2d24b-0a25-4ab4-9a12-4889bfabb11e</id>
      <masked>false</masked>
      <name>game_code</name>
   </variables>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(1, 1)</defaultValue>
      <description></description>
      <id>783d066f-0074-4dcf-8fa8-ed0ac95ad482</id>
      <masked>false</masked>
      <name>partner_code</name>
   </variables>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(4, 1)</defaultValue>
      <description></description>
      <id>6eeea9f4-ec28-40a1-9e26-6a53b15d0009</id>
      <masked>false</masked>
      <name>userid</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.rgs_session_token</defaultValue>
      <description></description>
      <id>6586e5a1-1446-4b2c-b43b-e7b5a35af72d</id>
      <masked>false</masked>
      <name>rgs_session_token</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
WS.verifyResponseStatusCode(response, 200)

assertThat(response.getStatusCode()).isEqualTo(200)


def buy_booster = new groovy.json.JsonSlurper()
def result_buy_booster = buy_booster.parseText(response.getResponseBodyContent())


def result_booster_type = result_buy_booster.type
println(&quot;booster type is: &quot; + result_booster_type)
GlobalVariable.result_booster_type = result_booster_type</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
