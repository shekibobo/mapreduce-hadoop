package io.github.shekibobo.mapreducehadoop

import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.Text
import org.apache.hadoop.mapreduce.Reducer

class Reduce: Reducer<Text, IntWritable, Text, IntWritable>() {
    public override fun reduce(key: Text, values: MutableIterable<IntWritable>, context: Context) {
        val count = values.sumBy { it.get() }
        context.write(key, IntWritable(count))
    }
}