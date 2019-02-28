package io.github.shekibobo.mapreducehadoop.extensions

import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.LongWritable
import org.apache.hadoop.io.Text

val String.writable get() = Text(this)
val Int.writable get() = IntWritable(this)
val Long.writable get() = LongWritable(this)
