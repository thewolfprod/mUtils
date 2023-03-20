package tw.github.mutil.time

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object mTime {
    /**
     * One minute in milliseconds
     *
     * Use it to change hours in timestamp
     */
    val ONE_MINUTE = 60000

    /**
     * Ten minutes in milliseconds
     *
     * Use it to change hours in timestamp
     */
    val TEN_MINUTE = 600000

    /**
     * One hour in milliseconds
     *
     * Use it to change hours in timestamp
     */
    val ONE_HOUR = 3600000

    /**
     * One day in milliseconds
     *
     * Use it to change hours in timestamp
     */
    val ONE_DAY = 86400000

    /**
     * @return [Long] value with current time in millis
     */
    fun currentTimeToLong(): Long {
        return System.currentTimeMillis()
    }

    /**
     * format given timestamp [Long] value into "HH:mm dd/MM/yyyy" and return as [String]
     *
     * @param timestamp [Long] value to format
     *
     */
    fun longToDate(timestamp: Long): String {
        val date = Date(timestamp)
        val format = SimpleDateFormat("HH:mm dd/MM/yyyy", Locale.getDefault())
        return format.format(date)
    }

    /**
     * format given timestamp [Long] value into format [String] value and return as [String]
     *
     * @param timestamp [Long] value to format
     * @param format [String] format scheme
     *
     * @see longToDate
     */
    fun longToDate(timestamp: Long, format: String): String {
        val date = Date(timestamp)
        val format = SimpleDateFormat(format, Locale.getDefault())
        return format.format(date)
    }

    /**
     * format given date [String] value into "HH:mm dd/MM/yyyy" and return as [Long] value (in millis)
     *
     * @param date [String] value to convert to [Long]
     *
     */
    fun dateToLong(date: String): Long {
        val df = SimpleDateFormat("HH:mm dd/MM/yyyy", Locale.getDefault())
        return df.parse(date)?.time ?: 0
    }
}