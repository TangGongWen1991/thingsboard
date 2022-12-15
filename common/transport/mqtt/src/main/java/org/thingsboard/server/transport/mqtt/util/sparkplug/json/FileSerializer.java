/**
 * Copyright © 2016-2022 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.transport.mqtt.util.sparkplug.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.eclipse.californium.elements.util.Base64;
import org.thingsboard.server.transport.mqtt.util.sparkplug.message.File;

import java.io.IOException;

/**
 * Serializes a {@link File} instance.
 */
public class FileSerializer extends StdSerializer<File> {

	/**
	 * Constructor.
	 */
	protected FileSerializer() {
		super(File.class);
	}
	
	/**
	 * Constructor.
	 * 
	 * @param clazz class.
	 */
	protected FileSerializer(Class<File> clazz) {
		super(clazz);
	}

	@Override
	public void serialize(File value, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeString(Base64.encodeBytes(value.getBytes()));
	}

}
