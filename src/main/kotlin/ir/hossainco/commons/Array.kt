@file:Suppress("unused")

package ir.hossainco.commons

import ir.hossainco.commons.types.Provider
import ir.hossainco.commons.types.provide

inline fun <T> Array<out T>.firstOrDefault(default: T, predicate: (T) -> Boolean) =
	this.firstOrNull(predicate) ?: default

inline fun <T> Array<out T>.firstOrDefault(default: Provider<T>, predicate: (T) -> Boolean) =
	this.firstOrNull(predicate) ?: default.provide()
