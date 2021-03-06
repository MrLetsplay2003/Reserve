package net.tnemc.core.chat.translate;

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
public interface LanguageHandler {

  /**
   * @return The name of the language this handler is for.
   */
  String name();

  /**
   * @return The name of the plugin that owns this handler.
   */
  String plugin();

  /**
   * Attempts to translate a message from another language to this one.
   * @param message The message to translate.
   * @param language The language that the message originates.
   * @return The translated message if acquired, otherwise the original message.
   */
  String translate(String message, String language);
}