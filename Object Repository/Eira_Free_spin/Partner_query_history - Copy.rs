<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Partner_query_history - Copy</name>
   <tag></tag>
   <elementGuidId>e51d7cd1-1ae0-498f-9f7f-ae10ec73b074</elementGuidId>
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
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://${url}/api/v3/m4/spindata/query/partner?startDate=${start_date}&amp;endDate=${end_date}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'rp-gt.star9ad.com'</defaultValue>
      <description></description>
      <id>844d0631-cfa7-4884-a319-df13344a54f6</id>
      <masked>false</masked>
      <name>url</name>
   </variables>
   <variables>
      <defaultValue>'2019-06-24T00:00:00.000Z'</defaultValue>
      <description></description>
      <id>95a8779c-b859-4e6d-aa64-ecad58ea23ee</id>
      <masked>false</masked>
      <name>start_date</name>
   </variables>
   <variables>
      <defaultValue>'2019-06-24T23:59:00.000Z'</defaultValue>
      <description></description>
      <id>95c5dcdb-503a-413c-b05a-f03c9e35d102</id>
      <masked>false</masked>
      <name>end_date</name>
   </variables>
   <variables>
      <defaultValue>'c304afdf-2f61-6369-c088-924f99e1be1a'</defaultValue>
      <description></description>
      <id>4c907c0c-7473-447a-a634-54d90544bf19</id>
      <masked>false</masked>
      <name>partner</name>
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

def partner_query_history = new groovy.json.JsonSlurper()
def result_partner_query_history = partner_query_history.parseText(response.getResponseText())

def partner_query_user_id = result_partner_query_history.data[0].user_id
println (&quot;user id is: &quot;+parnter_query_user_id)
GlobalVariable.partner_query_user_id = partner_query_user_id
println(&quot;GlobalVariable partner query user id is: &quot;+GlobalVariable.partner_query_user_id)

def partner_query_game_id = result_partner_query_history.data[0].game_id
println(&quot;game id is: &quot;+partner_query_game_id)
GlobalVariable.partner_query_game_id = partner_query_game_id
println(&quot;GlobalVariable partner query game id is: &quot;+GlobalVariable.partner_query_game_id)

def partner_query_balance = result_partner_query_history.data[0].balance
println(&quot;balance is: &quot;+partner_query_balance)
GlobalVariable.partner_query_balance = partner_query_balance</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
