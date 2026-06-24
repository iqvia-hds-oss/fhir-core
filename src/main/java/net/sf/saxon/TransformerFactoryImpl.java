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
package net.sf.saxon;

import javax.xml.transform.*;

/**
 * Compatibility shim to avoid a NoClassDefFoundError when Saxon can not be found 
 * on the classpath. FQDN of this class must match the original but its contents
 * are not related to the upstream Saxon implementation in any way.
 * 
 * @since 0.7
 */
public final class TransformerFactoryImpl extends TransformerFactory {

	static {
		System.err.println("WARNING: Saxon is not available on the classpath. XSLT transformations will not work.");
	}
	
	@Override
	public Transformer newTransformer(final Source source) throws TransformerConfigurationException {
		throw new UnsupportedOperationException("Saxon is not available on the classpath");
	}

	@Override
	public Transformer newTransformer() throws TransformerConfigurationException {
		throw new UnsupportedOperationException("Saxon is not available on the classpath");
	}

	@Override
	public Templates newTemplates(final Source source) throws TransformerConfigurationException {
		throw new UnsupportedOperationException("Saxon is not available on the classpath");
	}

	@Override
	public Source getAssociatedStylesheet(final Source source, final String media, final String title, final String charset) throws TransformerConfigurationException {
		throw new UnsupportedOperationException("Saxon is not available on the classpath");
	}

	@Override
	public void setURIResolver(final URIResolver resolver) {
		throw new UnsupportedOperationException("Saxon is not available on the classpath");
	}

	@Override
	public URIResolver getURIResolver() {
		throw new UnsupportedOperationException("Saxon is not available on the classpath");
	}

	@Override
	public void setFeature(final String name, final boolean value) throws TransformerConfigurationException {
		throw new UnsupportedOperationException("Saxon is not available on the classpath");
	}

	@Override
	public boolean getFeature(final String name) {
		throw new UnsupportedOperationException("Saxon is not available on the classpath");
	}

	@Override
	public void setAttribute(final String name, final Object value) {
		throw new UnsupportedOperationException("Saxon is not available on the classpath");
	}

	@Override
	public Object getAttribute(final String name) {
		throw new UnsupportedOperationException("Saxon is not available on the classpath");
	}

	@Override
	public void setErrorListener(final ErrorListener listener) {
		throw new UnsupportedOperationException("Saxon is not available on the classpath");
	}

	@Override
	public ErrorListener getErrorListener() {
		throw new UnsupportedOperationException("Saxon is not available on the classpath");
	}

}
