package xyz.magicer.mdroid.model

import xyz.magicer.core.BaseNetRepository
import xyz.magicer.core.NetResult
import xyz.magicer.mdroid.http.GankApi
import xyz.magicer.mdroid.model.bean.TodayResult

class TodayRepository : BaseNetRepository() {

    suspend fun loadToday(): NetResult<TodayResult> {
        return getResult {
            GankApi.create().getToday()
        }
    }
}