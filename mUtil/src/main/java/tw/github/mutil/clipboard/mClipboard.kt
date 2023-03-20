package tw.github.mutil.clipboard

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.annotation.RequiresPermission
import tw.github.mutil.vibrator.mVibrator

object mClipboard {
    fun Copy(context: Context, textToCopy: String) {
        var clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        var clipData = ClipData.newPlainText("mUtil", textToCopy)
        clipboardManager.setPrimaryClip(clipData)
    }

    fun Copy(context: Context, textToCopy: String, toastMessage: String) {
        var clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        var clipData = ClipData.newPlainText("mUtil", textToCopy)
        clipboardManager.setPrimaryClip(clipData)

        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
    }

    @RequiresPermission(value = "android.permission.VIBRATE")
    fun Copy(context: Context, textToCopy: String, toastMessage: String, vibrate: Boolean) {
        var clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        var clipData = ClipData.newPlainText("mUtil", textToCopy)
        clipboardManager.setPrimaryClip(clipData)

        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()

        if (vibrate)
            mVibrator.Vibrate(context)
    }
}