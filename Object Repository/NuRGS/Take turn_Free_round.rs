<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Take turn_Free_round</name>
   <tag></tag>
   <elementGuidId>d1ce420c-c6ec-4aba-8972-3155d19743b5</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;action\&quot;: \&quot;CONSUME_FREE_ROUND\&quot;,\n\t\&quot;bonus_provider_ref\&quot;: \&quot;GENPLUS\&quot;,\n\t\&quot;bonus_provider_ref_id\&quot;: \&quot;genplus\&quot;,\n\t\&quot;booster_type\&quot;: \&quot;REGULAR\&quot;,\n\t\&quot;game_code\&quot;: \&quot;${game_code}\&quot;,\n\t\&quot;partner_code\&quot;: \&quot;${partner_code}\&quot;,\n\t\&quot;player_id\&quot;: \&quot;${player_id}\&quot;,\n\t\&quot;session_token\&quot;: \&quot;${rgs_session_token}\&quot;,\n\t\&quot;state_tag\&quot;: \&quot;${state_tag}\&quot;\n}&quot;,
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
      <id>a39fbb1c-47b8-4430-9065-bf7403335def</id>
      <masked>false</masked>
      <name>url_nurgs</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.game_code</defaultValue>
      <description></description>
      <id>9980efa8-614b-4be7-9662-bc62c086a774</id>
      <masked>false</masked>
      <name>game_code</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.partner_code</defaultValue>
      <description></description>
      <id>ea9678e9-dd27-4949-b983-fb75302482c0</id>
      <masked>false</masked>
      <name>partner_code</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.player_id</defaultValue>
      <description></description>
      <id>9e025e9d-cc2e-48e4-b2dc-d8ca79895243</id>
      <masked>false</masked>
      <name>player_id</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.rgs_session_token</defaultValue>
      <description></description>
      <id>788dd6c6-6bc4-452f-ac64-3a763cdbd6f2</id>
      <masked>false</masked>
      <name>rgs_session_token</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.state_tag</defaultValue>
      <description></description>
      <id>92bba966-13e1-461f-8421-7ac930a76231</id>
      <masked>false</masked>
      <name>state_tag</name>
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


def spin = new groovy.json.JsonSlurper()
def result_spin = spin.parseText(response.getResponseBodyContent())

def rgs_session_token = result_spin.session_token
println(&quot;rgssessiontoken is: &quot;+rgs_session_token)
GlobalVariable.rgs_session_token = rgs_session_token
println(&quot;GlobalVariable rgssessiontoken is: &quot;+GlobalVariable.rgs_session_token)

def state_tag = result_spin.state_tag
println(&quot;state tag is: &quot;+state_tag)
GlobalVariable.state_tag = state_tag
println(&quot;GlobalVariable state tag is: &quot;+GlobalVariable.state_tag)

def features = result_spin.features
println(&quot;feature is: &quot;+features)
GlobalVariable.features = features

def player_id = result_spin.player_id
println(&quot;playerid is: &quot;+player_id)
GlobalVariable.player_id = player_id
println(&quot;GlobalVariable playerid is: &quot;+GlobalVariable.player_id)

def game_code = result_spin.game_code
println(&quot;gamecode is: &quot;+game_code)
GlobalVariable.game_code = game_code
println(&quot;GlobalVariable  gamecode is: &quot;+GlobalVariable.game_code)

def round_id = result_spin.round_id
println(&quot;round id is: &quot;+round_id)
GlobalVariable.round_id = round_id

def transaction_id = result_spin.spin_result.causality
println(&quot;transaction id is: &quot;+ transaction_id)
GlobalVariable.transaction_id = transaction_id


if (features != null) {		// Free Spin Triggered
	def features_type = result_spin.features[0].type
	println (&quot;...value extracted is :&quot;+features)
	GlobalVariable.features_type = features_type
	println (&quot;features is :&quot;+GlobalVariable.features_type)
	
	if (&quot;PICK&quot;.equals(features_type)) {
		def free_spin_pick = result_spin.features[0].complete
		GlobalVariable.free_spin_pick = free_spin_pick
		println (&quot;free spin pick is :&quot;+GlobalVariable.free_spin_pick)
		
		if (free_spin_pick == true) {		// Free Spin Picked
			def free_spin_complete = result_spin.features[1].complete
			GlobalVariable.free_spin_complete = free_spin_complete
			println (&quot;free spin complete is :&quot;+GlobalVariable.free_spin_complete)
			def free_spin_left = result_spin.features[1].feature_state.free_spins_left
			GlobalVariable.free_spin_left = free_spin_left
			println (&quot;free spins left is :&quot;+GlobalVariable.free_spin_left)
		}
	}	
}</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
