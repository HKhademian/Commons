@file:Suppress("unused")

package ir.hossainco.commons

import java.security.SecureRandom
import java.util.Random

object Random {
	private val random by lazy(::Random)
	private val secureRandom by lazy(::SecureRandom)


	fun randomInt()
		= random.nextInt()

	fun randomInt(bound: Int)
		= random.nextInt(bound)


	fun randomBoolean()
		= random.nextBoolean()


	fun randomLong()
		= random.nextLong()


	fun randomBytes(length: Int = 16)
		= ByteArray(length).apply(random::nextBytes)

	fun randomSecureBytes(length: Int = 16)
		= ByteArray(length).apply(secureRandom::nextBytes)
}

