package ermilov.qr_reader.feature.data

import com.budiyev.android.codescanner.CodeScanner
import javax.inject.Inject

class MyRepository @Inject constructor() {
    var codeScanner: CodeScanner? = null
    fun codeScanner(): CodeScanner? {
         return codeScanner
    }

}