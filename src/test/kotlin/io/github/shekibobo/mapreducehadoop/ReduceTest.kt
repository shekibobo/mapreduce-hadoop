package io.github.shekibobo.mapreducehadoop

import com.nhaarman.mockitokotlin2.verify
import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.Text
import org.apache.hadoop.mapreduce.Reducer
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ReduceTest {
    @Mock
    lateinit var context: Reducer<Text, IntWritable, Text, IntWritable>.Context

    @Test
    fun reduce() {
        val reducer = Reduce()
        val inputKey = Text("Kovach")
        val inputValues = listOf(1, 1, 1, 1, 1, 1, 1, 1).map(::IntWritable).toMutableList()
        reducer.reduce(inputKey, inputValues, context)

        verify(context).write(inputKey, IntWritable(inputValues.size))
    }
}