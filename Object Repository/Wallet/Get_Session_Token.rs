<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Get_Session_Token</name>
   <tag></tag>
   <elementGuidId>e8173dd6-183c-453e-93a6-81958845e3b2</elementGuidId>
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
   <restUrl>https://${url}/m4/wallet/balance/${userid1}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'krug-gw-colo.star9ad.com'</defaultValue>
      <description></description>
      <id>554f690c-0692-4fbb-b227-1308f2704a34</id>
      <masked>false</masked>
      <name>url</name>
   </variables>
   <variables>
      <defaultValue>'c304afdf-2f61-6369-c088-924f99e1be1a'</defaultValue>
      <description></description>
      <id>a27a4b76-8f6d-499b-99bb-2225e73648ef</id>
      <masked>false</masked>
      <name>partner</name>
   </variables>
   <variables>
      <defaultValue>'418184e911563cd861e90db6233d7d6c'</defaultValue>
      <description></description>
      <id>bc1aa9f1-3227-4e06-8086-ddc3ac08076b</id>
      <masked>false</masked>
      <name>secretkey</name>
   </variables>
   <variables>
      <defaultValue>'eira_bbin_0001'</defaultValue>
      <description></description>
      <id>109b3b45-4200-4d2e-8f75-13d024bc39e1</id>
      <masked>false</masked>
      <name>userid1</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.session_token</defaultValue>
      <description></description>
      <id>fdb33f66-d8b4-4276-b45d-f6a4c958bc45</id>
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
