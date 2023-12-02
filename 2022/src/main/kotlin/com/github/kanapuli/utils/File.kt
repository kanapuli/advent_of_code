package com.github.kanapuli.utils

import java.io.File

/**
 * readCalories reads the input problem file from the class resources
 */
fun readFile(filePath: String): File = File(ClassLoader.getSystemResource(filePath).file)