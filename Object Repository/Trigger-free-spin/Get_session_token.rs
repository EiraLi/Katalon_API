<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Get_session_token</name>
   <tag></tag>
   <elementGuidId>da8618b7-6065-40de-ad0a-f464367cbef1</elementGuidId>
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
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-Genesis-Secret</name>
      <type>Main</type>
      <value>${secretkey}</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://${url}/m4/wallet/balance/${player_id}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'krug-gw.star0ad.com'</defaultValue>
      <description></description>
      <id>b34cb05a-23a7-40c3-b2d0-ee324b6b0c2d</id>
      <masked>false</masked>
      <name>url</name>
   </variables>
   <variables>
      <defaultValue>'NewBBINTEST_TestUserCNY'</defaultValue>
      <description></description>
      <id>909b1adf-0f58-46ef-9e3e-016e81e379b6</id>
      <masked>false</masked>
      <name>player_id</name>
   </variables>
   <variables>
      <defaultValue>'f0841d74-6a7d-f0a0-8779-df0dc556f150'</defaultValue>
      <description></description>
      <id>3bd3a299-4f5d-4b2a-9129-f86b90389141</id>
      <masked>false</masked>
      <name>partner</name>
   </variables>
   <variables>
      <defaultValue>'cac491ae-bc9e-4385-80d3-d1093803a266'</defaultValue>
      <description></description>
      <id>ef4b9051-5f69-4cb4-b8de-1c48cddd51da</id>
      <masked>false</masked>
      <name>secretkey</name>
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
assertThat(response.getResponseText()).contains('session_token')



def getsession = new groovy.json.JsonSlurper()

def result_getsession = getsession.parseText(response.getResponseText())

def session_token = result_getsession.session_token
println (&quot;sessiontoken is: &quot;+session_token)

GlobalVariable.session_token = session_token
println (&quot;GlobalVariable session token is: &quot;+ GlobalVariable.session_token)



</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
