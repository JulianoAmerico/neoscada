/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.asdu;

import org.eclipse.neoscada.protocol.iec60870.ProtocolOptions;

import io.netty.buffer.ByteBuf;

public interface MessageCodec
{
    public Object parse ( ProtocolOptions options, byte length, ASDUHeader header, ByteBuf data );

    public void encode ( ProtocolOptions options, Object msg, ByteBuf out );
}
