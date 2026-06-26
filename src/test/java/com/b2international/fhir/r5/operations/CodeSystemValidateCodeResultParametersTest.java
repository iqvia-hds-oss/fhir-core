/*
 * Copyright 2024 B2i Healthcare, https://b2ihealthcare.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.b2international.fhir.r5.operations;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.model.*;
import org.junit.Test;

/**
 * @since 0.1
 */
public class CodeSystemValidateCodeResultParametersTest {
	
	private final JsonParser parser = new JsonParser();
	
	@Test
	public void result() throws Exception {
		
		String json = """
		{
			"resourceType": "Parameters",
			"parameter": [ 
				{
					"name": "result",
					"valueBoolean": "true"
				}
			]
		}
		""";
		
		Resource resource = parser.parse(json);
		
		CodeSystemValidateCodeResultParameters expected = new CodeSystemValidateCodeResultParameters().setResult(true);
		
		CodeSystemValidateCodeResultParameters actual = new CodeSystemValidateCodeResultParameters((Parameters) resource);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void message() throws Exception {
		
		String json = 
		"""
		{
			"resourceType": "Parameters",
			"parameter": [ 
				{
					"name": "message",
					"valueString": "testMessage"
				}
			]
		}
		""";
		
		Resource resource = parser.parse(json);
		
		CodeSystemValidateCodeResultParameters expected = new CodeSystemValidateCodeResultParameters().setMessage("testMessage");
		
		CodeSystemValidateCodeResultParameters actual = new CodeSystemValidateCodeResultParameters((Parameters) resource);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void display() throws Exception {
		
		String json = 
		"""
		{
			"resourceType": "Parameters",
			"parameter": [ 
				{
					"name": "display",
					"valueString": "testDisplay"
				}
			]
		}
		""";
		
		Resource resource = parser.parse(json);
		
		CodeSystemValidateCodeResultParameters expected = new CodeSystemValidateCodeResultParameters().setDisplay("testDisplay");
		
		CodeSystemValidateCodeResultParameters actual = new CodeSystemValidateCodeResultParameters((Parameters) resource);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void code() throws Exception {
		
		String json = 
		"""
		{
			"resourceType": "Parameters",
			"parameter": [ 
				{
					"name": "code",
					"valueCode": "testCode"
				}
			]
		}
		""";
		
		Resource resource = parser.parse(json);
		
		CodeSystemValidateCodeResultParameters expected = new CodeSystemValidateCodeResultParameters().setCode("testCode");
		
		CodeSystemValidateCodeResultParameters actual = new CodeSystemValidateCodeResultParameters((Parameters) resource);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void system() throws Exception {
		
		String json = 
		"""
		{
			"resourceType": "Parameters",
			"parameter": [ 
				{
					"name": "system",
					"valueUri": "tesUrl"
				}
			]
		}
		""";
		
		Resource resource = parser.parse(json);
		
		CodeSystemValidateCodeResultParameters expected = new CodeSystemValidateCodeResultParameters().setSystem("tesUrl");
		
		CodeSystemValidateCodeResultParameters actual = new CodeSystemValidateCodeResultParameters((Parameters) resource);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void version() throws Exception {
		
		String json = 
		"""
		{
			"resourceType": "Parameters",
			"parameter": [ 
				{
					"name": "version",
					"valueString": "testVersion"
				}
			]
		}
		""";
		
		Resource resource = parser.parse(json);
		
		CodeSystemValidateCodeResultParameters expected = new CodeSystemValidateCodeResultParameters().setVersion("testVersion");
		
		CodeSystemValidateCodeResultParameters actual = new CodeSystemValidateCodeResultParameters((Parameters) resource);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void codeableConcept() throws Exception {
		
		String json = 
		"""
		{
			"resourceType": "Parameters",
			"parameter": [ 
				{
					"name": "codeableConcept",
					"valueCodeableConcept": {
						"coding": [
							{
								"system": "testSystem",
								"code": "testCode",
								"display": "testDisplay"
							}
						],
						"text": "Codeable conept test"
					}
				}
			]
		}
		""";
		
		Resource resource = parser.parse(json);
		
		CodeSystemValidateCodeResultParameters expected = new CodeSystemValidateCodeResultParameters()
				.setCodeableConcept(new CodeableConcept()
						.setCoding(List.of(
								new Coding()
									.setSystem("testSystem")
									.setCode("testCode")
									.setDisplay("testDisplay")))
						.setText("Codeable conept test"));
		
		CodeSystemValidateCodeResultParameters actual = new CodeSystemValidateCodeResultParameters((Parameters) resource);
		
		assertEquals(expected, actual);
	}
	
	

	@Test
	public void issues() throws Exception {
		
		String json = 
		"""
		{
			"resourceType": "Parameters",
			"parameter": [
				{
					"name": "issues",
					"resource": {
						"resourceType": "OperationOutcome",
						"issue": [
							{
								"severity": "error",
								"code": "code-invalid",
								"details": {
									"coding": [
										{
										"system": "http://hl7.org/fhir/tools/CodeSystem/tx-issue-type",
										"code": "invalid-code"
										}
									],
									"text": "Unknown code 'testCode' in the CodeSystem 'testSystem' version 'testVersion'"
								},
								"location": [
									"CodeableConcept.coding[0].code"
								],
								"expression": [
								"CodeableConcept.coding[0].code"
								]
							}
						]
					}
				}
			]
		}
		""";
		
		Resource resource = parser.parse(json);
		
		OperationOutcome issues = new OperationOutcome();
		
		issues.addIssue()
			.setSeverity(OperationOutcome.IssueSeverity.ERROR)
			.setCode(OperationOutcome.IssueType.CODEINVALID)
			.setDetails(new CodeableConcept()
					.setCoding(List.of(
							new Coding()
								.setSystem("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type")
								.setCode("invalid-code")))
					.setText("Unknown code 'testCode' in the CodeSystem 'testSystem' version 'testVersion'"))
			.setLocation(List.of(new StringType("CodeableConcept.coding[0].code")))
			.setExpression(List.of(new StringType("CodeableConcept.coding[0].code")));
	
		CodeSystemValidateCodeResultParameters expected = new CodeSystemValidateCodeResultParameters()
				.setIssues(issues);
		
		CodeSystemValidateCodeResultParameters actual = new CodeSystemValidateCodeResultParameters((Parameters) resource);
		
		assertEquals(expected, actual);
	}
}