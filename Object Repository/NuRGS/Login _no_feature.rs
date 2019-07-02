<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Login _no_feature</name>
   <tag></tag>
   <elementGuidId>b54e0d21-5bf6-40ea-a677-19856669c340</elementGuidId>
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
      <defaultValue>'db7b3a43-89c6-3751-16e6-baa24434b393'</defaultValue>
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
      <defaultValue>'M4-0086'</defaultValue>
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

def login = new groovy.json.JsonSlurper()
def result_login = login.parseText(response.getResponseBodyContent())

def player_id = result_login.state.player_id
println(&quot;playerid is: &quot;+player_id)
GlobalVariable.player_id = player_id
println(&quot;GlobalVariable playerid is: &quot;+GlobalVariable.player_id)

def rgs_session_token = result_login.state.session_token
println(&quot;rgssessiontoken is: &quot;+rgs_session_token)
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


</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
