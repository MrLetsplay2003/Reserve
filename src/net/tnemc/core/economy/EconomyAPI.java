package net.tnemc.core.economy;

import net.tnemc.core.economy.currency.Currency;

import org.bukkit.OfflinePlayer;
import org.bukkit.World;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by creatorfromhell on 2/26/2018.
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
public interface EconomyAPI {

  /**
   * @return The name of the Economy implementation.
   */
  String name();

  /**
   * @return The version of Reserve the Economy implementation supports.
   */
  String version();

  /**
   * @return Whether or not this implementation is enabled.
   */
  boolean enabled();

  /**
   * @return Whether or not this implementation should have a default Vault implementation.
   */
  default boolean vault() {
    return true;
  }

  /**
   * Used to get the plural name of the default currency.
   * @return The plural name of the default currency.
   */
  String currencyDefaultPlural();

  /**
   * Used to get the singular name of the default currency.
   * @return The plural name of the default currency.
   */
  String currencyDefaultSingular();

  /**
   * Used to get the plural name of the default currency for a world.
   * @param world The world to be used in this check.
   * @return The plural name of the default currency.
   */
  String currencyDefaultPlural(String world);

  /**
   * Used to get the singular name of the default currency for a world.
   * @param world The world to be used in this check.
   * @return The plural name of the default currency.
   */
  String currencyDefaultSingular(String world);

  /**
   * Checks to see if a {@link Currency} exists with this name.
   * @param name The name of the {@link Currency} to search for.
   * @return True if the currency exists, else false.
   */
  boolean hasCurrency(String name);

  /**
   * Checks to see if a {@link Currency} exists with this name.
   * @param name The name of the {@link Currency} to search for.
   * @param world The name of the {@link World} to check for this {@link Currency} in.
   * @return True if the currency exists, else false.
   */
  boolean hasCurrency(String name, String world);

  /**
   * Checks to see if an account exists for this identifier. This method should be used for non-player accounts.
   * @param identifier The identifier of the account.
   * @return True if an account exists for this player, else false.
   */
  boolean hasAccount(String identifier);

  /**
   * Checks to see if an account exists for this identifier. This method should be used for player accounts.
   * @param identifier The {@link UUID} of the account.
   * @return True if an account exists for this player, else false.
   */
  boolean hasAccount(UUID identifier);

  /**
   * Checks to see if an account exists for this identifier.
   * @param player The {@link OfflinePlayer} owner of the account.
   * @return True if an account exists for this player, else false.
   */
  default boolean hasAccount(OfflinePlayer player) {
	  return hasAccount(player.getUniqueId());
  }

  /**
   * Attempts to create an account for this identifier. This method should be used for non-player accounts.
   * @param identifier The identifier of the account.
   * @return True if an account was created, else false.
   */
  boolean createAccount(String identifier);

  /**
   * Attempts to create an account for this identifier. This method should be used for player accounts.
   * @param identifier The {@link UUID} of the account.
   * @return True if an account was created, else false.
   */
  boolean createAccount(UUID identifier);

  /**
   * Attempts to create an account for this identifier.
   * @param player The {@link OfflinePlayer} owner of the account.
   * @return True if an account was created, else false.
   */
  default boolean createAccount(OfflinePlayer player) {
	  return createAccount(player.getUniqueId());
  }

  /**
   * Attempts to delete an account for this identifier. This method should be used for non-player accounts.
   * @param identifier The identifier of the account.
   * @return True if an account was deleted, else false.
   */
  boolean deleteAccount(String identifier);

  /**
   * Attempts to delete an account for this identifier. This method should be used for player accounts.
   * @param identifier The {@link UUID} of the account.
   * @return True if an account was deleted, else false.
   */
  boolean deleteAccount(UUID identifier);

  /**
   * Attempts to delete an account for this identifier.
   * @param identifier The {@link OfflinePlayer} owner of the account.
   * @return True if an account was deleted, else false.
   */
  default boolean deleteAccount(OfflinePlayer player) {
	  return deleteAccount(player.getUniqueId());
  }

  /**
   * Determines whether or not a player is able to access this account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param accessor The identifier of the user attempting to access this account.
   * @return Whether or not the player is able to access this account.
   */
  boolean isAccessor(String identifier, String accessor);

  /**
   * Determines whether or not a player is able to access this account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param accessor The identifier of the user attempting to access this account.
   * @return Whether or not the player is able to access this account.
   */
  boolean isAccessor(String identifier, UUID accessor);
  
  /**
   * Determines whether or not a player is able to access this account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param accessor The user attempting to access this account.
   * @return Whether or not the player is able to access this account.
   */
  default boolean isAccessor(String identifier, OfflinePlayer accessor) {
	  return isAccessor(identifier, accessor.getUniqueId());
  }

  /**
   * Determines whether or not a player is able to access this account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param accessor The identifier of the user attempting to access this account.
   * @return Whether or not the player is able to access this account.
   */
  boolean isAccessor(UUID identifier, String accessor);

  /**
   * Determines whether or not a player is able to access this account.
   * @param identifier The owner of the account that is associated with this call.
   * @param accessor The identifier of the user attempting to access this account.
   * @return Whether or not the player is able to access this account.
   */
  default boolean isAccessor(OfflinePlayer identifier, String accessor) {
	  return isAccessor(identifier.getUniqueId(), accessor);
  }

  /**
   * Determines whether or not a player is able to access this account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param accessor The identifier of the user attempting to access this account.
   * @return Whether or not the player is able to access this account.
   */
  boolean isAccessor(UUID identifier, UUID accessor);

  /**
   * Determines whether or not a player is able to access this account.
   * @param identifier The owner of the account that is associated with this call.
   * @param accessor The user attempting to access this account.
   * @return Whether or not the player is able to access this account.
   */
  default boolean isAccessor(OfflinePlayer identifier, OfflinePlayer accessor) {
	  return isAccessor(identifier.getUniqueId(), identifier.getUniqueId());
  }

  /**
   * Determines whether or not a player is able to withdraw holdings from this account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param accessor The identifier of the user attempting to access this account.
   * @return Whether or not the player is able to withdraw holdings from this account.
   */
  boolean canWithdraw(String identifier, String accessor);

  /**
   * Determines whether or not a player is able to withdraw holdings from this account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param accessor The identifier of the user attempting to access this account.
   * @return Whether or not the player is able to withdraw holdings from this account.
   */
  boolean canWithdraw(String identifier, UUID accessor);

  /**
   * Determines whether or not a player is able to withdraw holdings from this account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param accessor The user attempting to access this account.
   * @return Whether or not the player is able to withdraw holdings from this account.
   */
  default boolean canWithdraw(String identifier, OfflinePlayer accessor) {
	  return canWithdraw(identifier, accessor.getUniqueId());
  }

  /**
   * Determines whether or not a player is able to withdraw holdings from this account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param accessor The identifier of the user attempting to access this account.
   * @return Whether or not the player is able to withdraw holdings from this account.
   */
  boolean canWithdraw(UUID identifier, String accessor);

  /**
   * Determines whether or not a player is able to withdraw holdings from this account.
   * @param identifier The owner of the account that is associated with this call.
   * @param accessor The identifier of the user attempting to access this account.
   * @return Whether or not the player is able to withdraw holdings from this account.
   */
  default boolean canWithdraw(OfflinePlayer identifier, String accessor) {
	  return canWithdraw(identifier.getUniqueId(), accessor);
  }

  /**
   * Determines whether or not a player is able to withdraw holdings from this account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param accessor The identifier of the user attempting to access this account.
   * @return Whether or not the player is able to withdraw holdings from this account.
   */
  boolean canWithdraw(UUID identifier, UUID accessor);

  /**
   * Determines whether or not a player is able to withdraw holdings from this account.
   * @param identifier The owner of the account that is associated with this call.
   * @param accessor The user attempting to access this account.
   * @return Whether or not the player is able to withdraw holdings from this account.
   */
  default boolean canWithdraw(OfflinePlayer identifier, OfflinePlayer accessor) {
	  return canWithdraw(identifier.getUniqueId(), accessor.getUniqueId());
  }

  /**
   * Determines whether or not a player is able to deposit holdings into this account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param accessor The identifier of the user attempting to access this account.
   * @return Whether or not the player is able to deposit holdings into this account.
   */
  boolean canDeposit(String identifier, String accessor);

  /**
   * Determines whether or not a player is able to deposit holdings into this account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param accessor The identifier of the user attempting to access this account.
   * @return Whether or not the player is able to deposit holdings into this account.
   */
  boolean canDeposit(String identifier, UUID accessor);

  /**
   * Determines whether or not a player is able to deposit holdings into this account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param accessor The user attempting to access this account.
   * @return Whether or not the player is able to deposit holdings into this account.
   */
  default boolean canDeposit(String identifier, OfflinePlayer accessor) {
	  return canDeposit(identifier, accessor.getUniqueId());
  }

  /**
   * Determines whether or not a player is able to deposit holdings into this account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param accessor The identifier of the user attempting to access this account.
   * @return Whether or not the player is able to deposit holdings into this account.
   */
  boolean canDeposit(UUID identifier, String accessor);

  /**
   * Determines whether or not a player is able to deposit holdings into this account.
   * @param identifier The owner of the account that is associated with this call.
   * @param accessor The identifier of the user attempting to access this account.
   * @return Whether or not the player is able to deposit holdings into this account.
   */
  default boolean canDeposit(OfflinePlayer identifier, String accessor) {
	  return canDeposit(identifier.getUniqueId(), accessor);
  }

  /**
   * Determines whether or not a player is able to deposit holdings into this account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param accessor The identifier of the user attempting to access this account.
   * @return Whether or not the player is able to deposit holdings into this account.
   */
  boolean canDeposit(UUID identifier, UUID accessor);

  /**
   * Determines whether or not a player is able to deposit holdings into this account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param accessor The identifier of the user attempting to access this account.
   * @return Whether or not the player is able to deposit holdings into this account.
   */
  default boolean canDeposit(OfflinePlayer identifier, OfflinePlayer accessor) {
	  return canDeposit(identifier.getUniqueId(), accessor.getUniqueId());
  }

  /**
   * Used to get the balance of an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @return The balance of the account.
   */
  BigDecimal getHoldings(String identifier);

  /**
   * Used to get the balance of an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @return The balance of the account.
   */
  BigDecimal getHoldings(UUID identifier);

  /**
   * Used to get the balance of an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @return The balance of the account.
   */
  default BigDecimal getHoldings(OfflinePlayer identifier) {
	  return getHoldings(identifier.getUniqueId());
  }

  /**
   * Used to get the balance of an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param world The name of the {@link World} associated with the balance.
   * @return The balance of the account.
   */
  BigDecimal getHoldings(String identifier, String world);

  /**
   * Used to get the balance of an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param world The name of the {@link World} associated with the balance.
   * @return The balance of the account.
   */
  BigDecimal getHoldings(UUID identifier, String world);

  /**
   * Used to get the balance of an account.
   * @param identifier The owner of the account that is associated with this call.
   * @param world The name of the {@link World} associated with the balance.
   * @return The balance of the account.
   */
  default BigDecimal getHoldings(OfflinePlayer identifier, String world) {
	  return getHoldings(identifier.getUniqueId());
  }

  /**
   * Used to get the balance of an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param world The name of the {@link World} associated with the balance.
   * @param currency The {@link Currency} associated with the balance.
   * @return The balance of the account.
   */
  BigDecimal getHoldings(String identifier, String world, String currency);

  /**
   * Used to get the balance of an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param world The name of the {@link World} associated with the balance.
   * @param currency The {@link Currency} associated with the balance.
   * @return The balance of the account.
   */
  BigDecimal getHoldings(UUID identifier, String world, String currency);

  /**
   * Used to get the balance of an account.
   * @param identifier The owner of the account that is associated with this call.
   * @param world The name of the {@link World} associated with the balance.
   * @param currency The {@link Currency} associated with the balance.
   * @return The balance of the account.
   */
  default BigDecimal getHoldings(OfflinePlayer identifier, String world, String currency) {
	  return getHoldings(identifier.getUniqueId(), world, currency);
  }

  /**
   * Used to determine if an account has at least an amount of funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to use for this check.
   * @return True if the account has at least the specified amount of funds, otherwise false.
   */
  boolean hasHoldings(String identifier, BigDecimal amount);

  /**
   * Used to determine if an account has at least an amount of funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to use for this check.
   * @return True if the account has at least the specified amount of funds, otherwise false.
   */
  boolean hasHoldings(UUID identifier, BigDecimal amount);

  /**
   * Used to determine if an account has at least an amount of funds.
   * @param identifier The owner of the account that is associated with this call.
   * @param amount The amount you wish to use for this check.
   * @return True if the account has at least the specified amount of funds, otherwise false.
   */
  default boolean hasHoldings(OfflinePlayer identifier, BigDecimal amount) {
	  return hasHoldings(identifier.getUniqueId(), amount);
  }

  /**
   * Used to determine if an account has at least an amount of funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to use for this check.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if the account has at least the specified amount of funds, otherwise false.
   */
  boolean hasHoldings(String identifier, BigDecimal amount, String world);

  /**
   * Used to determine if an account has at least an amount of funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to use for this check.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if the account has at least the specified amount of funds, otherwise false.
   */
  boolean hasHoldings(UUID identifier, BigDecimal amount, String world);

  /**
   * Used to determine if an account has at least an amount of funds.
   * @param identifier The owner of the account that is associated with this call.
   * @param amount The amount you wish to use for this check.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if the account has at least the specified amount of funds, otherwise false.
   */
  default boolean hasHoldings(OfflinePlayer identifier, BigDecimal amount, String world) {
	  return hasHoldings(identifier.getUniqueId(), amount, world);
  }

  /**
   * Used to determine if an account has at least an amount of funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to use for this check.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if the account has at least the specified amount of funds, otherwise false.
   */
  boolean hasHoldings(String identifier, BigDecimal amount, String world, String currency);

  /**
   * Used to determine if an account has at least an amount of funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to use for this check.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if the account has at least the specified amount of funds, otherwise false.
   */
  boolean hasHoldings(UUID identifier, BigDecimal amount, String world, String currency);

  /**
   * Used to determine if an account has at least an amount of funds.
   * @param identifier The owner of the account that is associated with this call.
   * @param amount The amount you wish to use for this check.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if the account has at least the specified amount of funds, otherwise false.
   */
  default boolean hasHoldings(OfflinePlayer identifier, BigDecimal amount, String world, String currency) {
	  return hasHoldings(identifier.getUniqueId(), amount, world, currency);
  }

  /**
   * Used to set the funds to an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to set this accounts's funds to.
   * @return True if the funds were set for the account, otherwise false.
   */
  boolean setHoldings(String identifier, BigDecimal amount);

  /**
   * Used to set the funds to an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to set this accounts's funds to.
   * @return True if the funds were set for the account, otherwise false.
   */
  boolean setHoldings(UUID identifier, BigDecimal amount);

  /**
   * Used to set the funds to an account.
   * @param identifier The owner of the account that is associated with this call.
   * @param amount The amount you wish to set this accounts's funds to.
   * @return True if the funds were set for the account, otherwise false.
   */
  default boolean setHoldings(OfflinePlayer identifier, BigDecimal amount) {
	  return setHoldings(identifier.getUniqueId(), amount);
  }

  /**
   * Used to set the funds to an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to set this accounts's funds to.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if the funds were set for the account, otherwise false.
   */
  boolean setHoldings(String identifier, BigDecimal amount, String world);

  /**
   * Used to set the funds to an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to set this accounts's funds to.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if the funds were set for the account, otherwise false.
   */
  boolean setHoldings(UUID identifier, BigDecimal amount, String world);

  /**
   * Used to set the funds to an account.
   * @param identifier The owner of the account that is associated with this call.
   * @param amount The amount you wish to set this accounts's funds to.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if the funds were set for the account, otherwise false.
   */
  default boolean setHoldings(OfflinePlayer identifier, BigDecimal amount, String world) {
	  return setHoldings(identifier.getUniqueId(), amount, world);
  }

  /**
   * Used to set the funds to an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to set this accounts's funds to.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if the funds were set for the account, otherwise false.
   */
  boolean setHoldings(String identifier, BigDecimal amount, String world, String currency);

  /**
   * Used to set the funds to an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to set this accounts's funds to.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if the funds were set for the account, otherwise false.
   */
  boolean setHoldings(UUID identifier, BigDecimal amount, String world, String currency);

  /**
   * Used to set the funds to an account.
   * @param identifier The owner of the account that is associated with this call.
   * @param amount The amount you wish to set this accounts's funds to.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if the funds were set for the account, otherwise false.
   */
  default boolean setHoldings(OfflinePlayer identifier, BigDecimal amount, String world, String currency) {
	  return setHoldings(identifier.getUniqueId(), amount, world, currency);
  }

  /**
   * Used to add funds to an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to add to this account.
   * @return True if the funds were added to the account, otherwise false.
   */
  boolean addHoldings(String identifier, BigDecimal amount);

  /**
   * Used to add funds to an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to add to this account.
   * @return True if the funds were added to the account, otherwise false.
   */
  boolean addHoldings(UUID identifier, BigDecimal amount);

  /**
   * Used to add funds to an account.
   * @param identifier The owner of the account that is associated with this call.
   * @param amount The amount you wish to add to this account.
   * @return True if the funds were added to the account, otherwise false.
   */
  default boolean addHoldings(OfflinePlayer identifier, BigDecimal amount) {
	  return addHoldings(identifier.getUniqueId(), amount);
  }

  /**
   * Used to add funds to an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to add to this account.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if the funds were added to the account, otherwise false.
   */
  boolean addHoldings(String identifier, BigDecimal amount, String world);

  /**
   * Used to add funds to an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to add to this account.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if the funds were added to the account, otherwise false.
   */
  boolean addHoldings(UUID identifier, BigDecimal amount, String world);

  /**
   * Used to add funds to an account.
   * @param identifier The owner of the account that is associated with this call.
   * @param amount The amount you wish to add to this account.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if the funds were added to the account, otherwise false.
   */
  default boolean addHoldings(OfflinePlayer identifier, BigDecimal amount, String world) {
	  return addHoldings(identifier.getUniqueId(), amount, world);
  }

  /**
   * Used to add funds to an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to add to this account.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if the funds were added to the account, otherwise false.
   */
  boolean addHoldings(String identifier, BigDecimal amount, String world, String currency);

  /**
   * Used to add funds to an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to add to this account.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if the funds were added to the account, otherwise false.
   */
  boolean addHoldings(UUID identifier, BigDecimal amount, String world, String currency);

  /**
   * Used to add funds to an account.
   * @param identifier The owner of the account that is associated with this call.
   * @param amount The amount you wish to add to this account.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if the funds were added to the account, otherwise false.
   */
  default boolean addHoldings(OfflinePlayer identifier, BigDecimal amount, String world, String currency) {
	  return addHoldings(identifier.getUniqueId(), amount, world, currency);
  }

  /**
   * Used to determine if a call to the corresponding addHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to add to this account.
   * @return True if a call to the corresponding addHoldings method would return true, otherwise false.
   */
  boolean canAddHoldings(String identifier, BigDecimal amount);

  /**
   * Used to determine if a call to the corresponding addHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to add to this account.
   * @return True if a call to the corresponding addHoldings method would return true, otherwise false.
   */
  boolean canAddHoldings(UUID identifier, BigDecimal amount);

  /**
   * Used to determine if a call to the corresponding addHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param identifier The owner of the account that is associated with this call.
   * @param amount The amount you wish to add to this account.
   * @return True if a call to the corresponding addHoldings method would return true, otherwise false.
   */
  default boolean canAddHoldings(OfflinePlayer identifier, BigDecimal amount) {
	  return canAddHoldings(identifier.getUniqueId(), amount);
  }

  /**
   * Used to determine if a call to the corresponding addHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to add to this account.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if a call to the corresponding addHoldings method would return true, otherwise false.
   */
  boolean canAddHoldings(String identifier, BigDecimal amount, String world);

  /**
   * Used to determine if a call to the corresponding addHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to add to this account.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if a call to the corresponding addHoldings method would return true, otherwise false.
   */
  boolean canAddHoldings(UUID identifier, BigDecimal amount, String world);

  /**
   * Used to determine if a call to the corresponding addHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param identifier The owner of the account that is associated with this call.
   * @param amount The amount you wish to add to this account.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if a call to the corresponding addHoldings method would return true, otherwise false.
   */
  default boolean canAddHoldings(OfflinePlayer identifier, BigDecimal amount, String world) {
	  return canAddHoldings(identifier.getUniqueId(), amount, world);
  }

  /**
   * Used to determine if a call to the corresponding addHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to add to this account.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if a call to the corresponding addHoldings method would return true, otherwise false.
   */
  boolean canAddHoldings(String identifier, BigDecimal amount, String world, String currency);

  /**
   * Used to determine if a call to the corresponding addHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to add to this account.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if a call to the corresponding addHoldings method would return true, otherwise false.
   */
  boolean canAddHoldings(UUID identifier, BigDecimal amount, String world, String currency);

  /**
   * Used to remove funds from an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to remove from this account.
   * @return True if the funds were removed from the account, otherwise false.
   */
  boolean removeHoldings(String identifier, BigDecimal amount);

  /**
   * Used to remove funds from an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to remove from this account.
   * @return True if the funds were removed from the account, otherwise false.
   */
  boolean removeHoldings(UUID identifier, BigDecimal amount);

  /**
   * Used to remove funds from an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to remove from this account.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if the funds were removed from the account, otherwise false.
   */
  boolean removeHoldings(String identifier, BigDecimal amount, String world);

  /**
   * Used to remove funds from an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to remove from this account.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if the funds were removed from the account, otherwise false.
   */
  boolean removeHoldings(UUID identifier, BigDecimal amount, String world);

  /**
   * Used to remove funds from an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to remove from this account.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if the funds were removed from the account, otherwise false.
   */
  boolean removeHoldings(String identifier, BigDecimal amount, String world, String currency);

  /**
   * Used to remove funds from an account.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to remove from this account.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if the funds were removed from the account, otherwise false.
   */
  boolean removeHoldings(UUID identifier, BigDecimal amount, String world, String currency);

  /**
   * Used to determine if a call to the corresponding removeHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to remove from this account.
   * @return True if a call to the corresponding removeHoldings method would return true, otherwise false.
   */
  boolean canRemoveHoldings(String identifier, BigDecimal amount);

  /**
   * Used to determine if a call to the corresponding removeHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to remove from this account.
   * @return True if a call to the corresponding removeHoldings method would return true, otherwise false.
   */
  boolean canRemoveHoldings(UUID identifier, BigDecimal amount);

  /**
   * Used to determine if a call to the corresponding removeHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to remove from this account.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if a call to the corresponding removeHoldings method would return true, otherwise false.
   */
  boolean canRemoveHoldings(String identifier, BigDecimal amount, String world);

  /**
   * Used to determine if a call to the corresponding removeHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to remove from this account.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if a call to the corresponding removeHoldings method would return true, otherwise false.
   */
  boolean canRemoveHoldings(UUID identifier, BigDecimal amount, String world);

  /**
   * Used to determine if a call to the corresponding removeHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to remove from this account.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if a call to the corresponding removeHoldings method would return true, otherwise false.
   */
  boolean canRemoveHoldings(String identifier, BigDecimal amount, String world, String currency);

  /**
   * Used to determine if a call to the corresponding removeHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param identifier The identifier of the account that is associated with this call.
   * @param amount The amount you wish to remove from this account.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if a call to the corresponding removeHoldings method would return true, otherwise false.
   */
  boolean canRemoveHoldings(UUID identifier, BigDecimal amount, String world, String currency);

  /**
   * Used to transfer funds from one account to another.
   *
   * @param fromIdentifier The identifier of the account that the holdings will be coming from.
   * @param toIdentifier The identifier of the account that the holdings will be going to.
   * @param amount The amount you wish to remove from this account.
   *
   * @return True if the funds were transferred.
   */
  default boolean transferHoldings(String fromIdentifier, String toIdentifier, BigDecimal amount) {
    return removeHoldings(fromIdentifier, amount) && addHoldings(toIdentifier, amount);
  }

  /**
   * Used to transfer funds from one account to another.
   * @param fromIdentifier The identifier of the account that the holdings will be coming from.
   * @param toIdentifier The identifier of the account that the holdings will be going to.
   * @param amount The amount you wish to remove from this account.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if the funds were transferred.
   */
  default boolean transferHoldings(String fromIdentifier, String toIdentifier, BigDecimal amount, String world) {
    return removeHoldings(fromIdentifier, amount, world) && addHoldings(toIdentifier, amount, world);
  }

  /**
   * Used to transfer funds from one account to another.
   * @param fromIdentifier The identifier of the account that the holdings will be coming from.
   * @param toIdentifier The identifier of the account that the holdings will be going to.
   * @param amount The amount you wish to remove from this account.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if the funds were transferred.
   */
  default boolean transferHoldings(String fromIdentifier, String toIdentifier, BigDecimal amount, String world, String currency) {
    return removeHoldings(fromIdentifier, amount, world, currency) && addHoldings(toIdentifier, amount, world, currency);
  }

  /**
   * Used to transfer funds from one account to another.
   * @param fromIdentifier The identifier of the account that the holdings will be coming from.
   * @param toIdentifier The identifier of the account that the holdings will be going to.
   * @param amount The amount you wish to remove from this account.
   * @return True if the funds were transferred.
   */
  default boolean transferHoldings(UUID fromIdentifier, UUID toIdentifier, BigDecimal amount) {
    return removeHoldings(fromIdentifier, amount) && addHoldings(toIdentifier, amount);
  }

  /**
   * Used to transfer funds from one account to another.
   * @param fromIdentifier The identifier of the account that the holdings will be coming from.
   * @param toIdentifier The identifier of the account that the holdings will be going to.
   * @param amount The amount you wish to remove from this account.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if the funds were transferred.
   */
  default boolean transferHoldings(UUID fromIdentifier, UUID toIdentifier, BigDecimal amount, String world) {
    return removeHoldings(fromIdentifier, amount, world) && addHoldings(toIdentifier, amount, world);
  }

  /**
   * Used to transfer funds from one account to another.
   * @param fromIdentifier The identifier of the account that the holdings will be coming from.
   * @param toIdentifier The identifier of the account that the holdings will be going to.
   * @param amount The amount you wish to remove from this account.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if the funds were transferred.
   */
  default boolean transferHoldings(UUID fromIdentifier, UUID toIdentifier, BigDecimal amount, String world, String currency) {
    return removeHoldings(fromIdentifier, amount, world, currency) && addHoldings(toIdentifier, amount, world, currency);
  }

  /**
   * Used to determine if a call to the corresponding transferHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param fromIdentifier The identifier of the account that the holdings will be coming from.
   * @param toIdentifier The identifier of the account that the holdings will be going to.
   * @param amount The amount you wish to remove from this account.
   * @return True if a call to the corresponding transferHoldings method would return true, otherwise false.
   */
  default boolean canTransferHoldings(String fromIdentifier, String toIdentifier, BigDecimal amount) {
    return canRemoveHoldings(fromIdentifier, amount) && canAddHoldings(toIdentifier, amount);
  }

  /**
   * Used to determine if a call to the corresponding transferHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param fromIdentifier The identifier of the account that the holdings will be coming from.
   * @param toIdentifier The identifier of the account that the holdings will be going to.
   * @param amount The amount you wish to remove from this account.
   * @param world The name of the {@link World} associated with the amount.
   * @return True if a call to the corresponding transferHoldings method would return true, otherwise false.
   */
  default boolean canTransferHoldings(String fromIdentifier, String toIdentifier, BigDecimal amount, String world) {
    return canRemoveHoldings(fromIdentifier, amount, world) && canAddHoldings(toIdentifier, amount, world);
  }

  /**
   * Used to determine if a call to the corresponding transferHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param fromIdentifier The identifier of the account that the holdings will be coming from.
   * @param toIdentifier The identifier of the account that the holdings will be going to.
   * @param amount The amount you wish to remove from this account.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   * @return True if a call to the corresponding transferHoldings method would return true, otherwise false.
   */
  default boolean canTransferHoldings(String fromIdentifier, String toIdentifier, BigDecimal amount, String world, String currency) {
    return canRemoveHoldings(fromIdentifier, amount, world, currency) && canAddHoldings(toIdentifier, amount, world, currency);
  }

  /**
   * Used to determine if a call to the corresponding transferHoldings method would be successful. This method does not
   * affect an account's funds.
   * @param fromIdentifier The identifier of the account that the holdings will be coming from.
   * @param toIdentifier The identifier of the account that the holdings will be going to.
   * @param amount The amount you wish to remove from this account.
   * @return True if a call to the corresponding transferHoldings method would return true, otherwise false.
   */
  default boolean canTransferHoldings(UUID fromIdentifier, UUID toIdentifier, BigDecimal amount) {
    return canRemoveHoldings(fromIdentifier, amount) && canAddHoldings(toIdentifier, amount);
  }

  /**
   * Used to determine if a call to the corresponding transferHoldings method would be successful.
   * This method does not affect an account's funds.
   *
   * @param fromIdentifier The identifier of the account that the holdings will be coming from.
   * @param toIdentifier The identifier of the account that the holdings will be going to.
   * @param amount The amount you wish to remove from this account.
   * @param world The name of the {@link World} associated with the amount.
   *
   * @return True if a call to the corresponding transferHoldings method would return true,
   * otherwise false.
   */
  default boolean canTransferHoldings(UUID fromIdentifier, UUID toIdentifier, BigDecimal amount, String world) {
    return canRemoveHoldings(fromIdentifier, amount, world) && canAddHoldings(toIdentifier, amount, world);
  }

  /**
   * Used to determine if a call to the corresponding transferHoldings method would be successful.
   * This method does not affect an account's funds.
   *
   * @param fromIdentifier The identifier of the account that the holdings will be coming from.
   * @param toIdentifier The identifier of the account that the holdings will be going to.
   * @param amount The amount you wish to remove from this account.
   * @param world The name of the {@link World} associated with the amount.
   * @param currency The {@link Currency} associated with the balance.
   *
   * @return True if a call to the corresponding transferHoldings method would return true,
   * otherwise false.
   */
  default boolean canTransferHoldings(UUID fromIdentifier, UUID toIdentifier, BigDecimal amount, String world, String currency) {
    return canRemoveHoldings(fromIdentifier, amount, world, currency) && canAddHoldings(toIdentifier, amount, world, currency);
  }

  /**
   * Formats a monetary amount into a more text-friendly version.
   * @param amount The amount of currency to format.
   * @return The formatted amount.
   */
  String format(BigDecimal amount);

  /**
   * Formats a monetary amount into a more text-friendly version.
   * @param amount The amount of currency to format.
   * @param world The {@link World} in which this format operation is occurring.
   * @return The formatted amount.
   */
  String format(BigDecimal amount, String world);

  /**
   * Formats a monetary amount into a more text-friendly version.
   * @param amount The amount of currency to format.
   * @param world The {@link World} in which this format operation is occurring.
   * @param currency The {@link Currency} associated with the balance.
   * @return The formatted amount.
   */
  String format(BigDecimal amount, String world, String currency);

  /**
   * Purges the database of accounts with the default balance.
   * @return True if the purge was completed successfully.
   */
  boolean purgeAccounts();

  /**
   * Purges the database of accounts with a balance under the specified one.
   * @param amount The amount that an account's balance has to be under in order to be removed.
   * @return True if the purge was completed successfully.
   */
  boolean purgeAccountsUnder(BigDecimal amount);

  /**
   * Whether or not this API Implementation supports the Transaction System.
   */
  default boolean supportTransactions() {
    return false;
  }
}
