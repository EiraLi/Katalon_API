<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Take turn - Copy</name>
   <tag></tag>
   <elementGuidId>b8ffa91e-3254-4ece-b8aa-6c28b4efda52</elementGuidId>
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
def result_spin = spin.parseText(response.getResponseText())

def round_id = result_spin.round_id
println(&quot;round_id is: &quot;+round_id)

def session_token = result_spin.session_token
println(&quot;RGS session token is: &quot;+session_token)






</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
