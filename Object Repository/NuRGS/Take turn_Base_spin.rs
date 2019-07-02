<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Take turn_Base_spin</name>
   <tag></tag>
   <elementGuidId>6991e0ef-ae82-4a41-badb-76476612ca02</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n   \&quot;player_id\&quot;: \&quot;${player_id}\&quot;,\n   \&quot;partner_code\&quot;: \&quot;${partner_code}\&quot;,\n   \&quot;game_code\&quot;: \&quot;${game_code}\&quot;,\n   \&quot;action\&quot;: \&quot;SPIN\&quot;,\n   \&quot;session_token\&quot;: \&quot;${rgs_session_token}\&quot;,\n   \&quot;state_tag\&quot;:\&quot;${state_tag}\&quot;,\n   \&quot;bet_denom_index\&quot;: 1\n}&quot;,
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
   <restUrl>https://${url}/ng/take-turn/</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'nurgs.star9ad.com'</defaultValue>
      <description></description>
      <id>2cf333ad-8d5b-4667-afc9-8c7f1fb80329</id>
      <masked>false</masked>
      <name>url</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.player_id</defaultValue>
      <description></description>
      <id>d5dd7ad8-bc8e-4a49-993a-9b587d2c9196</id>
      <masked>false</masked>
      <name>player_id</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.partner_code</defaultValue>
      <description></description>
      <id>beaedb8a-71d5-4c32-81ab-35c008f664cb</id>
      <masked>false</masked>
      <name>partner_code</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.game_code</defaultValue>
      <description></description>
      <id>10190623-722c-48e7-8aec-c48e977dbe1b</id>
      <masked>false</masked>
      <name>game_code</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.rgs_session_token</defaultValue>
      <description></description>
      <id>ecdb0e4b-4254-4d39-8513-da2357208313</id>
      <masked>false</masked>
      <name>rgs_session_token</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.state_tag</defaultValue>
      <description></description>
      <id>8402beae-f830-4959-806d-774e15c59b46</id>
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

def balance = result_spin.balance
println(&quot;balance is: &quot;+balance)
GlobalVariable.balance = balance

def round_id = result_spin.round_id
println(&quot;round id is: &quot;+round_id)
GlobalVariable.round_id = round_id

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
}

else if (features != null){
	if (features_type == 'FREE_SPIN'){
		def free_spin_left = result_login.state.features[0].feature_state.free_spin_left
		GlobalVariable.free_spin_left = free_spin_left
		println(&quot;free_spin_left is: &quot;+ free_spin_left)

		def free_spin_complete = result_login.state.features[0].complete
	}
}</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
