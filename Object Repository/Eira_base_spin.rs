<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Eira_base_spin</name>
   <tag></tag>
   <elementGuidId>50fe5eeb-5be8-4964-906a-ca524fbed94e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n   \&quot;player_id\&quot;: \&quot;${player_id}\&quot;,\n   \&quot;partner_code\&quot;: \&quot;${partner_code}\&quot;,\n   \&quot;game_code\&quot;: \&quot;${rgs_game_code}\&quot;,\n   \&quot;action\&quot;: \&quot;SPIN\&quot;,\n   \&quot;session_token\&quot;: \&quot;${rgs_session_token}\&quot;,\n   \&quot;state_tag\&quot;:\&quot;${state_tag}\&quot;,\n   \&quot;bet_denom_index\&quot;: 1\n}&quot;,
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
      <id>46ae686d-6176-4b1d-a481-ed6a5f2a15b4</id>
      <masked>false</masked>
      <name>url</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.partner_code</defaultValue>
      <description></description>
      <id>6e487f8b-e95b-4afe-85e2-4e55824dfa79</id>
      <masked>false</masked>
      <name>partner_code</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.rgs_game_code</defaultValue>
      <description></description>
      <id>d9c5225a-0d21-4103-bd23-ed56cdcb2638</id>
      <masked>false</masked>
      <name>rgs_game_code</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.session_token</defaultValue>
      <description></description>
      <id>2cc4d45f-64fa-46a4-9e35-58572f506d01</id>
      <masked>false</masked>
      <name>session_token</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.state_tag</defaultValue>
      <description></description>
      <id>93aea683-cdb4-46dd-b91a-645b20eceda0</id>
      <masked>false</masked>
      <name>statetag</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import net.bytebuddy.implementation.bytecode.constant.NullConstant

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()




WS.verifyResponseStatusCode(response, 200)

assertThat(response.getStatusCode()).isEqualTo(200)

def spin = new groovy.json.JsonSlurper()
def result_spin = spin.parseText(response.getResponseBodyContent())

def rgssessiontoken = result_spin.session_token
println (&quot;...value extracted is :&quot;+rgssessiontoken)
GlobalVariable.rgs_session_token = rgssessiontoken
println (&quot;rgs session is :&quot;+GlobalVariable.rgs_session_token)




def statetag = result_spin.state_tag
println (&quot;...value extracted is :&quot;+statetag)
GlobalVariable.state_tag = statetag
println (&quot;state tag is :&quot;+GlobalVariable.state_tag)

def playerid = result_spin.player_id
println (&quot;...value extracted is :&quot;+playerid)
GlobalVariable.player_id = playerid
println (&quot;player id is :&quot;+GlobalVariable.player_id)

def rgsgamecode = result_spinn.state.game_code
println (&quot;...value extracted is :&quot;+rgsgamecode)
GlobalVariable.rgs_game_code = rgsgamecode
println (&quot;game code is :&quot;+GlobalVariable.rgs_game_code)

def features = result_spin.features
println (&quot;...value extracted is :&quot;+features)
GlobalVariable.features = features
println (&quot;features is :&quot;+GlobalVariable.features)

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
