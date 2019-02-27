package io.github.shekibobo.mapreducehadoop

import com.nhaarman.mockitokotlin2.verify
import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.LongWritable
import org.apache.hadoop.io.Text
import org.apache.hadoop.mapreduce.Mapper
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MapTest {
    @Mock
    lateinit var context: Mapper<LongWritable, Text, Text, IntWritable>.Context

    @Test
    fun map() {
        val inputKey = LongWritable(1L)
        val inputValue = Text("1,Josh,Kovach")

        val outputKey = Text("Kovach")
        val outputValue = IntWritable(1)

        val map = Map()

        map.map(inputKey, inputValue, context)

        verify(context).write(outputKey, outputValue)
    }
}