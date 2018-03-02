package com.eebbk.open.scrollphotoitem.KotlinDemo

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.eebbk.open.scrollphotoitem.R
import com.eebbk.open.scrollphotoitem.R.id.tv_kotlin
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/10/25 11:03
 * Email:  369013520@qq.com
 */
class KotlinActivity : AppCompatActivity() {

    //     var notNullArtist: Artist = null
    var artist: Artist? = null

    var fragment: Fragment? = null
    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        test1()

        test2()

        test3()

        test4()

        test5()

//        test6()

        test7()
    }

    private fun test7() {

        // 如果至少有一个元素符合给出的判断条件，则返回true。
        val list = listOf<Int>(1, 2, 3, 4, 5, 6)
        val result1: Boolean = list.any { it % 2 == 0 }
        val result2: Boolean = list.any { it > 10 }
        Log.d("test7", " fold result1 = $result1" + " result2 = $result2")

        // 如果全部的元素符合给出的判断条件，则返回true。
        val result3: Boolean = list.all { it < 10 }
        val result4: Boolean = list.all { it % 2 == 0 }
        Log.d("test7", " fold result3 = $result3" + " result4 = $result4")

        // 返回符合给出判断条件的元素总数。
        val result5: Int = list.count { it % 2 == 0 }
        Log.d("test7", " fold result5 = $result5")

        // 在一个初始值的基础上从第一项到最后一项通过一个函数累计所有的元素。
        val result6: Int = list.fold(4) { total, next -> total + next }
        Log.d("test7", " fold result6 = $result6")

        // 与 fold 一样，但是顺序是从最后一项到第一项。
        val result7: Int = list.foldRight(4) { total, next -> total + next }
        Log.d("test7", " foldRight result7 = $result7")

        // 遍历所有元素，并执行给定的操作。
        list.forEach { Log.d("test7", " foreach it = " + it) }

        // 与 forEach ，但是我们同时可以得到元素的index。
        list.forEachIndexed { index, value ->
            Log.i("test7", "forEachIndexed i" +
                    "ndex = $index " + " value = $value")
        }

        // max
        list.max()
        Log.d("test7", " max = ${list.max()}")

        // 根据给定的函数返回最大的一项，如果没有则返回null。
        list.maxBy { -it }
        Log.d("test7", " maxBy = ${list.maxBy { -it }}")

        // min
        Log.d("test7", " min = ${list.min()}")

        // 根据给定的函数返回最小的一项，如果没有则返回null。
        Log.d("test7", " maxBy = ${list.minBy { -it }}")

        // 如果没有任何元素与给定的函数匹配，则返回true。
        val result8: Boolean = list.none { it % 7 == 0 }
        Log.d("test7", " result8 = $result8")

        // 与 fold 一样，但是没有一个初始值。通过一个函数从第一项到最后一项进行累计。
        val result9: Int = list.reduce { total, next -> total + next }
        Log.d("test7", " result9 = $result9")

        // 与 reduce 一样，但是顺序是从最后一项到第一项。
        val result10: Int = list.reduceRight { total, next -> total + next }
        Log.d("test7", " reduceRight = $result10")

        // 返回所有每一项通过函数转换之后的数据的总和。
        val result11: Int = list.sumBy { it % 2 }
        Log.d("test7", " sumBy = $result11")

        // 返回包含去掉前n个元素的所有元素的列表。
        val result12: List<Int> = list.drop(4)
        result12.forEach { s -> Log.d("test7", " drop s = $s") }

        // 返回根据给定函数从第一项开始去掉指定元素的列表。
        val result13: List<Int> = list.dropWhile { it < 3 }
        result13.forEach { s -> Log.d("test7", " dropWhile s = $s") }

        // 返回根据给定函数从最后一项开始去掉指定元素的列表。
        val result14: List<Int> = list.dropLastWhile { it > 4 }
        result14.forEach { s -> Log.d("test7", " dropLastWhile s = $s") }

        // 过滤所有符合给定函数条件的元素
        val result15: List<Int> = list.filter { it % 2 == 0 }
        result15.forEach { s -> Log.d("test7", " filter s = $s") }

        // 过滤所有不符合给定函数条件的元素。
        val result16: List<Int> = list.filterNot { it % 2 == 0 }
        result16.forEach { s -> Log.d("test7", " filterNot s = $s") }

        // 过滤所有元素中不是null的元素。
        val result17: List<Int> = list.filterNotNull()
        result17.forEach { s -> Log.d("test7", " filterNotNull s = $s") }

        // 过滤一个list中指定index的元素。
        val result18: List<Int> = list.slice(listOf(1, 2, 4))
        result18.forEach { s -> Log.d("test7", " slice s = $s") }

        // 返回从第一个开始的n个元素。
        val result19: List<Int> = list.take(2)
        result19.forEach { s -> Log.d("test7", " take s = $s") }

        // 返回从最后一个开始的n个元素。
        val result20: List<Int> = list.takeLast(2)
        result20.forEach { s -> Log.d("test7", " takeLast s = $s") }

        // 返回从第一个开始符合给定函数条件的元素。
        val result21: List<Int> = list.takeWhile { it < 3 }
        result21.forEach { s -> Log.d("test7", " takeLast s = $s") }

        // 遍历所有的元素，为每一个创建一个集合，最后把所有的集合放在一个集合中。
        val result22: List<Int> = list.flatMap { listOf(it, it + 1) }
        result22.forEach { s -> Log.d("test7", " flatMap s = $s") }

        // 返回一个根据给定函数分组后的map。
        val result23: Map<String, List<Int>> = list.groupBy { if (it % 2 == 0) "even" else "odd" }
        result23.forEach { s -> Log.d("test7", " groupBy key = ${s.key}" + " value = ${s.value}") }

        // 返回一个每一个元素根据给定的函数转换所组成的List。
        val result24: List<Int> = list.map { it * 2 }
        result24.forEach { s -> Log.d("test7", " map s = $s") }

        // 返回一个每一个元素根据给定的包含元素index的函数转换所组成的List。
        val result25: List<Int> = list.mapIndexed { index, it -> index * it }
        result25.forEach { s -> Log.d("test7", " mapIndexed s = $s") }

        // 返回一个每一个非null元素根据给定的函数转换所组成的List。
        val result26: List<Int> = list.mapNotNull { it * 2 }
        result26.forEach { s -> Log.d("test7", " mapIndexed s = $s") }


        // 如果指定元素可以在集合中找到，则返回true。
        val result27: Boolean = list.contains(2)
        Log.d("test7", " result27 contains = $result27")

        // 返回给定index对应的元素，如果index数组越界则会抛出 IndexOutOfBoundsException。
        val result28: Int = list.elementAt(1)
        Log.d("test7", " result28 elementAt = $result28")

        // 返回给定index对应的元素，如果index数组越界则会根据给定函数返回默认值。
        val result29: Int = list.elementAtOrElse(10, { 2 * it })
        Log.d("test7", " result29 elementAtOrElse = $result29")

        // 返回给定index对应的元素，如果index数组越界则会返回null。
        list.elementAtOrNull(10)
        Log.d("test7", " result30 elementAtOrNull = ${list.elementAtOrNull(10)}")

        // 返回符合给定函数条件的第一个元素。
        list.first() { it % 7 == 0 }
        Log.d("test7", " result30 firstOrNull = ${list.first() { it % 7 == 0 }}")

        // 返回符合给定函数条件的第一个元素 如果没有符合则返回null。
        list.firstOrNull() { it % 7 == 0 }
        Log.d("test7", " result30 firstOrNull = ${list.firstOrNull() { it % 7 == 0 }}")

        // 返回指定元素的最后一个index，如果不存在，则返回 -1 。
        list.lastIndexOf(2)

        // 返回符合给定函数的单个元素，如果没有符合或者超过一个，则抛出异常。
        list.single { it % 2 == 0 }

        // 把两个集合合并成一个新的，相同index的元素通过给定的函数进行合并成新的元素
        // 作为新的集合的一个元素，返回这个新的集合。新的集合的大小由最小的那个集合
        // 大小决定。
        val list2 = listOf(1, 2, 3, 4, 5, 6)
        val list2Repeated = listOf(2, 3, 4, 5, 6, 7, 8)
//        list2.merge(list2Repeated) { it1, it2 -> it1 + it2 }

        // 把一个给定的集合分割成两个，第一个集合是由原集合每一项元素匹配给定函数条
        // 件返回 true 的元素组成，第二个集合是由原集合每一项元素匹配给定函数条件返
        // 回 false 的元素组成。
        list2.partition { it % 2 == 0 }

        // 返回一个包含原集合和给定集合中所有元素的集合
        list + listOf(7, 8)

        // 返回由 pair 组成的List，每个 pair 由两个集合中相同index的元素组成。这个返
        // 回的List的大小由最小的那个集合决定。
        list.zip(listOf(7, 8))  == listOf(Pair(1, 7), Pair(2, 8))

        // 从包含pair的List中生成包含List的Pair。
        listOf(Pair(5, 7), Pair(6, 8)).unzip() == Pair(listOf(5, 6), listOf(7,8))


        // 返回一个与指定list相反顺序的list。
        val unsortedList = listOf(3, 2, 7, 5)
        unsortedList.reversed()

        // 返回一个自然排序后的list。
        unsortedList.sorted()

        // 返回一个根据指定函数排序后的list。
        unsortedList.sortedBy { it % 3 }

        // 返回一个根据指定函数排序后的list。
        unsortedList.sortedDescending()

        // 返回一个根据指定函数降序排序后的list。
        unsortedList.sortedByDescending { it % 3 }



        // Ranges
        for (i in 10..0)
            println(i)

        for (i in 10 downTo 0)
            println(i)

        // step 来定义一个从1到一个值的不同的空隙
        for (i in 1..4 step 2) println(i)

        for (i in 4 downTo 1 step 2) println(i)

        for (i in 0 until 4) println(i)
    }
}

private fun test6() {
    Observable.create<ForecastList> {
        val result: ForecastList = RequestForecastCommand(url = String()).execute()
        it.onNext(result)
    }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result -> Log.d("test6", result.toString()) }
}

private fun test5() {
    val url: String = "http://www.sojson.com/open/api/weather/json.shtml?city=北京"
    Observable.create<String> {
        var data: String = Request(url).run()
        Log.d("test5", " data = " + data)
//            val forecastResult: ForecastResult = Gson().fromJson(data, ForecastResult::class.java)
//            Log.d("test5", " ForecastResult = " + forecastResult.toString())
        it.onNext(data)
    }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { s -> Log.d("test5", s as String) }

}

private fun test4() {
    val person = Person()
    val name = person.name

    val person1 = Person()
    person1.name = "YangShangZhen";
    Log.d("test4", " x 222= " + person1.name)
}

private fun test3() {
    var i: Int = 7;
    var d: Double = i.toDouble()

    var c: Char = 'c'
    var c2i: Int = c.toInt()

    val s = "Example"
    val cs = s[2]
    Log.d("test3", " cs 111 = " + cs)
    for (x in s) {
        Log.d("test3", " x 222= " + x)
    }
}

private fun test2() {
//    val forecastList = findViewById(R.id.forecast_list) as RecyclerView
//    forecastList.layoutManager = LinearLayoutManager(this)
//    forecastList.adapter = ForecastListAdapter(items)
}

private fun test1() {
    // artist 可能为null
    // artist.print()

    // artist  不为null 才打印
//    artist?.print()

//    tv_kotlin.text = "Hello Kotlin"
//    tv_kotlin.setOnClickListener({
//        toast("Hello Kotlin")
//        // toast("Hello Kotlin", Toast.LENGTH_LONG)
//        Log.d("KotlinActivity", " tv_kotlin setOnClickListener")
//    })
}

fun toast(message: String, time: Int = Toast.LENGTH_SHORT) {
//    Toast.makeText(this, "[$localClassName] $message", time).show()
}

