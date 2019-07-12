<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>RoundId_detail api</name>
   <tag></tag>
   <elementGuidId>7b46aee5-5599-4c60-8123-c7f3c7a58ee3</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-Genesis-PartnerToken</name>
      <type>Main</type>
      <value>${partner}</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://${partner}-rgs-history.star9ad.com/api/slot/roundid/${round_id}?game_code=${game_code}&amp;partner_code=${partner_code}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(2, 1)</defaultValue>
      <description></description>
      <id>b25b912c-cef5-47b7-981a-a5828de53ef1</id>
      <masked>false</masked>
      <name>partner</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.round_id</defaultValue>
      <description></description>
      <id>21a919fb-b076-40cd-a775-2574a044406f</id>
      <masked>false</masked>
      <name>round_id</name>
   </variables>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(5, 1)</defaultValue>
      <description></description>
      <id>70274c3b-29cc-4931-bf3a-357ea56fb12e</id>
      <masked>false</masked>
      <name>game_code</name>
   </variables>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(1, 1)</defaultValue>
      <description></description>
      <id>09b91a80-a0cf-4613-b518-b56e7ea5ab31</id>
      <masked>false</masked>
      <name>partner_code</name>
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


def roundid_detail = new groovy.json.JsonSlurper()
def result_roundid_detail = roundid_detail.parseText(response.getResponseBodyContent())


def round_detail_transaction_id = result_roundid_detail.spin_results[0].transaction_id
println(&quot;transaction id is:&quot; +round_detail_transaction_id)
GlobalVariable.round_detail_transaction_id = round_detail_transaction_id

def round_detail_balance = result_roundid_detail.spin_results[0].balance
println(&quot;balance is:&quot; +round_detail_balance)
GlobalVariable.round_detail_balance = round_detail_balance

def player_id = result_roundid_detail.player_id
println(&quot;player id is:&quot; +player_id)
GlobalVariable.player_id = player_id</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
