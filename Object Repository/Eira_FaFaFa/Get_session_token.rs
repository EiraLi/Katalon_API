<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Get_session_token</name>
   <tag></tag>
   <elementGuidId>b321c1b7-c49b-40ca-b032-c29513009e66</elementGuidId>
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
      <id>b34cb05a-23a7-40c3-b2d0-ee324b6b0c2d</id>
      <masked>false</masked>
      <name>url</name>
   </variables>
   <variables>
      <defaultValue>'eira_bbin_0001'</defaultValue>
      <description></description>
      <id>909b1adf-0f58-46ef-9e3e-016e81e379b6</id>
      <masked>false</masked>
      <name>player_id</name>
   </variables>
   <variables>
      <defaultValue>'c304afdf-2f61-6369-c088-924f99e1be1a'</defaultValue>
      <description></description>
      <id>3bd3a299-4f5d-4b2a-9129-f86b90389141</id>
      <masked>false</masked>
      <name>partner</name>
   </variables>
   <variables>
      <defaultValue>'418184e911563cd861e90db6233d7d6c'</defaultValue>
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
