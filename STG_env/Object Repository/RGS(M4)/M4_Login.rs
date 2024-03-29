<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>M4_Login</name>
   <tag></tag>
   <elementGuidId>75ed7e38-2b83-41cc-a1bb-4b7b228637e5</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;login_properties\&quot;: [\n    {\n      \&quot;name\&quot;: \&quot;session_token\&quot;,\n      \&quot;value\&quot;: \&quot;${session_token}\&quot;\n    },\n    {\n      \&quot;name\&quot;: \&quot;game_id\&quot;,\n      \&quot;value\&quot;: \&quot;${game_code}\&quot;\n    }\n  ]\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
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
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://${partner}.${env}/m4/gameservice/login/</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>findTestData(null).getValue(1, 1)</defaultValue>
      <description></description>
      <id>e76ea71a-c50f-4e6a-a37c-21437c0489cf</id>
      <masked>false</masked>
      <name>partner</name>
   </variables>
   <variables>
      <defaultValue>findTestData(null).getValue(1, 1)</defaultValue>
      <description></description>
      <id>efa05439-bbc9-4f00-9796-be1e074b0021</id>
      <masked>false</masked>
      <name>env</name>
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
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
