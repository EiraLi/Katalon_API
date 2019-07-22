<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>M4_spin</name>
   <tag></tag>
   <elementGuidId>433205d8-6028-482f-bfd3-d5f69d32aa52</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;channel\&quot;: \&quot;desktop\&quot;,\n    \&quot;bet\&quot;: 4000,\n    \&quot;lines\&quot;: 1,\n    \&quot;multiplier\&quot;: 1,\n    \&quot;currency\&quot;: \&quot;CNY\&quot;,\n    \&quot;points\&quot;: null,\n    \&quot;key\&quot;: null\n}&quot;,
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
      <name>X-Genesis-UserId</name>
      <type>Main</type>
      <value>eyJrcnVnX3Nlc3Npb24iOiJiZTlmYWU5OS1lN2FkLTRhZjItYWNmOC1jMjBkOTdkZTU2YzEiLCJ1c2VyX2lkIjoiYmJpbl9pbnRfMDAwMSIsInBhcnRuZXJfY29kZSI6IkJCSU5fU3RhZ2luZyIsImdhbWVfa2V5IjoiTTQtMDAxMiIsImNsaWVudF9pcCI6bnVsbCwibWVyY2hhbnRfY29kZSI6IiIsImRldmljZSI6bnVsbCwiY3VycmVuY3kiOiJDTlkiLCJkZW1vX3VpZCI6bnVsbCwicGxheWVyX3R5cGUiOiJIT1VTRSIsImJldF9kZW5vbV9kZWZhdWx0IjowfQ==</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://${partner}.3655oule.com/m4/gameservice/play/spin/${rgs_session_token}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>GlobalVariable.M4_login_user_id</defaultValue>
      <description></description>
      <id>ce8bc744-ce25-4570-881c-fdf065533011</id>
      <masked>false</masked>
      <name>M4_Login_user_id</name>
   </variables>
   <variables>
      <defaultValue>findTestData('INT_data').getValue(2, 1)</defaultValue>
      <description></description>
      <id>e47a4e61-ec7b-4f39-a95f-0ac8c1d91002</id>
      <masked>false</masked>
      <name>partner</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.rgs_session_token</defaultValue>
      <description></description>
      <id>5c516312-7e8f-4189-a06f-1ede83cff877</id>
      <masked>false</masked>
      <name>rgs_session_token</name>
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

String newline = System.getProperty(&quot;line.separator&quot;)
def M4_spin = new groovy.json.JsonSlurper()
def result_M4_spin = M4_spin.parseText(response.getResponseBodyContent())

def M4_spin_current_balance = result_M4_spin.current_balance
GlobalVariable.M4_spin_current_balance = M4_spin_current_balance

def M4_spin_transaction_id = result_M4_spin.spin_result.causality
GlobalVariable.M4_spin_transaction_id = M4_spin_transaction_id

def M4_total_bonus_spins = result_M4_spin.spin_result.bonus.bonus_data[0].get('properties').total_bonus_spins
GlobalVariable.M4_total_bonus_spins = M4_total_bonus_spins
println(&quot;M4_total_bonus_spins is:&quot;+GlobalVariable.M4_total_bonus_spins)

def wild = new String[5]
wild[0] = &quot;WILD_Expanding&quot;
wild[1] = &quot;WILD_Normal&quot;
wild[2] = &quot;WILD_Double&quot;
wild[3] = &quot;WILD_ExtraFG&quot;
wild[4] = &quot;WILD_Triple&quot;
def wildList = Arrays.asList(wild)

println(wildList.indexOf(&quot;WILD_Triple&quot;))
println(wildList.indexOf(&quot;abcd&quot;))

def counter = new int[3]
counter[0] = 0 //reel 3 wild found
counter[1] = 0
counter[2] = 0

def reels = result_M4_spin.spin_result.reels
for (int i=0; i &lt; reels.size(); i++) {
	def symbols = reels[i].symbols
	for (int j=0; j &lt; symbols.size(); j++) {
		def symbol = symbols[j].symbol
		println(symbol)
		if(i == 2 &amp;&amp; wildList.indexOf(symbol) != -1) {
			println(&quot;wild found on reel 3, adding counter by 1&quot;)
			counter[0] = counter[0] + 1
		}
		if(i == 3 &amp;&amp; wildList.indexOf(symbol) != -1) {
			println(&quot;wild found on reel 4, adding counter by 1&quot;)
			counter[1] = counter[1] + 1
		}
		if(i == 4 &amp;&amp; wildList.indexOf(symbol) != -1) {
			println(&quot;wild found on reel 5, adding counter by 1&quot;)
			counter[2] = counter[2] + 1
		}
	}
}

GlobalVariable.counter = counter
println(&quot;reel 3 wild found: &quot; + counter[0])
println(&quot;reel 4 wild found: &quot; + counter[1])
println(&quot;reel 5 wild found: &quot; + counter[2])




//def M4_reels_spin_result = result_M4_spin.spin_result
//GlobalVariable.M4_reels_spin_result = M4_reels_spin_result
//
//def M4_reel3_symbol1 = result_M4_spin.spin_result.reels[2].symbols[0]
//GlobalVariable.M4_reel3_symbol1 = M4_reel3_symbol1
//println(&quot;M4_reel3_symbol1 is:&quot;+M4_reel3_symbol1)
//
//def M4_reel3_symbol2 = result_M4_spin.spin_result.reels[2].symbols[1]
//GlobalVariable.M4_reel3_symbol2 = M4_reel3_symbol2
//println(&quot;M4_reel3_symbol2 is:&quot;+M4_reel3_symbol2)
//
//def M4_reel3_symbol3 = result_M4_spin.spin_result.reels[2].symbols[2]
//GlobalVariable.M4_reel3_symbol3 = M4_reel3_symbol3
//println(&quot;M4_reel3_symbol3 is:&quot;+M4_reel3_symbol3)
//
//def M4_reel4_symbol1 = result_M4_spin.spin_result.reels[3].symbols[0]
//GlobalVariable.M4_reel4_symbol1 = M4_reel4_symbol1
//println(&quot;M4_reel4_symbol1 is:&quot;+M4_reel4_symbol1)
//
//def M4_reel4_symbol2 = result_M4_spin.spin_result.reels[3].symbols[1]
//GlobalVariable.M4_reel4_symbol2 = M4_reel4_symbol2
//println(&quot;M4_reel4_symbol2 is:&quot;+M4_reel4_symbol2)

//def M4_reel4_symbol3 = result_M4_spin.spin_result.reels[3].symbols[2]
//GlobalVariable.M4_reel4_symbol3 = M4_reel4_symbol3
//println(&quot;M4_reel4_symbol3 is:&quot;+M4_reel4_symbol3)
//
//def M4_reel5_symbol1 = result_M4_spin.spin_result.reels[4].symbols[0]
//GlobalVariable.M4_reel5_symbol1 = M4_reel5_symbol1
//println(&quot;M4_reel5_symbol1 is:&quot;+M4_reel5_symbol1)
//
//def M4_reel5_symbol2 = result_M4_spin.spin_result.reels[4].symbols[1]
//GlobalVariable.M4_reel5_symbol2 = M4_reel5_symbol2
//println(&quot;M4_reel5_symbol2 is:&quot;+M4_reel5_symbol2)
//
//def M4_reel5_symbol3 = result_M4_spin.spin_result.reels[4].symbols[2]
//GlobalVariable.M4_reel5_symbol3 = M4_reel5_symbol3
//println(&quot;M4_reel5_symbol3 is:&quot;+M4_reel5_symbol3)


//def reels = result_spin.spin_result.reels
//def reel3_sym1 = result_spin.spin_result.reels[2].symbols[0].reel_position
//def reel3_sym2 = result_spin.spin_result.reels[2].symbols[1].reel_position
//def reel3_sym3 = result_spin.spin_result.reels[2].symbols[2].reel_position
//def reel4_sym1 = result_spin.spin_result.reels[3].symbols[0].reel_position
//def reel4_sym2 = result_spin.spin_result.reels[3].symbols[1].reel_position
//def reel4_sym3 = result_spin.spin_result.reels[3].symbols[2].reel_position
//def reel5_sym1 = result_spin.spin_result.reels[4].symbols[0].reel_position
//def reel5_sym2 = result_spin.spin_result.reels[4].symbols[1].reel_position
//def reel5_sym3 = result_spin.spin_result.reels[4].symbols[2].reel_position
//
//GlobalVariable.reel3_sym1 = reel3_sym1
//GlobalVariable.reel3_sym2 = reel3_sym2
//GlobalVariable.reel3_sym3 = reel3_sym3
//GlobalVariable.reel4_sym1 = reel4_sym1
//GlobalVariable.reel4_sym2 = reel4_sym2
//GlobalVariable.reel4_sym3 = reel4_sym3
//GlobalVariable.reel5_sym1 = reel5_sym1
//GlobalVariable.reel5_sym2 = reel5_sym2
//GlobalVariable.reel5_sym3 = reel5_sym3
//
//ArrayList&lt;String> wild_scatter = new ArrayList&lt;String>()
//wild_scatter.add(&quot;WILD_Expanding&quot;)
//wild_scatter.add(&quot;WILD_Normal&quot;)
//wild_scatter.add(&quot;WILD_Double&quot;)
//wild_scatter.add(&quot;WILD_ExtraFG&quot;)
//wild_scatter.add(&quot;WILD_Triple&quot;)
//
//ArrayList&lt;String> other_scatter = new ArrayList&lt;String>()
//wild_scatter.add(&quot;A&quot;)
//wild_scatter.add(&quot;K&quot;)
//wild_scatter.add(&quot;Q&quot;)
//wild_scatter.add(&quot;J&quot;)
//wild_scatter.add(&quot;PIC1&quot;)
//wild_scatter.add(&quot;PIC2&quot;)
//wild_scatter.add(&quot;PIC3&quot;)
//
//if ((reel3_sym1.contains(wild_scatter)) || (reel3_sym2.contains(wild_scatter)) || (reel3_sym3.contains(wild_scatter))){
//     reel3_has_wild == true
//	 reel3_has_wild = GlobalVariable.reel3_has_wild
//}
//
//if ((reel4_sym1.contains(wild_scatter)) || (reel4_sym2.contains(wild_scatter)) || (reel4_sym3.contains(wild_scatter))){
//	reel4_has_wild == true
//	reel4_has_wild = GlobalVariable.reel4_has_wild
//}
//
//if ((reel5_sym1.contains(wild_scatter)) || (reel5_sym2.contains(wild_scatter)) || (reel5_sym3.contains(wild_scatter))){
//	reel5_has_wild == true
//	reel5_has_wild = GlobalVariable.reel5_has_wild
//}


// Check if reel3 has symbo &quot;W&quot;
//if (GlobalVariable.reel3_sym1 == 4
//	|| GlobalVariable.reel3_sym1 == 7
//	|| GlobalVariable.reel3_sym1 == 10
//	|| GlobalVariable.reel3_sym1 == 13
//	|| GlobalVariable.reel3_sym1 == 16
//	|| GlobalVariable.reel3_sym1 == 26) {
//		reel3_sym1_has_wild == true
//		GlobalVariable.reel3_sym1_w = reel3_sym1_has_wild
//}
//if (GlobalVariable.reel3_sym2 == 4
//	|| GlobalVariable.reel3_sym2 == 7
//	|| GlobalVariable.reel3_sym2 == 10
//	|| GlobalVariable.reel3_sym2 == 13
//	|| GlobalVariable.reel3_sym2 == 16
//	|| GlobalVariable.reel3_sym2 == 26) {
//		reel3_sym2_has_wild == true
//		GlobalVariable.reel3_sym2_w = reel3_sym2_has_wild
//}
//if (GlobalVariable.reel3_sym3 == 4
//	|| GlobalVariable.reel3_sym3 == 7
//	|| GlobalVariable.reel3_sym3 == 10
//	|| GlobalVariable.reel3_sym3 == 13
//	|| GlobalVariable.reel3_sym3 == 16
//	|| GlobalVariable.reel3_sym3 == 26) {
//		reel3_sym3_has_wild == true
//		GlobalVariable.reel3_sym3_w = reel3_sym3_has_wild
//}
//if (true.equals(GlobalVariable.reel3_sym1_w)||true.equals(GlobalVariable.reel3_sym2_w)||true.equals(GlobalVariable.reel3_sym3_w)) {
//	reel3_has_wild == true
//	GlobalVariable.reel3_w = reel3_has_wild
//}

// Check if reel4 has symbo &quot;W&quot;
//if (GlobalVariable.reel4_sym1 == 4
//	|| GlobalVariable.reel4_sym1 == 7
//	|| GlobalVariable.reel4_sym1 == 10
//	|| GlobalVariable.reel4_sym1 == 13
//	|| GlobalVariable.reel4_sym1 == 16) {
//		reel4_sym1_has_wild == true
//		GlobalVariable.reel4_sym1_w = reel4_sym1_has_wild
//}
//if (GlobalVariable.reel4_sym2 == 4
//	|| GlobalVariable.reel4_sym2 == 7
//	|| GlobalVariable.reel4_sym2 == 10
//	|| GlobalVariable.reel4_sym2 == 13
//	|| GlobalVariable.reel4_sym2 == 16) {
//		reel4_sym2_has_wild == true
//		GlobalVariable.reel4_sym2_w = reel4_sym2_has_wild
//}
//if (GlobalVariable.reel4_sym3 == 4
//	|| GlobalVariable.reel4_sym3 == 7
//	|| GlobalVariable.reel4_sym3 == 10
//	|| GlobalVariable.reel4_sym3 == 13
//	|| GlobalVariable.reel4_sym3 == 16) {
//		reel4_sym3_has_wild == true
//		GlobalVariable.reel4_sym3_w = reel4_sym3_has_wild
//}
//if (true.equals(GlobalVariable.reel4_sym1_w)||true.equals(GlobalVariable.reel4_sym2_w)||true.equals(GlobalVariable.reel4_sym3_w)) {
//	reel4_has_wild == true
//	GlobalVariable.reel4_w = reel4_has_wild
//}

// Check if reel5 has symbo &quot;W&quot;
//if (GlobalVariable.reel5_sym1 == 4
//	|| GlobalVariable.reel5_sym1 == 7
//	|| GlobalVariable.reel5_sym1 == 10) {
//		reel5_sym1_has_wild == true
//		GlobalVariable.reel5_sym1_w = reel5_sym1_has_wild
//}
//if (GlobalVariable.reel5_sym2 == 4
//	|| GlobalVariable.reel5_sym2 == 7
//	|| GlobalVariable.reel5_sym2 == 10) {
//		reel5_sym2_has_wild == true
//		GlobalVariable.reel5_sym2_w = reel5_sym2_has_wild
//}
//
//if (GlobalVariable.reel5_sym3 == 4
//	|| GlobalVariable.reel5_sym3 == 7
//	|| GlobalVariable.reel5_sym3 == 10) {
//		reel5_sym3_has_wild == true
//		GlobalVariable.reel5_sym3_w = reel5_sym3_has_wild
//}
//if (true.equals(GlobalVariable.reel5_sym1_w)||true.equals(GlobalVariable.reel5_sym2_w)||true.equals(GlobalVariable.reel5_sym3_w)) {
//	reel5_has_wild == true
//	GlobalVariable.reel5_w = reel5_has_wild
//}
//

</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
