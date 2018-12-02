/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liband.utils


import android.text.TextUtils
import com.liband.App
import java.text.SimpleDateFormat
import java.util.*

class StringUtils {

    fun getFormatedHtml(htmlData: String): String {
        val dir: String
        val textColor = "#565563"
        val fontStyle: String
        if (!TextUtils.isEmpty(htmlData)) {
            dir = "ltr"
            fontStyle = "<style type=\"text/css\">\n" +
                    "@font-face {\n" +
                    "    font-family: MyFont;\n" +
                    "    src: url(\"file:///android_asset/fonts/avenir_next_regular_en.ttf\")\n" +
                    "}\n" +
                    "body {\n" +
                    "    font-family: MyFont;\n" +
                    "    font-size: 15px;\n" +
                    " color:" + textColor + ";\n" +
                    "    background-color:#ffffff;\n" +
                    "}\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "    </style>"
            return "<!DOCTYPE html>\n" +
                    "<html LANG=\"" + "en" + "\">\n" +
                    "<head>\n" + fontStyle +
                    "    \n<meta charset=\"UTF-8\">\n" +
                    "</head>\n" +
                    "<body dir=\"" + dir + "\">\n" +
                    "\n" +
                    htmlData +
                    "\n" +
                    "</body>\n" +
                    "</html>"
        } else {
            return ""
        }

    }

    companion object {
        val EMPTY = ""

        val INDEX_NOT_FOUND = -1
        private val PAD_LIMIT = 8192

        fun isEmpty(str: String?): Boolean {
            return str == null || str.length == 0
        }

        fun isNotEmpty(str: String): Boolean {
            return !StringUtils.isEmpty(str)
        }


        fun clean(str: String?): String {
            return str?.trim { it <= ' ' } ?: EMPTY
        }

        fun trim(str: String?): String? {
            return str?.trim { it <= ' ' }
        }

        fun trimToNull(str: String): String? {
            val ts = trim(str)
            return if (isEmpty(ts)) null else ts
        }

        fun trimToEmpty(str: String?): String {
            return str?.trim { it <= ' ' } ?: EMPTY
        }

        fun remove(str: String, remove: String): String? {
            return if (isEmpty(str) || isEmpty(remove)) {
                str
            } else replace(str, remove, EMPTY, -1)
        }

        fun remove(str: String, remove: Char): String? {
            if (isEmpty(str) || str.indexOf(remove) == -1) {
                return str
            }
            val chars = str.toCharArray()
            var pos = 0
            for (i in chars.indices) {
                if (chars[i] != remove) {
                    chars[pos++] = chars[i]
                }
            }
            return String(chars, 0, pos)
        }

        fun replaceOnce(text: String, searchString: String, replacement: String): String? {
            return replace(text, searchString, replacement, 1)
        }

        @JvmOverloads
        fun replace(text: String, searchString: String, replacement: String?, max: Int = -1): String? {
            var max = max
            if (isEmpty(text) || isEmpty(searchString) || replacement == null || max == 0) {
                return text
            }
            var start = 0
            var end = text.indexOf(searchString, start)
            if (end == -1) {
                return text
            }
            val replLength = searchString.length
            var increase = replacement.length - replLength
            increase = if (increase < 0) 0 else increase
            increase *= if (max < 0) 16 else if (max > 64) 64 else max
            val buf = StringBuilder(text.length + increase)
            while (end != -1) {
                buf.append(text.substring(start, end)).append(replacement)
                start = end + replLength
                if (--max == 0) {
                    break
                }
                end = text.indexOf(searchString, start)
            }
            buf.append(text.substring(start))
            return buf.toString()
        }

        fun replaceEach(text: String, searchList: Array<String>, replacementList: Array<String>): String? {
            return replaceEach(text, searchList, replacementList, false, 0)
        }

        fun replaceEachRepeatedly(text: String, searchList: Array<String>?, replacementList: Array<String>): String? {
            // timeToLive should be 0 if not used or nothing to replace, else it's
            // the length of the replace array
            val timeToLive = searchList?.size ?: 0
            return replaceEach(text, searchList, replacementList, true, timeToLive)
        }

        private fun replaceEach(text: String?, searchList: Array<String>?, replacementList: Array<String>?,
                                repeat: Boolean, timeToLive: Int): String? {

            // mchyzer Performance note: This creates very few new objects (one major goal)
            // let me know if there are performance requests, we can create a harness to measure

            if (text == null || text.length == 0 || searchList == null ||
                    searchList.size == 0 || replacementList == null || replacementList.size == 0) {
                return text
            }

            // if recursing, this shouldnt be less than 0
            if (timeToLive < 0) {
                throw IllegalStateException("TimeToLive of $timeToLive is less than 0: $text")
            }

            val searchLength = searchList.size
            val replacementLength = replacementList.size

            // make sure lengths are ok, these need to be equal
            if (searchLength != replacementLength) {
                throw IllegalArgumentException("Search and Replace array lengths don't match: "
                        + searchLength
                        + " vs "
                        + replacementLength)
            }

            // keep track of which still have matches
            val noMoreMatchesForReplIndex = BooleanArray(searchLength)

            // index on index that the match was found
            var textIndex = -1
            var replaceIndex = -1
            var tempIndex: Int

            // index of replace array that will replace the search string found
            // NOTE: logic duplicated below START
            for (i in 0 until searchLength) {
                if (noMoreMatchesForReplIndex[i] || searchList[i] == null ||
                        searchList[i].length == 0 || replacementList[i] == null) {
                    continue
                }
                tempIndex = text.indexOf(searchList[i])

                // see if we need to keep searching for this
                if (tempIndex == -1) {
                    noMoreMatchesForReplIndex[i] = true
                } else {
                    if (textIndex == -1 || tempIndex < textIndex) {
                        textIndex = tempIndex
                        replaceIndex = i
                    }
                }
            }
            // NOTE: logic mostly below END

            // no search strings found, we are done
            if (textIndex == -1) {
                return text
            }

            var start = 0

            // get a good guess on the size of the result buffer so it doesnt have to double if it goes over a bit
            var increase = 0

            // count the replacement text elements that are larger than their corresponding text being replaced
            for (i in searchList.indices) {
                val greater = replacementList[i].length - searchList[i].length
                if (greater > 0) {
                    increase += 3 * greater // assume 3 matches
                }
            }
            // have upper-bound at 20% increase, then let Java take over
            increase = Math.min(increase, text.length / 5)

            val buf = StringBuilder(text.length + increase)

            while (textIndex != -1) {

                for (i in start until textIndex) {
                    buf.append(text[i])
                }
                buf.append(replacementList[replaceIndex])

                start = textIndex + searchList[replaceIndex].length

                textIndex = -1
                replaceIndex = -1
                // find the next earliest match
                // NOTE: logic mostly duplicated above START
                for (i in 0 until searchLength) {
                    if (noMoreMatchesForReplIndex[i] || searchList[i] == null ||
                            searchList[i].length == 0 || replacementList[i] == null) {
                        continue
                    }
                    tempIndex = text.indexOf(searchList[i], start)

                    // see if we need to keep searching for this
                    if (tempIndex == -1) {
                        noMoreMatchesForReplIndex[i] = true
                    } else {
                        if (textIndex == -1 || tempIndex < textIndex) {
                            textIndex = tempIndex
                            replaceIndex = i
                        }
                    }
                }
                // NOTE: logic duplicated above END

            }
            val textLength = text.length
            for (i in start until textLength) {
                buf.append(text[i])
            }
            val result = buf.toString()
            return if (!repeat) {
                result
            } else replaceEach(result, searchList, replacementList, true, timeToLive - 1)

        }

        fun replaceChars(str: String?, searchChar: Char, replaceChar: Char): String? {
            return str?.replace(searchChar, replaceChar)
        }

        fun replaceChars(str: String, searchChars: String, replaceChars: String?): String? {
            var replaceChars = replaceChars
            if (isEmpty(str) || isEmpty(searchChars)) {
                return str
            }
            if (replaceChars == null) {
                replaceChars = EMPTY
            }
            var modified = false
            val replaceCharsLength = replaceChars.length
            val strLength = str.length
            val buf = StringBuilder(strLength)
            for (i in 0 until strLength) {
                val ch = str[i]
                val index = searchChars.indexOf(ch)
                if (index >= 0) {
                    modified = true
                    if (index < replaceCharsLength) {
                        buf.append(replaceChars[index])
                    }
                } else {
                    buf.append(ch)
                }
            }
            return if (modified) {
                buf.toString()
            } else str
        }

        fun overlayString(text: String, overlay: String, start: Int, end: Int): String {
            return text.substring(0, start) +
                    overlay +
                    text.substring(end)
        }

        fun overlay(str: String?, overlay: String?, start: Int, end: Int): String? {
            var overlay = overlay
            var start = start
            var end = end
            if (str == null) {
                return null
            }
            if (overlay == null) {
                overlay = EMPTY
            }
            val len = str.length
            if (start < 0) {
                start = 0
            }
            if (start > len) {
                start = len
            }
            if (end < 0) {
                end = 0
            }
            if (end > len) {
                end = len
            }
            if (start > end) {
                val temp = start
                start = end
                end = temp
            }
            return str.substring(0, start) +
                    overlay +
                    str.substring(end)
        }

        fun getAppString(key: Int): String {
            return App.app.getResources().getString(key)
        }


        fun isValidMobile(phone: String): Boolean {
            return android.util.Patterns.PHONE.matcher(phone).matches()
        }


        fun isValidEmail(target: CharSequence?): Boolean {
            return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }


        fun formatDateTime(oldDate: String, oldFormat: String, newFormat: String): String {
            try {
                val inputFormat = SimpleDateFormat(oldFormat, Locale.ENGLISH)
                val outputFormat = SimpleDateFormat(newFormat, Locale.ENGLISH)
                val date = inputFormat.parse(oldDate)
                return outputFormat.format(date)
            } catch (e: Exception) {
                return oldDate
            }

        }
    }

}
