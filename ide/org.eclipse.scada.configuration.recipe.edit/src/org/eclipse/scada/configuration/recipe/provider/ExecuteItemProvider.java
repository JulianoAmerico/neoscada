/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.recipe.provider;

import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IItemStyledLabelProvider;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.configuration.recipe.Execute;
import org.eclipse.scada.configuration.recipe.RecipeFactory;
import org.eclipse.scada.configuration.recipe.RecipePackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.configuration.recipe.Execute} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecuteItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, IItemStyledLabelProvider
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecuteItemProvider ( AdapterFactory adapterFactory )
    {
        super ( adapterFactory );
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors ( Object object )
    {
        if ( itemPropertyDescriptors == null )
        {
            super.getPropertyDescriptors ( object );

            addNamePropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNamePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Execute_name_feature" ), //$NON-NLS-1$
        getString ( "_UI_PropertyDescriptor_description", "_UI_Execute_name_feature", "_UI_Execute_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        RecipePackage.Literals.EXECUTE__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures ( Object object )
    {
        if ( childrenFeatures == null )
        {
            super.getChildrenFeatures ( object );
            childrenFeatures.add ( RecipePackage.Literals.EXECUTE__MAP_INPUT );
            childrenFeatures.add ( RecipePackage.Literals.EXECUTE__INPUT_VALUE );
            childrenFeatures.add ( RecipePackage.Literals.EXECUTE__OUTPUT );
            childrenFeatures.add ( RecipePackage.Literals.EXECUTE__INPUT_REFERENCE );
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature ( Object object, Object child )
    {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature ( object, child );
    }

    /**
     * This returns Execute.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/Execute" ) ); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText ( Object object )
    {
        return ( (StyledString)getStyledText ( object ) ).getString ();
    }

    /**
     * This returns the label styled text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getStyledText ( Object object )
    {
        String label = ( (Execute)object ).getName ();
        StyledString styledLabel = new StyledString ();
        if ( label == null || label.length () == 0 )
        {
            styledLabel.append ( getString ( "_UI_Execute_type" ), StyledString.Style.QUALIFIER_STYLER ); //$NON-NLS-1$
        }
        else
        {
            styledLabel.append ( getString ( "_UI_Execute_type" ), StyledString.Style.QUALIFIER_STYLER ).append ( " " + label ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        return styledLabel;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void notifyChanged ( Notification notification )
    {
        updateChildren ( notification );

        switch ( notification.getFeatureID ( Execute.class ) )
        {
            case RecipePackage.EXECUTE__NAME:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case RecipePackage.EXECUTE__MAP_INPUT:
            case RecipePackage.EXECUTE__INPUT_VALUE:
            case RecipePackage.EXECUTE__OUTPUT:
            case RecipePackage.EXECUTE__INPUT_REFERENCE:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), true, false ) );
                return;
        }
        super.notifyChanged ( notification );
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors ( Collection<Object> newChildDescriptors, Object object )
    {
        super.collectNewChildDescriptors ( newChildDescriptors, object );

        newChildDescriptors.add ( createChildParameter ( RecipePackage.Literals.EXECUTE__MAP_INPUT, RecipeFactory.eINSTANCE.createMapInput () ) );

        newChildDescriptors.add ( createChildParameter ( RecipePackage.Literals.EXECUTE__INPUT_VALUE, RecipeFactory.eINSTANCE.createStringInputValue () ) );

        newChildDescriptors.add ( createChildParameter ( RecipePackage.Literals.EXECUTE__OUTPUT, RecipeFactory.eINSTANCE.createCaptureOutput () ) );

        newChildDescriptors.add ( createChildParameter ( RecipePackage.Literals.EXECUTE__INPUT_REFERENCE, RecipeFactory.eINSTANCE.createInputReference () ) );
    }

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator ()
    {
        return RecipeEditPlugin.INSTANCE;
    }

}
