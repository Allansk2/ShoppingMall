package com.kotlin.base.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    var FORMAT_MONTH_DAY = "MM-dd"

    var FORMAT_SHORT = "yyyy-MM-dd"

    var datePattern = "yyyy-MM-dd HH:mm:ss"

    var FORMAT_LONG_NEW = "yyyy-MM-dd HH:mm"

    var FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S"

    var FORMAT_SHORT_CN_MINI = "MM月dd日 HH:mm"

    var FORMAT_SHORT_CN = "yyyy年MM月dd日"

    var FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒"

    var FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒"

    var FORMAT_SPEFULL_CN = "yyyy年MM月dd日  HH:mm"

    var FORMAT_SHORT_SPE = "yyyyMMdd"
    var FORMAT_SHORT_SPE_ = "HH:mm"

    var TIMEZONE = "Asia/Shanghai"

    val now: String
        get() = format(Date())


    fun getNow(format: String): String {
        return format(Date(), format)
    }


    val defTimeZone: TimeZone
        get() = TimeZone.getTimeZone(TIMEZONE)

    @JvmOverloads
    fun format(date: Date?, pattern: String = datePattern): String {
        var returnValue = ""
        if (date != null) {
            val df = SimpleDateFormat(pattern)
            df.timeZone = defTimeZone
            returnValue = df.format(date)
        }
        return returnValue
    }


    @JvmOverloads
    fun parse(strDate: String, pattern: String = datePattern): Date? {
        val df = SimpleDateFormat(pattern)
        df.timeZone = defTimeZone
        try {
            return df.parse(strDate)
        } catch (e: ParseException) {
            e.printStackTrace()
            return null
        }

    }

    fun convertTimeToString(time: Long, format: String): String {
        val sdf = SimpleDateFormat(format)
        sdf.timeZone = defTimeZone
        return sdf.format(time)
    }

    fun getBeforeDay(cl: Calendar): Calendar {
        val day = cl.get(Calendar.DATE)
        cl.set(Calendar.DATE, day - 1)
        return cl
    }

    fun getAfterDay(cl: Calendar): Calendar {
        val day = cl.get(Calendar.DATE)
        cl.set(Calendar.DATE, day + 1)
        return cl
    }

    fun getWeek(c: Calendar): String {
        var Week = ""

        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            Week += "周天"
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            Week += "周一"
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
            Week += "周二"
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
            Week += "周三"
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
            Week += "周四"
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            Week += "周五"
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            Week += "周六"
        }
        return Week
    }

    fun dateToString(date: Date, formatType: String): String {
        val sdf = SimpleDateFormat(formatType)
        sdf.timeZone = defTimeZone
        return sdf.format(date)
    }

    @Throws(ParseException::class)
    fun longToString(currentTime: Long, formatType: String): String {
        val date = longToDate(currentTime, formatType)
        val strTime = dateToString(date, formatType)
        return strTime
    }

    @Throws(ParseException::class)
    fun stringToDate(strTime: String, formatType: String): Date {
        val formatter = SimpleDateFormat(formatType)
        formatter.timeZone = defTimeZone
        var date: Date? = null
        date = formatter.parse(strTime)
        return date
    }

    @Throws(ParseException::class)
    fun longToDate(currentTime: Long, formatType: String): Date {
        val dateOld = Date(currentTime)
        val sDateTime = dateToString(dateOld, formatType)
        val date = stringToDate(sDateTime, formatType)
        return date
    }

    fun stringToLong(strTime: String, formatType: String): Long {
        var date: Date? = null
        try {
            date = stringToDate(strTime, formatType)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return if (date == null) {
            0
        } else {
            dateToLong(date)
        }
    }

    fun dateToLong(date: Date): Long {
        return date.time
    }

    val curTime: Long
        get() {
            val c = Calendar.getInstance(defTimeZone)
            return c.timeInMillis
        }
}
