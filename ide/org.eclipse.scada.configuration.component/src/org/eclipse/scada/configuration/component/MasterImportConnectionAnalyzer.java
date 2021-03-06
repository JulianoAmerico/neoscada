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
package org.eclipse.scada.configuration.component;

import org.eclipse.scada.configuration.infrastructure.MasterImport;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Master Import Connection Analyzer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.MasterImportConnectionAnalyzer#getConnection <em>Connection</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getMasterImportConnectionAnalyzer()
 * @model
 * @generated
 */
public interface MasterImportConnectionAnalyzer extends MasterComponent
{
    /**
     * Returns the value of the '<em><b>Connection</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connection</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connection</em>' reference.
     * @see #setConnection(MasterImport)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getMasterImportConnectionAnalyzer_Connection()
     * @model required="true"
     * @generated
     */
    MasterImport getConnection ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.MasterImportConnectionAnalyzer#getConnection <em>Connection</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Connection</em>' reference.
     * @see #getConnection()
     * @generated
     */
    void setConnection ( MasterImport value );

} // MasterImportConnectionAnalyzer
