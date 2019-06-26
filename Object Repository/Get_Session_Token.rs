<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Get_Session_Token</name>
   <tag></tag>
   <elementGuidId>f5c53b73-b0b1-4f21-8ef8-d2cabef77341</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
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
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content</name>
      <type>Main</type>
      <value>application/json</value>
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
      <defaultValue>'krug-gw-colo.star9ad.com'</defaultValue>
      <description></description>
      <id>5d243f24-169e-4a0c-b172-7c0f24ad8425</id>
      <masked>false</masked>
      <name>url</name>
   </variables>
   <variables>
      <defaultValue>'c304afdf-2f61-6369-c088-924f99e1be1a'</defaultValue>
      <description></description>
      <id>f6c5ad29-4d99-41d2-b17e-a8fdfb1fdd64</id>
      <masked>false</masked>
      <name>partner</name>
   </variables>
   <variables>
      <defaultValue>'418184e911563cd861e90db6233d7d6c'</defaultValue>
      <description></description>
      <id>fddf52b3-f2fb-4c1e-9b9a-d102c8badab7</id>
      <masked>false</masked>
      <name>secretkey</name>
   </variables>
   <variables>
      <defaultValue>'86577271'</defaultValue>
      <description></description>
      <id>ffde4b70-b21c-4392-83bc-9064107d82de</id>
      <masked>false</masked>
      <name>player_id</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.session_token</defaultValue>
      <description></description>
      <id>52fcf816-ab29-4750-9b6f-28004d9ac628</id>
      <masked>false</masked>
      <name>session_token</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager


RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable


WS.verifyResponseStatusCode(response, 200)

assertThat(response.getStatusCode()).isEqualTo(200)
assertThat(response.getResponseText()).contains('session_token')

def getsession = new groovy.json.JsonSlurper()
def result_getsession = getsession.parseText(response.getResponseBodyContent())

def session_token = result_getsession.session_token
println (&quot;...value extracted is :&quot;+session_token)

GlobalVariable.session_token = session_token
println (&quot;GlobalVariable is :&quot;+GlobalVariable.session_token)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
