/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec;

import org.eclipse.scada.sec.authz.AuthorizationContext;
import org.eclipse.scada.utils.concurrent.NotifyFuture;

public interface AuthorizationImplementation
{
    public NotifyFuture<AuthorizationReply> authorize ( AuthorizationContext context, AuthorizationResult defaultResult );
}
