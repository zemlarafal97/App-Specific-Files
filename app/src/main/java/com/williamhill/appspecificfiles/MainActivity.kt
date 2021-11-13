package com.williamhill.appspecificfiles

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.williamhill.appspecificfiles.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleClickEvents()
    }

    private fun handleClickEvents() {
        binding.btnInternalStorage.setOnClickListener {
            saveToInternalStorage()
        }

        binding.btnInternalCache.setOnClickListener {
            saveToInternalCache()
        }

        binding.btnExternalStorage.setOnClickListener {
            saveToExternalStorage()
        }

        binding.btnExternalCache.setOnClickListener {
            saveToExternalCache()
        }
    }

    private fun saveToInternalStorage() {
        val file = File(filesDir, "internal_file.txt")
        val fos = FileOutputStream(file)
        fos.write("Text saved to internal storage".toByteArray())
        fos.close()
    }

    private fun saveToInternalCache() {
        val file = File(cacheDir, "internal_file.txt")
        val fos = FileOutputStream(file)
        fos.write("Text saved to internal cache storage".toByteArray())
        fos.close()
    }

    private fun saveToExternalStorage() {
        val file = File(getExternalFilesDir(null), "external_file.txt")
        val fos = FileOutputStream(file)
        fos.write("Text saved to external storage".toByteArray())
        fos.close()
    }

    private fun saveToExternalCache() {
        val file = File(externalCacheDir, "external_file.txt")
        val fos = FileOutputStream(file)
        fos.write("Text saved to external cache storage".toByteArray())
        fos.close()
    }

}