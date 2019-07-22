<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>M4_spin _backup</name>
   <tag></tag>
   <elementGuidId>a10ae2d7-666e-46ad-a3af-ea3e81c5b007</elementGuidId>
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


//def M4_reels_spin_result = result_M4_spin.spin_result
//GlobalVariable.M4_reels_spin_result = M4_reels_spin_result
//
//def M4_reel3_symbol1 = result_M4_spin.spin_result.reels[2].symbols[0]
//GlobalVariable.M4_reel3_symbol1 = M4_reel3_symbol1
//println(&quot;M4_reel3_symbol1 is:&quot;+M4_reel3_symbol1)
//
//def M4_reel3_symbol2 = result_M4_spin.spin_result.reels[2].symbols[1]
//GlobalVariable.M4_reel3_symbol2 = M4_reel3_symbol2
//println(&quot;M4_reel3_symbol2 is:&quot;+M4_reel3_symbol2)
//
//def M4_reel3_symbol3 = result_M4_spin.spin_result.reels[2].symbols[2]
//GlobalVariable.M4_reel3_symbol3 = M4_reel3_symbol3
//println(&quot;M4_reel3_symbol3 is:&quot;+M4_reel3_symbol3)
//
//def M4_reel4_symbol1 = result_M4_spin.spin_result.reels[3].symbols[0]
//GlobalVariable.M4_reel4_symbol1 = M4_reel4_symbol1
//println(&quot;M4_reel4_symbol1 is:&quot;+M4_reel4_symbol1)
//
//def M4_reel4_symbol2 = result_M4_spin.spin_result.reels[3].symbols[1]
//GlobalVariable.M4_reel4_symbol2 = M4_reel4_symbol2
//println(&quot;M4_reel4_symbol2 is:&quot;+M4_reel4_symbol2)

//def M4_reel4_symbol3 = result_M4_spin.spin_result.reels[3].symbols[2]
//GlobalVariable.M4_reel4_symbol3 = M4_reel4_symbol3
//println(&quot;M4_reel4_symbol3 is:&quot;+M4_reel4_symbol3)
//
//def M4_reel5_symbol1 = result_M4_spin.spin_result.reels[4].symbols[0]
//GlobalVariable.M4_reel5_symbol1 = M4_reel5_symbol1
//println(&quot;M4_reel5_symbol1 is:&quot;+M4_reel5_symbol1)
//
//def M4_reel5_symbol2 = result_M4_spin.spin_result.reels[4].symbols[1]
//GlobalVariable.M4_reel5_symbol2 = M4_reel5_symbol2
//println(&quot;M4_reel5_symbol2 is:&quot;+M4_reel5_symbol2)
//
//def M4_reel5_symbol3 = result_M4_spin.spin_result.reels[4].symbols[2]
//GlobalVariable.M4_reel5_symbol3 = M4_reel5_symbol3
//println(&quot;M4_reel5_symbol3 is:&quot;+M4_reel5_symbol3)


def reels = result_spin.spin_result.reels
def reel3_sym1 = result_spin.spin_result.reels[2].symbols[0].reel_position
def reel3_sym2 = result_spin.spin_result.reels[2].symbols[1].reel_position
def reel3_sym3 = result_spin.spin_result.reels[2].symbols[2].reel_position
def reel4_sym1 = result_spin.spin_result.reels[3].symbols[0].reel_position
def reel4_sym2 = result_spin.spin_result.reels[3].symbols[1].reel_position
def reel4_sym3 = result_spin.spin_result.reels[3].symbols[2].reel_position
def reel5_sym1 = result_spin.spin_result.reels[4].symbols[0].reel_position
def reel5_sym2 = result_spin.spin_result.reels[4].symbols[1].reel_position
def reel5_sym3 = result_spin.spin_result.reels[4].symbols[2].reel_position

GlobalVariable.reel3_sym1 = reel3_sym1
GlobalVariable.reel3_sym2 = reel3_sym2
GlobalVariable.reel3_sym3 = reel3_sym3
GlobalVariable.reel4_sym1 = reel4_sym1
GlobalVariable.reel4_sym2 = reel4_sym2
GlobalVariable.reel4_sym3 = reel4_sym3
GlobalVariable.reel5_sym1 = reel5_sym1
GlobalVariable.reel5_sym2 = reel5_sym2
GlobalVariable.reel5_sym3 = reel5_sym3

// Check if reel3 has symbo &quot;W&quot;
if (GlobalVariable.reel3_sym1 == 4
	|| GlobalVariable.reel3_sym1 == 7
	|| GlobalVariable.reel3_sym1 == 10
	|| GlobalVariable.reel3_sym1 == 13
	|| GlobalVariable.reel3_sym1 == 16
	|| GlobalVariable.reel3_sym1 == 26) {
		reel3_sym1_has_wild == true
		GlobalVariable.reel3_sym1_w = reel3_sym1_has_wild
}
if (GlobalVariable.reel3_sym2 == 4
	|| GlobalVariable.reel3_sym2 == 7
	|| GlobalVariable.reel3_sym2 == 10
	|| GlobalVariable.reel3_sym2 == 13
	|| GlobalVariable.reel3_sym2 == 16
	|| GlobalVariable.reel3_sym2 == 26) {
		reel3_sym2_has_wild == true
		GlobalVariable.reel3_sym2_w = reel3_sym2_has_wild
}
if (GlobalVariable.reel3_sym3 == 4
	|| GlobalVariable.reel3_sym3 == 7
	|| GlobalVariable.reel3_sym3 == 10
	|| GlobalVariable.reel3_sym3 == 13
	|| GlobalVariable.reel3_sym3 == 16
	|| GlobalVariable.reel3_sym3 == 26) {
		reel3_sym3_has_wild == true
		GlobalVariable.reel3_sym3_w = reel3_sym3_has_wild
}
if (true.equals(GlobalVariable.reel3_sym1_w)||true.equals(GlobalVariable.reel3_sym2_w)||true.equals(GlobalVariable.reel3_sym3_w)) {
	reel3_has_wild == true
	GlobalVariable.reel3_w = reel3_has_wild
}

// Check if reel4 has symbo &quot;W&quot;
if (GlobalVariable.reel4_sym1 == 4
	|| GlobalVariable.reel4_sym1 == 7
	|| GlobalVariable.reel4_sym1 == 10
	|| GlobalVariable.reel4_sym1 == 13
	|| GlobalVariable.reel4_sym1 == 16) {
		reel4_sym1_has_wild == true
		GlobalVariable.reel4_sym1_w = reel4_sym1_has_wild
}
if (GlobalVariable.reel4_sym2 == 4
	|| GlobalVariable.reel4_sym2 == 7
	|| GlobalVariable.reel4_sym2 == 10
	|| GlobalVariable.reel4_sym2 == 13
	|| GlobalVariable.reel4_sym2 == 16) {
		reel4_sym2_has_wild == true
		GlobalVariable.reel4_sym2_w = reel4_sym2_has_wild
}
if (GlobalVariable.reel4_sym3 == 4
	|| GlobalVariable.reel4_sym3 == 7
	|| GlobalVariable.reel4_sym3 == 10
	|| GlobalVariable.reel4_sym3 == 13
	|| GlobalVariable.reel4_sym3 == 16) {
		reel4_sym3_has_wild == true
		GlobalVariable.reel4_sym3_w = reel4_sym3_has_wild
}
if (true.equals(GlobalVariable.reel4_sym1_w)||true.equals(GlobalVariable.reel4_sym2_w)||true.equals(GlobalVariable.reel4_sym3_w)) {
	reel4_has_wild == true
	GlobalVariable.reel4_w = reel4_has_wild
}

// Check if reel5 has symbo &quot;W&quot;
if (GlobalVariable.reel5_sym1 == 4
	|| GlobalVariable.reel5_sym1 == 7
	|| GlobalVariable.reel5_sym1 == 10) {
		reel5_sym1_has_wild == true
		GlobalVariable.reel5_sym1_w = reel5_sym1_has_wild
}
if (GlobalVariable.reel5_sym2 == 4
	|| GlobalVariable.reel5_sym2 == 7
	|| GlobalVariable.reel5_sym2 == 10) {
		reel5_sym2_has_wild == true
		GlobalVariable.reel5_sym2_w = reel5_sym2_has_wild
}

if (GlobalVariable.reel5_sym3 == 4
	|| GlobalVariable.reel5_sym3 == 7
	|| GlobalVariable.reel5_sym3 == 10) {
		reel5_sym3_has_wild == true
		GlobalVariable.reel5_sym3_w = reel5_sym3_has_wild
}
if (true.equals(GlobalVariable.reel5_sym1_w)||true.equals(GlobalVariable.reel5_sym2_w)||true.equals(GlobalVariable.reel5_sym3_w)) {
	reel5_has_wild == true
	GlobalVariable.reel5_w = reel5_has_wild
}


</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
