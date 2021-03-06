package net.tnemc.core.chat.room;

import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.UUID;

/**
 * Created by Daniel.
 *
 * Reserve API
 *
 * Copyright (C) 2017 creatorfromhell
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU Affero General Public License as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License along with this program.
 * If not, see <http://www.gnu.org/licenses/>.
 **/
public interface ChatNetwork {

  /**
   * @return The name of this ChatNetwork
   */
  String name();

  /**
   * @return The owner of this ChatNetwork.
   */
  UUID owner();

  /**
   * @return True if this ChatNetwork isn't tied to one world.
   */
  boolean global();

  /**
   * @return A String array of the worlds that this ChatNetwork is based in.
   */
  String[] world();

  /**
   * @return A list of the {@link ChatRoom rooms} in this network.
   */
  List<ChatRoom> getRooms();

  /**
   * @return The list of members in this chat network that are currently in network chat. This means
   * that they are sending messages to all active participants in every room of the network.
   */
  List<UUID> networkChatParticipants();

  /**
   * @return The list of members in this chat network.
   */
  List<UUID> participants();

  /**
   * Used to send a message to all active participants in every chat room in this network.
   * @param sender The sender of the message.
   * @param message The message being sent.
   * @return True if the message was sent.
   */
  boolean broadcast(CommandSender sender, String message);

  /**
   * Used to send a message to all active participants in every chat room in this network.
   * @param sender The sender of the message.
   * @param message The message being sent.
   * @param node The permission node required to see this message.
   * @return True if the message was sent.
   */
  boolean broadcast(CommandSender sender, String message, String node);
}