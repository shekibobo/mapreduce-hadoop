package io.github.shekibobo.mapreducehadoop.wordfrequency

import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import io.github.shekibobo.mapreducehadoop.extensions.writable
import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.LongWritable
import org.apache.hadoop.io.Text
import org.apache.hadoop.mapreduce.Mapper
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class WordCountMapperTest {
    @Mock
    lateinit var context: Mapper<LongWritable, Text, Text, IntWritable>.Context

    @Test
    fun map() {
        val inputKey = LongWritable(1L)
        val inputValue = Text("Twinkle twinkle little star")

        WordCountMapper().map(inputKey, inputValue, context)

        verify(context, times(2)).write("twinkle".writable, 1.writable)
        verify(context, times(1)).write("little".writable, 1.writable)
        verify(context, times(1)).write("star".writable, 1.writable)
        verifyNoMoreInteractions(context)
    }
}