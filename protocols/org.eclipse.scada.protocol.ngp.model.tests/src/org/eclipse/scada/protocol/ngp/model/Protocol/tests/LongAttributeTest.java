/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.model.Protocol.tests;

import junit.textui.TestRunner;

import org.eclipse.scada.protocol.ngp.model.Protocol.LongAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Long Attribute</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LongAttributeTest extends AttributeTest
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( LongAttributeTest.class );
    }

    /**
     * Constructs a new Long Attribute test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LongAttributeTest ( String name )
    {
        super ( name );
    }

    /**
     * Returns the fixture for this Long Attribute test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected LongAttribute getFixture ()
    {
        return (LongAttribute)fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp () throws Exception
    {
        setFixture ( ProtocolFactory.eINSTANCE.createLongAttribute () );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
    @Override
    protected void tearDown () throws Exception
    {
        setFixture ( null );
    }

} //LongAttributeTest
