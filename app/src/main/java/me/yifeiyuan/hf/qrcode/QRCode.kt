package me.yifeiyuan.hf.qrcode

import android.graphics.Bitmap
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel

/**
 * Created by 程序亦非猿 on 2021/1/6.
 */
object QRCode {

    fun genQRCode(content: String, size: Int): Bitmap? {

        val hints = HashMap<EncodeHintType, Any>().apply {
            this[EncodeHintType.CHARACTER_SET] = "utf-8"
            this[EncodeHintType.MARGIN] = 1
            this[EncodeHintType.ERROR_CORRECTION] = ErrorCorrectionLevel.H
        }

        // 生成二维矩阵，编码时指定大小，不要生成了图片以后再进行缩放，这样会模糊导致识别失败
        var matrix: BitMatrix? = null
        try {
            matrix = MultiFormatWriter().encode(
                content,
                BarcodeFormat.QR_CODE,
                size,
                size,
                hints
            )
        } catch (aE: WriterException) {
            aE.printStackTrace()
        }

        if (matrix == null) {
            return null
        }

        val width: Int = matrix.getWidth()
        val height: Int = matrix.getHeight()

        // 二维矩阵转为一维像素数组,也就是一直横着排了
        val pixels = IntArray(width * height)
        for (y in 0 until height) {
            for (x in 0 until width) {
                if (matrix.get(x, y)) {
                    pixels[y * width + x] = -0x1000000
                } else {
                    pixels[y * width + x] = -0x1
                }
            }
        }

        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        // 通过像素数组生成bitmap,具体参考api
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height)
        return bitmap
    }
}