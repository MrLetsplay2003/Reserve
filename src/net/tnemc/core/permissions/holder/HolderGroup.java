package net.tnemc.core.permissions.holder;

import net.tnemc.core.permissions.node.Node;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

/**
 * Created by creatorfromhell on 12/20/2017.
 * <p>
 * Reserve API
 * <p>
 * Copyright (C) 2018 creatorfromhell
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **/
public interface HolderGroup {

  /**
   * @return The identifier for this {@link HolderGroup}.
   */
  String identifier();

  /**
   * @return A {@link Collection} with the {@link NodeHolder holders} that this holder contains.
   */
  CompletableFuture<Collection<NodeHolder>> getHolders();

  /**
   * @return A {@link Collection} with the {@link NodeHolder holders} that this holder contains, which are currently
   * loaded.
   */
  CompletableFuture<Collection<NodeHolder>> getLoadedHolders();

  /**
   * @param permission The identifier of the {@link Node} used in this check.
   * @return A {@link Collection} with every {@link NodeHolder} that would return TRUE in a hasPermission call with the
   * specified permission.
   */
  CompletableFuture<Collection<NodeHolder>> getByPermission(String permission);

  /**
   * @param identifier The identifier of the {@link NodeHolder} used in this check.
   * @return True if this {@link HolderGroup} contains the {@link NodeHolder} with the specified identifier.
   */
  CompletableFuture<Boolean> hasHolder(String identifier);
}