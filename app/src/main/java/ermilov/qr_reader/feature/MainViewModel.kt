package ermilov.qr_reader.feature

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.budiyev.android.codescanner.*
import dagger.hilt.android.lifecycle.HiltViewModel
import ermilov.qr_reader.feature.data.MyRepository
import javax.inject.Inject


@HiltViewModel
 class MainViewModel @Inject constructor(
    private val myRepository: MyRepository
) : ViewModel() {
    fun callRepo(activity: Activity, codeScannerView: CodeScannerView) {
        var codeScanner = myRepository.codeScanner
        codeScanner = CodeScanner(activity, codeScannerView)
        codeScanner.camera = CodeScanner.CAMERA_BACK
        codeScanner.formats = CodeScanner.ALL_FORMATS
        codeScanner.autoFocusMode = AutoFocusMode.SAFE
        codeScanner.scanMode = ScanMode.SINGLE
        codeScanner.isAutoFocusEnabled = true
        codeScanner.isFlashEnabled = false
        codeScannerView.setOnClickListener {
            codeScanner.startPreview()
        }
        codeScanner.decodeCallback = DecodeCallback {
            activity.runOnUiThread {
                Log.i("url", it.text)
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(it.text))
                activity.startActivity(browserIntent)
            }
        }

    }
}