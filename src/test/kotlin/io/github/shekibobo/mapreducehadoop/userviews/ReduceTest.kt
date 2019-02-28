package io.github.shekibobo.mapreducehadoop.userviews

import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import io.github.shekibobo.mapreducehadoop.extensions.writable
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
        val inputKey = "kovach".writable
        val inputValues = listOf(1, 1, 1, 1, 1, 1, 1, 1).map(Int::writable).toMutableList()
        reducer.reduce(inputKey, inputValues, context)

        verify(context).write(inputKey, IntWritable(inputValues.size))
        verifyNoMoreInteractions(context)
    }
}