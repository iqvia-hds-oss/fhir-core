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
package com.b2international.fhir.r6.operations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.model.core.Parameters.ParametersParameterComponent;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.core.StringType;

import com.b2international.fhir.operations.OperationParametersFactory;

public abstract class InputParametersTest<T extends BaseParameters> {

	private final OperationParametersFactory factory;
	
	protected InputParametersTest(OperationParametersFactory factory) {
		this.factory = factory;
	}
	
	protected T createFromResource(Resource parameters) {
		return createFromResource(parameters, true);
	}

	@SuppressWarnings("unchecked")
	private T createFromResource(Resource parameters, boolean strict) {
		return (T) factory.create((Parameters) parameters, strict);
	}
	
	protected void checkInvalidParameter(Resource parameters) {
		Parameters invalidParameters = ((Parameters) parameters).copy(Base.COPY_DATA).addParameter("invalidKey", "invalidValue");

		// Strict mode should reject converting Parameters with an unknown parameter into an operation input object
		FHIRFormatError formatError = assertThrows(FHIRFormatError.class, () -> createFromResource(invalidParameters));
		assertThat(formatError).hasMessageContaining("invalidKey");
		
		// Lenient mode should create the operation input object just fine
		assertNotNull(createFromResource(invalidParameters, false));
	}
	
	protected void checkInvalidPart(Resource parameters) {
		Parameters invalidParameters = ((Parameters) parameters).copy(Base.COPY_DATA);
		
		ParametersParameterComponent invalidPartParent = invalidParameters.addParameter()
			.setName("invalidPart");
		ParametersParameterComponent partA = invalidPartParent.addPart();
		ParametersParameterComponent partB = invalidPartParent.addPart();
		
		partA.setName("nameA")
			.setValue(new StringType("valueA"));
		partB.setName("nameB")
			.setValue(new StringType("valueB"));

		// Strict mode should reject converting Parameters with an unknown parameter into an operation input object
		FHIRFormatError formatError = assertThrows(FHIRFormatError.class, () -> createFromResource(invalidParameters));
		assertThat(formatError)
			.hasMessageContaining("invalidPart.nameA")
			.hasMessageContaining("invalidPart.nameB");
		
		// Lenient mode should create the operation input object just fine
		assertNotNull(createFromResource(invalidParameters, false));
	}
}
