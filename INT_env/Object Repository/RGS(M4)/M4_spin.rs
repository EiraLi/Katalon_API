<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>M4_spin</name>
   <tag></tag>
   <elementGuidId>433205d8-6028-482f-bfd3-d5f69d32aa52</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;channel\&quot;: \&quot;desktop\&quot;,\n    \&quot;bet\&quot;: 4000,\n    \&quot;lines\&quot;: 1,\n    \&quot;multiplier\&quot;: 1,\n    \&quot;currency\&quot;: \&quot;CNY\&quot;,\n    \&quot;points\&quot;: null,\n    \&quot;key\&quot;: null\n}&quot;,
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
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-Genesis-PartnerToken</name>
      <type>Main</type>
      <value>${partner}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-Genesis-UserId</name>
      <type>Main</type>
      <value>${M4_login_user_id}</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://${partner}.${env}/m4/gameservice/play/spin/${rgs_session_token}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>findTestData('INT_data').getValue(2, 1)</defaultValue>
      <description></description>
      <id>99897394-4418-4e6e-a521-87b62170e853</id>
      <masked>false</masked>
      <name>partner</name>
   </variables>
   <variables>
      <defaultValue>findTestData('INT_data').getValue(14, 1)</defaultValue>
      <description></description>
      <id>1bcdeea7-774c-47e2-9ce2-1ddde49b3d91</id>
      <masked>false</masked>
      <name>env</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.rgs_session_token</defaultValue>
      <description></description>
      <id>2c910b07-c4c2-4c3b-af34-d0498d55e78d</id>
      <masked>false</masked>
      <name>rgs_session_token</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.M4_login_user_id</defaultValue>
      <description></description>
      <id>ce8bc744-ce25-4570-881c-fdf065533011</id>
      <masked>false</masked>
      <name>M4_Login_user_id</name>
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


String newline = System.getProperty(&quot;line.separator&quot;)
def M4_spin = new groovy.json.JsonSlurper()
def result_M4_spin = M4_spin.parseText(response.getResponseBodyContent())

def M4_spin_current_balance = result_M4_spin.current_balance
GlobalVariable.M4_spin_current_balance = M4_spin_current_balance

def M4_spin_transaction_id = result_M4_spin.spin_result.causality
GlobalVariable.M4_spin_transaction_id = M4_spin_transaction_id

def M4_total_bonus_spins = result_M4_spin.spin_result.bonus.bonus_data[0].get('properties').total_bonus_spins
GlobalVariable.M4_total_bonus_spins = M4_total_bonus_spins
println(&quot;M4_total_bonus_spins is:&quot;+GlobalVariable.M4_total_bonus_spins)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
