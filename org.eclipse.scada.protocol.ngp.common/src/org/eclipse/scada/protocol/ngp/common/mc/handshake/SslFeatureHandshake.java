/*******************************************************************************
 * Copyright (c) 2010, 2016 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *     IBH SYSTEMS GmbH - minor fixes, allow requiring SSL
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.common.mc.handshake;

import java.util.Map;

import org.eclipse.scada.protocol.ngp.common.ChainConfigurator;

public class SslFeatureHandshake extends AbstractHandshake
{

    @Override
    public void request ( final HandshakeContext context, final Map<String, String> helloProperties )
    {
        if ( context.getProtocolConfiguration ().getSslContextFactory () != null )
        {
            helloProperties.put ( "requestSsl", "true" );
        }
        else if ( context.getProtocolConfiguration ().isSslRequired () )
        {
            throw new IllegalStateException ( "SSL is required by the client but not configured" );
        }
    }

    @Override
    public void handshake ( final HandshakeContext context, final Map<String, String> helloProperties, final Map<String, String> acceptedProperties ) throws Exception
    {
        if ( context.getProtocolConfiguration ().getSslContextFactory () == null )
        {
            // we cannot do SSL
            if ( context.getProtocolConfiguration ().isSslRequired () )
            {
                // ... but we must
                throw new IllegalStateException ( "Server requires SSL" );
            }

            // ... client may choose to close
            return;
        }

        if ( !getBoolean ( helloProperties, "requestSsl", Boolean.FALSE ) )
        {
            // SSL was not requested
            return;
        }

        // we can do SSL and it was requested
        acceptedProperties.put ( "useSsl", "true" );
    }

    @Override
    public void apply ( final HandshakeContext context, final Map<String, String> acceptedProperties ) throws Exception
    {
        if ( !getBoolean ( acceptedProperties, "useSsl", Boolean.FALSE ) )
        {
            if ( context.getProtocolConfiguration ().isSslRequired () )
            {
                throw new IllegalStateException ( "SSL required by the client, but not supported by the server" );
            }
            return;
        }
        /*
         * If we start SSL and are in server mode the first packet (which is the handshake reply)
         * needs to be sent outside of SSL. In client mode the next (first) packet will already be SSL.
         */
        new ChainConfigurator ( context.getSession () ).startSsl ( !context.isClientMode (), context.isClientMode () );
    }

    @Override
    public void postApply ( final HandshakeContext context, final Map<String, String> acceptedProperties ) throws Exception
    {
    }

    @Override
    public void sessionStarted ( final HandshakeContext context, final Map<String, String> acceptedProperties ) throws Exception
    {
    }

}
