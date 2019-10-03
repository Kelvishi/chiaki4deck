/*
 * This file is part of Chiaki.
 *
 * Chiaki is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Chiaki is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Chiaki.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.metallic.chiaki.common

import com.metallic.chiaki.lib.DiscoveryHost

sealed class DisplayHost
{
	abstract val registeredHost: RegisteredHost?
	abstract val host: String
}

class DiscoveredDisplayHost(
	override val registeredHost: RegisteredHost?,
	val discoveredHost: DiscoveryHost
): DisplayHost()
{
	override val host get() = discoveredHost.hostAddr ?: ""
}

class ManualDisplayHost(
	override val registeredHost: RegisteredHost?,
	val manualHost: ManualHost
): DisplayHost()
{
	override val host get() = manualHost.host
}