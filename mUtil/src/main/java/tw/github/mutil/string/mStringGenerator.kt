package tw.github.mutil.string

import java.util.Random

object mStringGenerator {
    private const val ALLOWED_CHARACTERS = "0123456789qwertyuiopasdfghjklzxcvbnm"

    /**
     * Generates random 16 chars long UID
     *
     * @return Random generated UID
     */
    fun UID(): String {
        val random = Random()
        val sb = StringBuilder(16)
        for (i in 0..15) sb.append(ALLOWED_CHARACTERS[random.nextInt(ALLOWED_CHARACTERS.length)])
        return sb.toString()
    }

    /**
     * Generates random custom length UID
     *
     * @param length Length of UID
     *
     * @return Random generated UID as [String]
     */
    fun UID(length: Int): String {
        val random = Random()
        val sb = StringBuilder(length)
        for (i in 0 until length) sb.append(ALLOWED_CHARACTERS[random.nextInt(ALLOWED_CHARACTERS.length)])
        return sb.toString()
    }

    /**
     * Generates random 16 chars long UID with custom chars
     *
     * @param allowedChars Chars that UID will be build from
     *
     * @return Random generated UID as [String]
     */
    fun UID(allowedChars: String): String {
        val random = Random()
        val sb = StringBuilder(16)
        for (i in 0..16) sb.append(allowedChars[random.nextInt(allowedChars.length)])
        return sb.toString()
    }

    /**
     * Generates UID with allowed chars and custom length
     *
     * @param allowedChars Chars that UID will be build from
     * @param length Length of UID
     *
     * @return Random generated UID as [String]
     */
    fun UID(length: Int, allowedChars: String): String {
        val random = Random()
        val sb = StringBuilder(length)
        for (i in 0 until length) sb.append(allowedChars[random.nextInt(allowedChars.length)])
        return sb.toString()
    }
}