/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.lib;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.Node;
import org.eclipse.scada.configuration.world.WorldFactory;

public final class Endpoints
{
    private Endpoints ()
    {
    }

    /**
     * Register a new endpoint <br/>
     * The endpoint must not exists if the binding service is set, but will
     * exists after the call returns
     *
     * @return the newly created endpoint
     */
    public static Endpoint registerEndpoint ( final Application app, final int port, final EObject bindingService, final String name )
    {
        return registerEndpoint ( Nodes.fromApp ( app ), port, bindingService, name );
    }

    /**
     * Register a new endpoint <br/>
     * The endpoint must not exists if the binding service is set, but will
     * exists after the call returns
     *
     * @param node
     *            the node to which this endpoint belongs
     * @param port
     *            the port number
     * @param bind
     *            whether the service wants to bind to this endpoint
     * @param name
     *            an informative name
     */
    public static Endpoint registerEndpoint ( final Node node, final int port, final EObject bindingService, final String name )
    {
        Endpoint ep = Endpoints.findEndpoint ( node, port );
        if ( ep != null && ep.getBoundService () != null && bindingService != null )
        {
            throw new IllegalStateException ( String.format ( "Endpoint %s already exists on node %s and is bound by %s (re-binding service: %s)", port, Nodes.makeName ( node ), ep.getBoundService (), bindingService ) );
        }

        if ( ep == null )
        {
            ep = Endpoints.createEndpoint ( port, name );
            node.getEndpoints ().add ( ep );
        }

        Endpoints.bind ( ep, bindingService );
        if ( bindingService != null )
        {
            ep.setName ( name ); // overwrite the name with the binding service endpoint name
        }

        return ep;
    }

    public static Endpoint createEndpoint ( final int port, final String name )
    {
        final Endpoint ep = WorldFactory.eINSTANCE.createEndpoint ();
        ep.setPortNumber ( (short)port );
        ep.setName ( name );
        return ep;
    }

    public static Node findNode ( final Endpoint ep )
    {
        if ( ep.eContainer () instanceof Node )
        {
            return (Node)ep.eContainer ();
        }
        return null;
    }

    /**
     * Find the containing node which must be of the provided type
     *
     * @param ep
     *            the endpoint
     * @param clazz
     *            the node clazz
     * @return the node
     * @throws IllegalStateException
     *             if the endpoint is not contained by the correct node type
     */
    public static <N extends Node> N findNode ( final Endpoint ep, final Class<N> clazz )
    {
        final Node node = findNode ( ep );
        if ( node != null && clazz.isAssignableFrom ( node.getClass () ) )
        {
            return clazz.cast ( node );
        }
        throw new IllegalStateException ( String.format ( "Endpoint %s is not contained by node of type %s", ep, clazz.getName () ) );
    }

    public static Endpoint findEndpoint ( final org.eclipse.scada.configuration.world.Node node, final int port )
    {
        for ( final Endpoint ep : node.getEndpoints () )
        {
            if ( ep.getPortNumber () == port )
            {
                return ep;
            }
        }
        return null;
    }

    public static void bind ( final Endpoint ep, final EObject bindingService )
    {
        if ( bindingService != null )
        {
            ep.setBoundService ( bindingService );
        }
    }
}
