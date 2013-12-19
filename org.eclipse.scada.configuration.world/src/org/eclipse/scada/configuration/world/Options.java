/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Options</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.Options#getMasterHandlerPriorities <em>Master Handler Priorities</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.WorldPackage#getOptions()
 * @model
 * @generated
 */
public interface Options extends EObject
{
    /**
     * Returns the value of the '<em><b>Master Handler Priorities</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Master Handler Priorities</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Master Handler Priorities</em>' reference.
     * @see #setMasterHandlerPriorities(MasterHandlerPriorities)
     * @see org.eclipse.scada.configuration.world.WorldPackage#getOptions_MasterHandlerPriorities()
     * @model
     * @generated
     */
    MasterHandlerPriorities getMasterHandlerPriorities ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.Options#getMasterHandlerPriorities <em>Master Handler Priorities</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Master Handler Priorities</em>' reference.
     * @see #getMasterHandlerPriorities()
     * @generated
     */
    void setMasterHandlerPriorities ( MasterHandlerPriorities value );

} // Options
