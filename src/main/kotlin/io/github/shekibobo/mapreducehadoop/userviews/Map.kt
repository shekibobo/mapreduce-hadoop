package io.github.shekibobo.mapreducehadoop.userviews

import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.LongWritable
import org.apache.hadoop.io.Text
import org.apache.hadoop.mapreduce.Mapper

class Map : Mapper<LongWritable, Text, Text, IntWritable>() {
    public override fun map(key: LongWritable, value: Text, context: Context) {
        val row = value.toString().split(",")
        context.write(Text(row[2]), IntWritable(1))
    }
}