package com.wegielek.katana_flashlight

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class Prefs {
    companion object {
        private fun getPrefs(context: Context): SharedPreferences {
            return context.applicationContext.getSharedPreferences("PREFS", Context.MODE_PRIVATE)
        }

        fun setThreshold(context: Context, value: Float) {
            getPrefs(context).edit { putFloat("threshold", value) }
        }

        fun getThreshold(context: Context): Float {
            return getPrefs(context).getFloat("threshold", 10f)
        }

        fun setFlashOn(context: Context, value: Boolean) {
            getPrefs(context).edit { putBoolean("flash", value) }
        }

        fun getFlashOn(context: Context): Boolean {
            return getPrefs(context).getBoolean("flash", false)
        }

        fun setVibrationOn(context: Context, value: Boolean) {
            getPrefs(context).edit { putBoolean("vibration", value) }
        }

        fun getVibrationOn(context: Context): Boolean {
            return getPrefs(context).getBoolean("vibration", false)
        }

        fun setKatanaOn(context: Context, value: Boolean) {
            getPrefs(context).edit { putBoolean("katana", value) }
        }

        fun getKatanaOn(context: Context): Boolean {
            return getPrefs(context).getBoolean("katana", false)
        }

        fun setStrength(context: Context, value: Int) {
            if (value >= 1 && value <= getMaximumStrength(context)) {
                getPrefs(context).edit { putInt("strength", value) }
            }
        }

        fun getStrength(context: Context): Int {
            return getPrefs(context).getInt("strength", getMaximumStrength(context))
        }

        fun setMaximumStrength(context: Context, value: Int) {
            getPrefs(context).edit { putInt("max_strength", value) }
        }

        fun getMaximumStrength(context: Context): Int {
            return getPrefs(context).getInt("max_strength", 1)
        }

        fun setIntroDone(context: Context, value: Boolean) {
            getPrefs(context).edit { putBoolean("intro", value) }
        }

        fun getIntroDone(context: Context): Boolean {
            return getPrefs(context).getBoolean("intro", false)
        }
    }
}