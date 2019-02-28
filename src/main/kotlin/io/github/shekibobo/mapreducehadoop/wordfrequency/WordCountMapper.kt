package io.github.shekibobo.mapreducehadoop.wordfrequency

import io.github.shekibobo.mapreducehadoop.extensions.writable
import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.LongWritable
import org.apache.hadoop.io.Text
import org.apache.hadoop.mapreduce.Mapper

private val DELIMITER = Regex("\\s+")

class WordCountMapper : Mapper<LongWritable, Text, Text, IntWritable>() {
    public override fun map(inputKey: LongWritable, inputValue: Text, context: Context) {
        inputValue.toString().split(DELIMITER)
            .forEach { context.write(it.toLowerCase().writable, 1.writable) }
    }
}
