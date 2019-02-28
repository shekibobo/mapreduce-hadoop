package io.github.shekibobo.mapreducehadoop.wordfrequency

import io.github.shekibobo.mapreducehadoop.extensions.writable
import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.Text
import org.apache.hadoop.mapreduce.Reducer

class SumReducer : Reducer<Text, IntWritable, Text, IntWritable>() {
    public override fun reduce(key: Text, values: MutableIterable<IntWritable>, context: Context) {
        context.write(key, values.sumBy { it.get() }.writable)
    }
}
