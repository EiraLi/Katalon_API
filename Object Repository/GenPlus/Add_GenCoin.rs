<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Add_GenCoin</name>
   <tag></tag>
   <elementGuidId>1f871434-b989-495f-a3eb-1482f73343ae</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;promoId\&quot;: \&quot;\&quot;,\n  \&quot;quantity\&quot;: 200000\n}&quot;,
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
   <restUrl>http://${url_genplus}/api/genplus/promo/gencoin/${partner_code}/${userid}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(13, 1)</defaultValue>
      <description></description>
      <id>9d3a9167-4d92-4c93-965e-a1c5479dfc52</id>
      <masked>false</masked>
      <name>url_genplus</name>
   </variables>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(1, 1)</defaultValue>
      <description></description>
      <id>4d48d287-0227-4d91-a58a-3edb67e7db7f</id>
      <masked>false</masked>
      <name>partner_code</name>
   </variables>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(4, 1)</defaultValue>
      <description></description>
      <id>d150f60e-e3ac-44fd-a33d-b9921d785234</id>
      <masked>false</masked>
      <name>userid</name>
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
