package io.github.shekibobo.mapreducehadoop.wordfrequency

import org.apache.hadoop.conf.Configured
import org.apache.hadoop.fs.Path
import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.Text
import org.apache.hadoop.mapreduce.Job
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat
import org.apache.hadoop.util.Tool
import org.apache.hadoop.util.ToolRunner

fun main(args: Array<String>) {
    val exitCode = ToolRunner.run(WordFrequency(), args)
    System.exit(exitCode)
}

class WordFrequency : Configured(), Tool {
    override fun run(args: Array<out String>): Int {
        val job = Job.getInstance(conf).apply {
            jobName = "wordCount"
            setJarByClass(WordFrequency::class.java)

            numReduceTasks = 2
            outputKeyClass = Text::class.java
            outputValueClass = IntWritable::class.java

            mapperClass = WordCountMapper::class.java
            reducerClass = SumReducer::class.java
            combinerClass = SumReducer::class.java
        }

        val inputFilePath = Path(args[0])
        val outputFilePath = Path(args[1])
        FileInputFormat.addInputPath(job, inputFilePath)
        FileOutputFormat.setOutputPath(job, outputFilePath)

        return if (job.waitForCompletion(true)) 0 else 1
    }
}