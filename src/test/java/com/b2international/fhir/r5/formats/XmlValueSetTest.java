/*
 * Copyright 2026 B2i Healthcare, https://b2ihealthcare.com
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
package com.b2international.fhir.r5.formats;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.junit.Test;

import com.b2international.fhir.formats.XmlParser;

/**
 * Verifies that the XML utility correctly serializes FHIR R5 {@code ValueSet} resources.
 *
 * @since 0.7.0
 */
public class XmlValueSetTest {

	private static ValueSet buildValueSet() {
		final ValueSet vs = new ValueSet();
		vs.setId("r5-vs");
		vs.setUrl("http://example.com/r5/vs");
		vs.setVersion("1.0.0");
		vs.setName("R5ExampleVS");
		vs.setTitle("R5 Example Value Set");
		vs.setStatus(Enumerations.PublicationStatus.ACTIVE);
		vs.getCompose()
			.addInclude()
				.setSystem("http://example.com/cs")
				.addConcept()
					.setCode("example-code")
					.setDisplay("Example Concept");
		return vs;
	}

	private static void assertValueSet(final ValueSet vs) {
		assertThat(vs.getId()).isEqualTo("r5-vs");
		assertThat(vs.getUrl()).isEqualTo("http://example.com/r5/vs");
		assertThat(vs.getVersion()).isEqualTo("1.0.0");
		assertThat(vs.getName()).isEqualTo("R5ExampleVS");
		assertThat(vs.getTitle()).isEqualTo("R5 Example Value Set");
		assertThat(vs.getStatus()).isEqualTo(Enumerations.PublicationStatus.ACTIVE);
		assertThat(vs.getCompose().getInclude()).hasSize(1);
		assertThat(vs.getCompose().getIncludeFirstRep().getSystem()).isEqualTo("http://example.com/cs");
		assertThat(vs.getCompose().getIncludeFirstRep().getConcept()).hasSize(1);
		assertThat(vs.getCompose().getIncludeFirstRep().getConceptFirstRep().getCode()).isEqualTo("example-code");
		assertThat(vs.getCompose().getIncludeFirstRep().getConceptFirstRep().getDisplay()).isEqualTo("Example Concept");
	}
	
	@Test
	public void serialize_xml() throws Exception {
		try (final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			XmlParser.composeR5(baos, buildValueSet(), true);
			
			final String actual = baos.toString();
			final String expected = """
			<?xml version="1.0" encoding="UTF-8"?>

			<ValueSet xmlns="http://hl7.org/fhir">
			  <id value="r5-vs"/>
			  <url value="http://example.com/r5/vs"/>
			  <version value="1.0.0"/>
			  <name value="R5ExampleVS"/>
			  <title value="R5 Example Value Set"/>
			  <status value="active"/>
			  <compose>
			    <include>
			      <system value="http://example.com/cs"/>
			      <concept>
			        <code value="example-code"/>
			        <display value="Example Concept"/>
			      </concept>
			    </include>
			  </compose>
			</ValueSet>""";
			
			assertEquals(expected, actual);
		}
	}
	
	@Test
	public void deserialize_xml() throws Exception {
		final String xml = """
			<?xml version="1.0" encoding="UTF-8"?>
			<ValueSet xmlns="http://hl7.org/fhir">
			  <id value="r5-vs"/>
			  <url value="http://example.com/r5/vs"/>
			  <version value="1.0.0"/>
			  <name value="R5ExampleVS"/>
			  <title value="R5 Example Value Set"/>
			  <status value="active"/>
			  <compose>
			    <include>
			      <system value="http://example.com/cs"/>
			      <concept>
			        <code value="example-code"/>
			        <display value="Example Concept"/>
			      </concept>
			    </include>
			  </compose>
			</ValueSet>""";
		
		try (final ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes())) {
			final Resource resource = XmlParser.parseR5(bais);
			
			assertThat(resource).isInstanceOf(ValueSet.class);
			assertValueSet((ValueSet) resource);
		}
	}
	
}
