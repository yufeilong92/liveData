package com.yfl.livedata

import com.yfl.livedata.construction.StartFactory
import com.yfl.livedata.refrect.MarkAFactory
import com.yfl.livedata.refrect.MarkBFactory
import com.yfl.livedata.refrect.MarkCompanyJava
import com.yfl.livedata.refrect.MarkFactory
import com.yfl.livedata.threadmain.CallAbleOne
import com.yfl.livedata.threadmain.RunableOne
import com.yfl.livedata.threadmain.UserThread
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.concurrent.FutureTask
import java.util.concurrent.locks.ReentrantLock

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun text() {
        val mStartFactory = StartFactory.getInstance()
        mStartFactory?.startDoIntent(StartFactory.KEY_START_A)?.startIntent()
        mStartFactory?.startDoIntent(StartFactory.KEY_START_B)?.startIntent("测绘师B")
    }

    @Test
    fun s() {
        val markCompany = MarkCompanyJava()
//        val markCompany = MarkCompany()
        val a: MarkFactory = MarkAFactory()
        markCompany.setMarkCompanyJava(a)
        val aFactory = markCompany.instance as MarkFactory
        aFactory.mark(2)

        val b: MarkFactory = MarkBFactory()
        markCompany.setMarkCompanyJava(b)
        val bfactiry = markCompany.instance as MarkFactory
        bfactiry.mark(22)
    }

    @Test
    fun thread() {
        val thread = UserThread()
        thread.start()
        val runnbale = RunableOne()
        runnbale.run()
        val thread1 = Thread(runnbale)
        thread1.name = "thread1"
        thread1.start()

        val lock = ReentrantLock()

        val callable = CallAbleOne()
        val mFutureTask = FutureTask<String>(callable)
        val thread2 = Thread(mFutureTask)
        thread2.start()
        val get = mFutureTask.get()
        println(get)

    }

    @Test
    fun syb() {
        for (index in 0..3) {
            val thread = UserThread()
            thread.name = "$index"
            thread.start()
        }

    }

    private class infom {
        var name: String? = null
        var k: Int = 0

        @Synchronized
        fun changerK(k: Int) {
            this.k = k
        }


        fun changerName(name: String) {
            this.name = name
        }
    }

    private class threadThread : Thread() {
        override fun run() {

        }
    }
}