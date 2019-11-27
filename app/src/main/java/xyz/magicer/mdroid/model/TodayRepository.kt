package xyz.magicer.mdroid.model

import xyz.magicer.mdroid.base.BaseNetRepository
import xyz.magicer.mdroid.base.BaseRepository
import xyz.magicer.mdroid.base.NetResult
import xyz.magicer.mdroid.base.Result
import xyz.magicer.mdroid.http.GankApi
import xyz.magicer.mdroid.model.bean.TodayResult
import xyz.magicer.mdroid.utils.logI

class TodayRepository : BaseNetRepository() {

    suspend fun loadToday(): NetResult<TodayResult> {
        return getResult {
            logI(Thread.currentThread().name)
            GankApi.create().getToday()
        }
    }
}