/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - observe text label
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer.profile;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.Profile;
import org.eclipse.scada.ui.chart.viewer.ChartContext;
import org.eclipse.scada.ui.chart.viewer.controller.ControllerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfileEntry
{

    private final static Logger logger = LoggerFactory.getLogger ( ProfileEntry.class );

    private final ProfileManager manager;

    private final Profile profile;

    private boolean active;

    private final DataBindingContext ctx;

    private ControllerManager controllerManager;

    private final ChartContext chartContext;

    private final Set<Binding> bindings = new HashSet<> ();

    private Binding controllerBinding;

    public ProfileEntry ( final DataBindingContext ctx, final ProfileManager manager, final Profile profile, final ChartContext chartContext )
    {
        this.ctx = ctx;
        this.chartContext = chartContext;
        this.manager = manager;
        this.profile = profile;
    }

    public void activate ()
    {
        if ( this.active )
        {
            return;
        }

        this.active = true;

        logger.info ( "Activate profile: {}", this.profile.getId () ); //$NON-NLS-1$

        this.controllerManager = new ControllerManager ( this.ctx, this.ctx.getValidationRealm (), this.chartContext );
        this.controllerBinding = this.ctx.bindList ( this.controllerManager.getList (), EMFObservables.observeList ( this.profile, ChartPackage.Literals.PROFILE__CONTROLLERS ) );
    }

    protected void addBinding ( final Binding binding )
    {
        this.bindings.add ( binding );
    }

    public void deactivate ()
    {
        if ( !this.active )
        {
            return;
        }

        this.active = false;

        logger.info ( "Deactivate profile: {}", this.profile.getId () ); //$NON-NLS-1$

        if ( this.controllerBinding != null )
        {
            this.controllerBinding.dispose ();
            this.controllerBinding = null;
        }

        if ( this.controllerManager != null )
        {
            this.controllerManager.dispose ();
            this.controllerManager = null;
        }
    }

    protected void fireSelection ( final boolean selection )
    {
        if ( selection )
        {
            this.manager.setActiveProfile ( this.profile );
        }
        else
        {
            this.manager.setActiveProfile ( null );
        }
    }

    public void dispose ()
    {
        deactivate ();

        for ( final Binding b : this.bindings )
        {
            b.dispose ();
        }
        this.bindings.clear ();
    }

}
