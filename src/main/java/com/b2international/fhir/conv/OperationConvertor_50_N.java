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
package com.b2international.fhir.conv;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_50_N;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_50_N;
import org.hl7.fhir.exceptions.FHIRFormatError;

/*
 * Ensure that there is no explicit import statement to any R5/RN (essentially R6 and newer) model classes 
 */
/**
 * @since 0.1
 */
public class OperationConvertor_50_N {
	
	private static final BaseAdvisor_50_N IGNORE_NULLS = new BaseAdvisor_50_N(false);
	
	@SuppressWarnings("unchecked")
	public static final <T extends org.hl7.fhir.model.core.DataType> T convertType(org.hl7.fhir.r5.model.DataType type) {
		return (T) VersionConvertorFactory_50_N.convertType(type, IGNORE_NULLS);
	}
	
	@SuppressWarnings("unchecked")
	public static final <T extends org.hl7.fhir.r5.model.DataType> T convertType(org.hl7.fhir.model.core.DataType type) {
		return (T) VersionConvertorFactory_50_N.convertType(type, IGNORE_NULLS);
	}
	
	@SuppressWarnings("unchecked")
	public static final <T extends org.hl7.fhir.model.core.Resource> T convertResource(org.hl7.fhir.r5.model.Resource resource) {
		return (T) VersionConvertorFactory_50_N.convertResource(resource, IGNORE_NULLS);
	}
	
	@SuppressWarnings("unchecked")
	public static final <T extends org.hl7.fhir.r5.model.Resource> T convertResource(org.hl7.fhir.model.core.Resource resource) {
		return (T) VersionConvertorFactory_50_N.convertResource(resource, IGNORE_NULLS);
	}
	
	//////////////
	// R6 to R5 //
	//////////////
	
	public static com.b2international.fhir.r5.operations.BaseParameters convert(com.b2international.fhir.r6.operations.BaseParameters parameters) {
		if (parameters instanceof com.b2international.fhir.r6.operations.CodeSystemLookupParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r6.operations.CodeSystemLookupResultParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r6.operations.CodeSystemSubsumptionParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r6.operations.CodeSystemSubsumptionResultParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r6.operations.CodeSystemValidateCodeParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r6.operations.CodeSystemValidateCodeResultParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r6.operations.ConceptMapTranslateParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r6.operations.ConceptMapTranslateResultParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r6.operations.ValueSetExpandParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r6.operations.ValueSetValidateCodeParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r6.operations.ValueSetValidateCodeResultParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r6.operations.LoadPackageParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r6.operations.LoadPackageResultParameters r5Parameters) {
			return convert(r5Parameters);
		} else {
			throw new FHIRFormatError(String.format("Unable to convert R6 parameters '%s' to R5.", parameters.getClass().getSimpleName()));
		}
	}
	
	// CodeSystem$lookup input parameters
	public static com.b2international.fhir.r5.operations.CodeSystemLookupParameters convert(com.b2international.fhir.r6.operations.CodeSystemLookupParameters parameters) {
		return new com.b2international.fhir.r5.operations.CodeSystemLookupParameters()
			.setCode(convertType(parameters.getCode()))
			.setSystem(convertType(parameters.getSystem()))
			.setVersion(convertType(parameters.getVersion()))
			.setCoding(convertType(parameters.getCoding()))
			.setDate(convertType(parameters.getDate()))
			.setDisplayLanguage(convertType(parameters.getDisplayLanguage()))
			.setProperty(parameters.getProperty() == null ? null : parameters.getProperty().stream()
					.map(OperationConvertor_50_N::convertType)
					.toList())
		;
	}
	
	// CodeSystem$lookup output parameters
	public static com.b2international.fhir.r5.operations.CodeSystemLookupResultParameters convert(com.b2international.fhir.r6.operations.CodeSystemLookupResultParameters parameters) {
		return new com.b2international.fhir.r5.operations.CodeSystemLookupResultParameters()
			.setName(convertType(parameters.getName()))
			.setVersion(convertType(parameters.getVersion()))
			.setDisplay(convertType(parameters.getDisplay()))
			.setDesignation(parameters.getDesignation() == null ? null : parameters.getDesignation().stream()
					.map(OperationConvertor_50_N::convert)
					.toList())
			.setProperty(parameters.getProperty() == null ? null : parameters.getProperty().stream()
					.map(OperationConvertor_50_N::convert)
					.toList())
		;
	}
	
	private static com.b2international.fhir.r5.operations.CodeSystemLookupResultParameters.Designation convert(com.b2international.fhir.r6.operations.CodeSystemLookupResultParameters.Designation designation) {
		return new com.b2international.fhir.r5.operations.CodeSystemLookupResultParameters.Designation()
			.setLanguage(convertType(designation.getLanguage()))
			.setUse(convertType(designation.getUse()))
			.setValue(convertType(designation.getValue()))
		;
	}
	
	
	private static com.b2international.fhir.r5.operations.CodeSystemLookupResultParameters.Property convert(com.b2international.fhir.r6.operations.CodeSystemLookupResultParameters.Property property) {
		return new com.b2international.fhir.r5.operations.CodeSystemLookupResultParameters.Property()
			.setCode(convertType(property.getCode()))
			.setValue(convertType(property.getValue()))
			.setDescription(convertType(property.getDescription()))
			.setSubProperty(property.getSubProperty() == null ? null : property.getSubProperty().stream().map(OperationConvertor_50_N::convert).toList())
		;
	}
	
	// CodeSystem$subsumes input parameters
	// No difference between versions, using low-level parameter convertor 
	public static com.b2international.fhir.r5.operations.CodeSystemSubsumptionParameters convert(com.b2international.fhir.r6.operations.CodeSystemSubsumptionParameters parameters) {
		var r4Parameters = (org.hl7.fhir.r5.model.Parameters) VersionConvertorFactory_50_N.convertResource(parameters.getParameters());
		return new com.b2international.fhir.r5.operations.CodeSystemSubsumptionParameters(r4Parameters);
	}
	
	// CodeSystem$subsumes output parameters
	// No difference between versions, using low-level parameter convertor
	public static com.b2international.fhir.r5.operations.CodeSystemSubsumptionResultParameters convert(com.b2international.fhir.r6.operations.CodeSystemSubsumptionResultParameters parameters) {
		var r4Parameters = (org.hl7.fhir.r5.model.Parameters) VersionConvertorFactory_50_N.convertResource(parameters.getParameters());
		return new com.b2international.fhir.r5.operations.CodeSystemSubsumptionResultParameters(r4Parameters);
	}
	
	// CodeSystem$validate-code input parameters
	// No difference between versions, using low-level parameter convertor
	public static com.b2international.fhir.r5.operations.CodeSystemValidateCodeParameters convert(com.b2international.fhir.r6.operations.CodeSystemValidateCodeParameters parameters) {
		var r4Parameters = (org.hl7.fhir.r5.model.Parameters) VersionConvertorFactory_50_N.convertResource(parameters.getParameters());
		return new com.b2international.fhir.r5.operations.CodeSystemValidateCodeParameters(r4Parameters);
	}
	
	// CodeSystem$validate-code output parameters
	// No difference between versions, using low-level parameter convertor
	public static com.b2international.fhir.r5.operations.CodeSystemValidateCodeResultParameters convert(com.b2international.fhir.r6.operations.CodeSystemValidateCodeResultParameters parameters) {
		return new com.b2international.fhir.r5.operations.CodeSystemValidateCodeResultParameters()
			.setResult(convertType(parameters.getResult()))
			.setSystem(convertType(parameters.getSystem()))
			.setVersion(convertType(parameters.getVersion()))
			.setMessage(convertType(parameters.getMessage()))
			.setDisplay(convertType(parameters.getDisplay()))
		;
	}
	
	// ConceptMap$translate input parameters
	public static com.b2international.fhir.r5.operations.ConceptMapTranslateParameters convert(com.b2international.fhir.r6.operations.ConceptMapTranslateParameters parameters) {
		return new com.b2international.fhir.r5.operations.ConceptMapTranslateParameters()
			.setUrl(convertType(parameters.getUrl()))
			.setConceptMap(convertResource(parameters.getConceptMap()))
			.setConceptMapVersion(convertType(parameters.getConceptMapVersion()))
			.setVersion(convertType(parameters.getVersion()))
			.setSystem(convertType(parameters.getSystem()))
			.setSourceCode(convertType(parameters.getSourceCode()))
			.setSourceCodeableConcept(convertType(parameters.getSourceCodeableConcept()))
			.setSourceCoding(convertType(parameters.getSourceCoding()))
			.setSourceScope(convertType(parameters.getSourceScope()))
			.setTargetSystem(convertType(parameters.getTargetSystem()))
			.setTargetCode(convertType(parameters.getTargetCode()))
			.setTargetCodeableConcept(convertType(parameters.getTargetCodeableConcept()))
			.setTargetCoding(convertType(parameters.getTargetCoding()))
			.setTargetScope(convertType(parameters.getTargetScope()))
			.setDependency(parameters.getDependency() == null ? null : parameters.getDependency().stream().map(OperationConvertor_50_N::convert).toList())
			.setDisplayLanguage(convertType(parameters.getDisplayLanguage()))
		;
	}
	
	private static com.b2international.fhir.r5.operations.ConceptMapTranslateParameters.Dependency convert(com.b2international.fhir.r6.operations.ConceptMapTranslateParameters.Dependency r6Dependency) {
		return new com.b2international.fhir.r5.operations.ConceptMapTranslateParameters.Dependency()
			.setAttribute(convertType(r6Dependency.getAttribute()))
			.setValue(convertType(r6Dependency.getValue()))
		;
	}
	
	// ConceptMap$translate output parameters
	public static com.b2international.fhir.r5.operations.ConceptMapTranslateResultParameters convert(com.b2international.fhir.r6.operations.ConceptMapTranslateResultParameters parameters) {
		return new com.b2international.fhir.r5.operations.ConceptMapTranslateResultParameters()
			.setResult(convertType(parameters.getResult()))
			.setMessage(convertType(parameters.getMessage()))
			.setMatch(parameters.getMatch() == null ? null : parameters.getMatch().stream().map(OperationConvertor_50_N::convert).toList())
		;
	}
	
	private static com.b2international.fhir.r5.operations.ConceptMapTranslateResultParameters.Match convert(com.b2international.fhir.r6.operations.ConceptMapTranslateResultParameters.Match r6Match) {
		var r6Relationship = org.hl7.fhir.model.core.Enumerations.ConceptMapRelationship.fromCode(r6Match.getRelationship().getCode());
		
		return new com.b2international.fhir.r5.operations.ConceptMapTranslateResultParameters.Match()
			.setRelationship(ConceptMapRelationshipConverter.convert_50_N(r6Relationship))
			.setConcept(convertType(r6Match.getConcept()))
			.setProduct(r6Match.getProduct() == null ? null : r6Match.getProduct().stream().map(OperationConvertor_50_N::convert).toList())
			.setOriginMap(convertType(r6Match.getOriginMap()));
	}
	
	private static com.b2international.fhir.r5.operations.ConceptMapTranslateResultParameters.Match.Product convert(com.b2international.fhir.r6.operations.ConceptMapTranslateResultParameters.Match.Product r6Product) {
		return new com.b2international.fhir.r5.operations.ConceptMapTranslateResultParameters.Match.Product()
				.setAttribute(r6Product.getAttribute() == null ? null : r6Product.getAttribute().getValue())
				.setValue(convertType(r6Product.getValue()));
	}
	
	// ValueSet$expand input parameters
	public static com.b2international.fhir.r5.operations.ValueSetExpandParameters convert(com.b2international.fhir.r6.operations.ValueSetExpandParameters parameters) {
		return new com.b2international.fhir.r5.operations.ValueSetExpandParameters()
			.setUrl(convertType(parameters.getUrl()))
			.setValueSet(convertResource(parameters.getValueSet()))
			.setValueSetVersion(convertType(parameters.getValueSetVersion()))
			.setContext(convertType(parameters.getContext()))
			.setContextDirection(convertType(parameters.getContextDirection()))
			.setFilter(convertType(parameters.getFilter()))
			.setDate(convertType(parameters.getDate()))
			.setOffset(convertType(parameters.getOffset()))
			.setCount(convertType(parameters.getCount()))
			.setIncludeDesignations(convertType(parameters.getIncludeDesignations()))
			.setDesignation(parameters.getDesignation() == null ? null : parameters.getDesignation().stream().map(OperationConvertor_50_N::convertType).toList())
			.setIncludeDefinition(convertType(parameters.getIncludeDefinition()))
			.setActiveOnly(convertType(parameters.getActiveOnly()))
			.setExcludeNested(convertType(parameters.getExcludeNested()))
			.setExcludeNotForUI(convertType(parameters.getExcludeNotForUI()))
			.setExcludePostCoordinated(convertType(parameters.getExcludePostCoordinated()))
			.setDisplayLanguage(convertType(parameters.getDisplayLanguage()))
			.setExcludeSystem(parameters.getExcludeSystem() == null ? null : parameters.getExcludeSystem().stream().map(OperationConvertor_50_N::convertType).toList())
			.setSystemVersion(parameters.getSystemVersion() == null ? null : parameters.getSystemVersion().stream().map(OperationConvertor_50_N::convertType).toList())
			.setCheckSystemVersion(parameters.getCheckSystemVersion() == null ? null : parameters.getCheckSystemVersion().stream().map(OperationConvertor_50_N::convertType).toList())
			.setForceSystemVersion(parameters.getForceSystemVersion() == null ? null : parameters.getForceSystemVersion().stream().map(OperationConvertor_50_N::convertType).toList())
			// add custom B2i specific parameters
			.setAfter(convertType(parameters.getAfter()))
			.setWithHistorySupplements(convertType(parameters.getWithHistorySupplements()))
		;
	}
	
	// ValueSet$validate-code input parameters
	public static com.b2international.fhir.r5.operations.ValueSetValidateCodeParameters convert(com.b2international.fhir.r6.operations.ValueSetValidateCodeParameters parameters) {
		return new com.b2international.fhir.r5.operations.ValueSetValidateCodeParameters()
			.setUrl(convertType(parameters.getUrl()))
			.setContext(convertType(parameters.getContext()))
			.setValueSet(convertResource(parameters.getValueSet()))
			.setValueSetVersion(convertType(parameters.getValueSetVersion()))
			.setCode(convertType(parameters.getCode()))
			.setSystem(convertType(parameters.getSystem()))
			.setSystemVersion(convertType(parameters.getSystemVersion()))
			.setDisplay(convertType(parameters.getDisplay()))
			.setCoding(convertType(parameters.getCoding()))
			.setCodeableConcept(convertType(parameters.getCodeableConcept()))
			.setDate(convertType(parameters.getDate()))
			.setAbstract(convertType(parameters.getIsAbstract()))
			.setDisplayLanguage(convertType(parameters.getDisplayLanguage()))
		;
	}
	
	// ValueSet$validate-code output parameters
	public static com.b2international.fhir.r5.operations.ValueSetValidateCodeResultParameters convert(com.b2international.fhir.r6.operations.ValueSetValidateCodeResultParameters parameters) {
		return new com.b2international.fhir.r5.operations.ValueSetValidateCodeResultParameters()
			.setResult(convertType(parameters.getResult()))
			.setSystem(convertType(parameters.getSystem()))
			.setVersion(convertType(parameters.getVersion()))
			.setMessage(convertType(parameters.getMessage()))
			.setDisplay(convertType(parameters.getDisplay()))
		;
	}
	
	// $load-package input parameters
	public static com.b2international.fhir.r5.operations.LoadPackageParameters convert(com.b2international.fhir.r6.operations.LoadPackageParameters parameters) {
		return new com.b2international.fhir.r5.operations.LoadPackageParameters()
			.setName(convertType(parameters.getName()))
			.setVersion(convertType(parameters.getVersion()))
			.setRegistry(convertType(parameters.getRegistry()))
			.setResolveDependencies(convertType(parameters.getResolveDependencies()))
			.setResourceUrl(parameters.getResourceUrl() == null ? null : parameters.getResourceUrl().stream().map(OperationConvertor_50_N::convertType).toList())
		;
	}
	
	// $load-package output parameters
	public static com.b2international.fhir.r5.operations.LoadPackageResultParameters convert(com.b2international.fhir.r6.operations.LoadPackageResultParameters parameters) {
		return new com.b2international.fhir.r5.operations.LoadPackageResultParameters()
			.setSuccess(convertType(parameters.getSuccess()))
			.setNumberOfLoadedCodeSystems(convertType(parameters.getNumberOfLoadedCodeSystems()))
			.setNumberOfLoadedValueSets(convertType(parameters.getNumberOfLoadedValueSets()))
			.setNumberOfLoadedConceptMaps(convertType(parameters.getNumberOfLoadedConceptMaps()))
		;
	}
	
	//////////////
	// R5 to R6 //
	//////////////
	
	public static com.b2international.fhir.r6.operations.BaseParameters convert(com.b2international.fhir.r5.operations.BaseParameters parameters) {
		if (parameters instanceof com.b2international.fhir.r5.operations.CodeSystemLookupParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r5.operations.CodeSystemLookupResultParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r5.operations.CodeSystemSubsumptionParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r5.operations.CodeSystemSubsumptionResultParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r5.operations.CodeSystemValidateCodeParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r5.operations.CodeSystemValidateCodeResultParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r5.operations.ConceptMapTranslateParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r5.operations.ConceptMapTranslateResultParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r5.operations.ValueSetExpandParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r5.operations.ValueSetValidateCodeParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r5.operations.ValueSetValidateCodeResultParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r5.operations.LoadPackageParameters r5Parameters) {
			return convert(r5Parameters);
		} else if (parameters instanceof com.b2international.fhir.r5.operations.LoadPackageResultParameters r5Parameters) {
			return convert(r5Parameters);
		} else {
			throw new FHIRFormatError(String.format("Unable to convert R5 parameters '%s' to R6.", parameters.getClass().getSimpleName()));
		}
	}
	
	// CodeSystem$lookup input parameters
	public static com.b2international.fhir.r6.operations.CodeSystemLookupParameters convert(com.b2international.fhir.r5.operations.CodeSystemLookupParameters parameters) {
		return new com.b2international.fhir.r6.operations.CodeSystemLookupParameters()
			.setCode(convertType(parameters.getCode()))
			.setSystem(convertType(parameters.getSystem()))
			.setVersion(convertType(parameters.getVersion()))
			.setCoding(convertType(parameters.getCoding()))
			.setDate(convertType(parameters.getDate()))
			.setDisplayLanguage(convertType(parameters.getDisplayLanguage()))
			.setProperty(parameters.getProperty() == null ? null : parameters.getProperty().stream()
					.map(OperationConvertor_50_N::convertType)
					.toList())
		;
	}
	
	// CodeSystem$lookup result parameters
	public static com.b2international.fhir.r6.operations.CodeSystemLookupResultParameters convert(com.b2international.fhir.r5.operations.CodeSystemLookupResultParameters parameters) {
		return new com.b2international.fhir.r6.operations.CodeSystemLookupResultParameters()
			.setName(convertType(parameters.getName()))
			.setVersion(convertType(parameters.getVersion()))
			.setDisplay(convertType(parameters.getDisplay()))
			.setDesignation(parameters.getDesignation() == null ? null : parameters.getDesignation().stream()
					.map(OperationConvertor_50_N::convert)
					.toList())
			.setProperty(parameters.getProperty() == null ? null : parameters.getProperty().stream()
					.map(OperationConvertor_50_N::convert)
					.toList())
		;
	}
	
	private static com.b2international.fhir.r6.operations.CodeSystemLookupResultParameters.Designation convert(com.b2international.fhir.r5.operations.CodeSystemLookupResultParameters.Designation designation) {
		return new com.b2international.fhir.r6.operations.CodeSystemLookupResultParameters.Designation()
			.setLanguage(convertType(designation.getLanguage()))
			.setUse(convertType(designation.getUse()))
			.setValue(convertType(designation.getValue()))
		;
	}
	
	private static com.b2international.fhir.r6.operations.CodeSystemLookupResultParameters.Property convert(com.b2international.fhir.r5.operations.CodeSystemLookupResultParameters.Property property) {
		return new com.b2international.fhir.r6.operations.CodeSystemLookupResultParameters.Property()
			.setCode(convertType(property.getCode()))
			.setValue(convertType(property.getValue()))
			.setDescription(convertType(property.getDescription()))
			.setSubProperty(property.getSubProperty() == null ? null : property.getSubProperty().stream().map(OperationConvertor_50_N::convert).toList())
		;
	}
	
	// CodeSystem$subsumes input parameters
	public static com.b2international.fhir.r6.operations.CodeSystemSubsumptionParameters convert(com.b2international.fhir.r5.operations.CodeSystemSubsumptionParameters parameters) {
		var r5Parameters = (org.hl7.fhir.model.core.Parameters) VersionConvertorFactory_50_N.convertResource(parameters.getParameters());
		return new com.b2international.fhir.r6.operations.CodeSystemSubsumptionParameters(r5Parameters);
	}
	
	// CodeSystem$subsumes output parameters
	public static com.b2international.fhir.r6.operations.CodeSystemSubsumptionResultParameters convert(com.b2international.fhir.r5.operations.CodeSystemSubsumptionResultParameters parameters) {
		var r5Parameters = (org.hl7.fhir.model.core.Parameters) VersionConvertorFactory_50_N.convertResource(parameters.getParameters());
		return new com.b2international.fhir.r6.operations.CodeSystemSubsumptionResultParameters(r5Parameters);
	}
	
	// CodeSystem$validate-code input parameters
	public static com.b2international.fhir.r6.operations.CodeSystemValidateCodeParameters convert(com.b2international.fhir.r5.operations.CodeSystemValidateCodeParameters parameters) {
		var r5Parameters = (org.hl7.fhir.model.core.Parameters) VersionConvertorFactory_50_N.convertResource(parameters.getParameters());
		return new com.b2international.fhir.r6.operations.CodeSystemValidateCodeParameters(r5Parameters);
	}
	
	// CodeSystem$validate-code output parameters
	public static com.b2international.fhir.r6.operations.CodeSystemValidateCodeResultParameters convert(com.b2international.fhir.r5.operations.CodeSystemValidateCodeResultParameters parameters) {
		return new com.b2international.fhir.r6.operations.CodeSystemValidateCodeResultParameters()
			.setResult(convertType(parameters.getResult()))
			.setSystem(convertType(parameters.getSystem()))
			.setVersion(convertType(parameters.getVersion()))
			.setMessage(convertType(parameters.getMessage()))
			.setDisplay(convertType(parameters.getDisplay()))
		;
	}
	
	// ConceptMap$translate input parameters
	public static com.b2international.fhir.r6.operations.ConceptMapTranslateParameters convert(com.b2international.fhir.r5.operations.ConceptMapTranslateParameters parameters) {
		return new com.b2international.fhir.r6.operations.ConceptMapTranslateParameters()
			.setUrl(convertType(parameters.getUrl()))
			.setConceptMap(convertResource(parameters.getConceptMap()))
			.setConceptMapVersion(convertType(parameters.getConceptMapVersion()))
			.setVersion(convertType(parameters.getVersion()))
			.setSystem(convertType(parameters.getSystem()))
			.setSourceCode(convertType(parameters.getSourceCode()))
			.setSourceCodeableConcept(convertType(parameters.getSourceCodeableConcept()))
			.setSourceCoding(convertType(parameters.getSourceCoding()))
			.setSourceScope(convertType(parameters.getSourceScope()))
			.setTargetSystem(convertType(parameters.getTargetSystem()))
			.setTargetCode(convertType(parameters.getTargetCode()))
			.setTargetCodeableConcept(convertType(parameters.getTargetCodeableConcept()))
			.setTargetCoding(convertType(parameters.getTargetCoding()))
			.setTargetScope(convertType(parameters.getTargetScope()))
			.setDependency(parameters.getDependency() == null ? null : parameters.getDependency().stream().map(OperationConvertor_50_N::convert).toList())
			.setDisplayLanguage(convertType(parameters.getDisplayLanguage()))
		;
	}
	
	private static com.b2international.fhir.r6.operations.ConceptMapTranslateParameters.Dependency convert(com.b2international.fhir.r5.operations.ConceptMapTranslateParameters.Dependency r5Dependency) {
		return new com.b2international.fhir.r6.operations.ConceptMapTranslateParameters.Dependency()
			.setAttribute(convertType(r5Dependency.getAttribute()))
			.setValue(convertType(r5Dependency.getValue()))
		;
	}
	
	// ConceptMap$translate output parameters
	public static com.b2international.fhir.r6.operations.ConceptMapTranslateResultParameters convert(com.b2international.fhir.r5.operations.ConceptMapTranslateResultParameters parameters) {
		return new com.b2international.fhir.r6.operations.ConceptMapTranslateResultParameters()
			.setResult(convertType(parameters.getResult()))
			.setMessage(convertType(parameters.getMessage()))
			.setMatch(parameters.getMatch() == null ? null : parameters.getMatch().stream().map(OperationConvertor_50_N::convert).toList())
		;
	}
	
	private static com.b2international.fhir.r6.operations.ConceptMapTranslateResultParameters.Match convert(com.b2international.fhir.r5.operations.ConceptMapTranslateResultParameters.Match r5Match) {
		var r4Equivalence = org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.fromCode(r5Match.getRelationship().getCode());

		return new com.b2international.fhir.r6.operations.ConceptMapTranslateResultParameters.Match()
			.setRelationship(ConceptMapRelationshipConverter.convert_50_N(r4Equivalence))
			.setConcept(convertType(r5Match.getConcept()))
			.setProduct(r5Match.getProduct() == null ? null : r5Match.getProduct().stream().map(OperationConvertor_50_N::convert).toList())
			.setOriginMap(convertType(r5Match.getOriginMap()))
		;
	}
	
	private static com.b2international.fhir.r6.operations.ConceptMapTranslateResultParameters.Match.Product convert(com.b2international.fhir.r5.operations.ConceptMapTranslateResultParameters.Match.Product r5Product) {
		return new com.b2international.fhir.r6.operations.ConceptMapTranslateResultParameters.Match.Product()
			.setAttribute(convertType(r5Product.getAttribute()))
			.setValue(convertType(r5Product.getValue()))
		;
	}
	
	// ValueSet$expand input parameters
	public static com.b2international.fhir.r6.operations.ValueSetExpandParameters convert(com.b2international.fhir.r5.operations.ValueSetExpandParameters parameters) {
		return new com.b2international.fhir.r6.operations.ValueSetExpandParameters()
			.setUrl(convertType(parameters.getUrl()))
			.setValueSet(convertResource(parameters.getValueSet()))
			.setValueSetVersion(convertType(parameters.getValueSetVersion()))
			.setContext(convertType(parameters.getContext()))
			.setContextDirection(convertType(parameters.getContextDirection()))
			.setFilter(convertType(parameters.getFilter()))
			.setDate(convertType(parameters.getDate()))
			.setOffset(convertType(parameters.getOffset()))
			.setCount(convertType(parameters.getCount()))
			.setIncludeDesignations(convertType(parameters.getIncludeDesignations()))
			.setDesignation(parameters.getDesignation() == null ? null : parameters.getDesignation().stream().map(OperationConvertor_50_N::convertType).toList())
			.setIncludeDefinition(convertType(parameters.getIncludeDefinition()))
			.setActiveOnly(convertType(parameters.getActiveOnly()))
			.setExcludeNested(convertType(parameters.getExcludeNested()))
			.setExcludeNotForUI(convertType(parameters.getExcludeNotForUI()))
			.setExcludePostCoordinated(convertType(parameters.getExcludePostCoordinated()))
			.setDisplayLanguage(convertType(parameters.getDisplayLanguage()))
			.setExcludeSystem(parameters.getExcludeSystem() == null ? null : parameters.getExcludeSystem().stream().map(OperationConvertor_50_N::convertType).toList())
			.setSystemVersion(parameters.getSystemVersion() == null ? null : parameters.getSystemVersion().stream().map(OperationConvertor_50_N::convertType).toList())
			.setCheckSystemVersion(parameters.getCheckSystemVersion() == null ? null : parameters.getCheckSystemVersion().stream().map(OperationConvertor_50_N::convertType).toList())
			.setForceSystemVersion(parameters.getForceSystemVersion() == null ? null : parameters.getForceSystemVersion().stream().map(OperationConvertor_50_N::convertType).toList())
			// add custom B2i specific parameters
			.setAfter(convertType(parameters.getAfter()))
			.setWithHistorySupplements(convertType(parameters.getWithHistorySupplements()))
		;
	}
	
	// ValueSet$validate-code input parameters
	public static com.b2international.fhir.r6.operations.ValueSetValidateCodeParameters convert(com.b2international.fhir.r5.operations.ValueSetValidateCodeParameters parameters) {
		return new com.b2international.fhir.r6.operations.ValueSetValidateCodeParameters()
			.setUrl(convertType(parameters.getUrl()))
			.setContext(convertType(parameters.getContext()))
			.setValueSet(convertResource(parameters.getValueSet()))
			.setValueSetVersion(convertType(parameters.getValueSetVersion()))
			.setCode(convertType(parameters.getCode()))
			.setSystem(convertType(parameters.getSystem()))
			.setSystemVersion(convertType(parameters.getSystemVersion()))
			.setDisplay(convertType(parameters.getDisplay()))
			.setCoding(convertType(parameters.getCoding()))
			.setCodeableConcept(convertType(parameters.getCodeableConcept()))
			.setDate(convertType(parameters.getDate()))
			.setAbstract(convertType(parameters.getIsAbstract()))
			.setDisplayLanguage(convertType(parameters.getDisplayLanguage()))
		;
	}
	
	// ValueSet$validate-code output parameters
	public static com.b2international.fhir.r6.operations.ValueSetValidateCodeResultParameters convert(com.b2international.fhir.r5.operations.ValueSetValidateCodeResultParameters parameters) {
		return new com.b2international.fhir.r6.operations.ValueSetValidateCodeResultParameters()
			.setResult(convertType(parameters.getResult()))
			.setSystem(convertType(parameters.getSystem()))
			.setVersion(convertType(parameters.getVersion()))
			.setMessage(convertType(parameters.getMessage()))
			.setDisplay(convertType(parameters.getDisplay()))
		;
	}
	
	// $load-package input parameters
	public static com.b2international.fhir.r6.operations.LoadPackageParameters convert(com.b2international.fhir.r5.operations.LoadPackageParameters parameters) {
		return new com.b2international.fhir.r6.operations.LoadPackageParameters()
			.setName(convertType(parameters.getName()))
			.setVersion(convertType(parameters.getVersion()))
			.setRegistry(convertType(parameters.getRegistry()))
			.setResolveDependencies(convertType(parameters.getResolveDependencies()))
			.setResourceUrl(parameters.getResourceUrl() == null ? null : parameters.getResourceUrl().stream().map(OperationConvertor_50_N::convertType).toList())
		;
	}
	
	// $load-package output parameters
	public static com.b2international.fhir.r6.operations.LoadPackageResultParameters convert(com.b2international.fhir.r5.operations.LoadPackageResultParameters parameters) {
		return new com.b2international.fhir.r6.operations.LoadPackageResultParameters()
			.setSuccess(convertType(parameters.getSuccess()))
			.setNumberOfLoadedCodeSystems(convertType(parameters.getNumberOfLoadedCodeSystems()))
			.setNumberOfLoadedValueSets(convertType(parameters.getNumberOfLoadedValueSets()))
			.setNumberOfLoadedConceptMaps(convertType(parameters.getNumberOfLoadedConceptMaps()))
		;
	}
	
}
