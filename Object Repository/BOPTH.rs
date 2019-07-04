<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>BOPTH</name>
   <tag></tag>
   <elementGuidId>81ca01ea-d035-4b0a-845d-f02efc857a50</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://${url}/history/transactions/all/players/${userid1}?startDate=2019-07-03T00:00:00Z&amp;endDate=2019-07-04T23:59:00Z&amp;partnerToken={{partner}}&amp;timeZoneId=GMT%2B8&amp;pageNumber=1&amp;pageSize=50</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'krug.star9ad.com'</defaultValue>
      <description></description>
      <id>a6f36fbc-af2f-4a6a-a1fd-c8e188a7c10f</id>
      <masked>false</masked>
      <name>url</name>
   </variables>
   <variables>
      <defaultValue>'eira_bbin_0001'</defaultValue>
      <description></description>
      <id>dfb11d3f-efda-4842-9a62-2e346eab072e</id>
      <masked>false</masked>
      <name>userid1</name>
   </variables>
   <variables>
      <defaultValue>'c304afdf-2f61-6369-c088-924f99e1be1a'</defaultValue>
      <description></description>
      <id>fb86805d-c50b-4913-84c9-8f9f41024e04</id>
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

WS.verifyResponseStatusCode(response, 200)
assertThat(response.getStatusCode()).isEqualTo(200)

def boquery = new groovy.json.JsonSlurper()
def result_boquery = boquery.parseText(response.getResponseBodyContent())

def balance = result_boquery.documents.payload[0].balance
println(&quot;latest balance is: &quot; +balance)
GlobalVariable.balance = balance

def round_id = result_boquery.documents.payload[0].roundId
println(&quot;latest roundId is: &quot; +round_id)
GlobalVariable.round_id = round_id

def game_code = result_boquery.documents.payload[0].gameId
println(&quot;game code is: &quot; +game_code)
GlobalVariable.game_code = game_code

def transaction_id = result_boquery.documents.payload[0].txId
println(&quot;transaction id is: &quot; +transaction_id)
GlobalVariable.transaction_id = transaction_id




</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
