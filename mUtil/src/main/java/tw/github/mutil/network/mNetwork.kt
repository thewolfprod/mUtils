package tw.github.mutil.network

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresPermission

object mNetwork {

    /**
     * Checks if mobile data or Wi-Fi is enabled
     *
     * This function doesn't check if phone is connected to internet!
     *
     * @return [Boolean] if true, mobile data or Wi-Fi is enabled on device
     *
     * @see isInternetAvailable
     */
    @RequiresPermission(value = "android.permission.ACCESS_NETWORK_STATE")
    fun isNetworkEnabled(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }

    /**
     * Checks if device is connected to internet
     *
     * @return [Boolean] if true, internet is available on device
     */
    @RequiresPermission(value = "android.permission.ACCESS_NETWORK_STATE")
    fun isInternetAvailable(context: Context): Boolean {
        val connManager = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { // if android >= Marshmallow
            val networkCapabilities = connManager.getNetworkCapabilities(connManager.activeNetwork)
            networkCapabilities != null
        } else {
            val activeNetwork = connManager.activeNetworkInfo
            activeNetwork?.isConnectedOrConnecting == true && activeNetwork.isAvailable
        }
    }
}