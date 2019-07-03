<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Login _free_spin_PICK</name>
   <tag></tag>
   <elementGuidId>d2dc733c-b1b4-42c8-8a37-f9ec7a705fb1</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;partner_token\&quot;: \&quot;${partner}\&quot;,\n    \&quot;player_token\&quot;: \&quot;${session_token}\&quot;,\n    \&quot;game_code\&quot;: \&quot;${game_code}\&quot;,\n    \&quot;device\&quot;: \&quot;DESKTOP\&quot;\n}&quot;,
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
   <restUrl>https://${url}/ng/sessions/</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'nurgs.star9ad.com'</defaultValue>
      <description></description>
      <id>51de37a1-214f-44c0-84df-e9d23b10b819</id>
      <masked>false</masked>
      <name>url</name>
   </variables>
   <variables>
      <defaultValue>'c304afdf-2f61-6369-c088-924f99e1be1a'</defaultValue>
      <description></description>
      <id>8e6df285-f1ab-49b2-ba64-7c98fc25af9f</id>
      <masked>false</masked>
      <name>partner</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.session_token</defaultValue>
      <description></description>
      <id>8e8745ee-3c35-4d42-aa82-ae06b3bfe8d9</id>
      <masked>false</masked>
      <name>session_token</name>
   </variables>
   <variables>
      <defaultValue>'NG-0063'</defaultValue>
      <description></description>
      <id>c24c9290-273a-447c-a42d-68ed8e13a9c1</id>
      <masked>false</masked>
      <name>game_code</name>
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
def login = new groovy.json.JsonSlurper()
def result_login = login.parseText(response.getResponseBodyContent())

def player_id = result_login.state.player_id
println(&quot;playerid is: &quot;+player_id)
GlobalVariable.player_id = player_id
println(&quot;GlobalVariable playerid is: &quot;+GlobalVariable.player_id)

def rgs_session_token = result_login.state.session_token
println(&quot;**** rgssessiontoken is: ****&quot; + newline + rgs_session_token)
GlobalVariable.rgs_session_token = rgs_session_token
println(&quot;GlobalVariable rgssessiontoken is: &quot;+GlobalVariable.rgs_session_token)

def partner_code = result_login.state.partner_code
println(&quot;partnercode is: &quot;+partner_code)
GlobalVariable.partner_code = partner_code
println(&quot;GlobalVariable partner code is: &quot;+GlobalVariable.partner_code)

def state_tag = result_login.state.state_tag
println(&quot;state tag is: &quot;+state_tag)
GlobalVariable.state_tag = state_tag
println(&quot;GlobalVariable state tag is: &quot;+GlobalVariable.state_tag)

def game_code = result_login.state.game_code
println(&quot;gamecode is: &quot;+game_code)
GlobalVariable.game_code = game_code
println(&quot;GlobalVariable  gamecode is: &quot;+GlobalVariable.game_code)

def features = result_login.state.features
println(&quot;feature is: &quot;+features)
GlobalVariable.features = features


if (features != null){   //有無 trigger feature
	def features_type = result_login.state.features[0].type
	GlobalVariable.features_type = features_type
	println (&quot;feature type is:&quot; +GlobalVariable.features_type)

	if (features_type == &quot;PICK&quot;){    //pick 了沒
		def free_spin_pick = result_login.state.features[0].complete
		GlobalVariable.free_spin_pick = free_spin_pick
		println (&quot;free spin pick complete is &quot;+GlobalVariable.free_spin_pick)
		
		if (free_spin_pick == true){ //free spin complete 了沒
			def free_spin_complete = result_login.state.features[1].complete
			GlobalVariable.free_spin_complete = free_spin_complete
			println(&quot;free spin complete is; &quot;+GlobalVariable.free_spin_complete)
		  
			def free_spin_left = result_login.state.features[1].feature_state.free_spins_left
			GlobalVariable.free_spin_left = free_spin_left
			println (&quot;free_spin_left is: &quot;+free_spin_left)
		}
	}
}


</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>