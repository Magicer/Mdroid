package xyz.magicer.mdroid.model

import xyz.magicer.core.base.BaseNetRepository
import xyz.magicer.core.bean.NetResult
import xyz.magicer.mdroid.http.GankApi
import xyz.magicer.mdroid.model.bean.TodayResult

class TodayRepository : BaseNetRepository() {

    suspend fun loadToday(): NetResult<TodayResult> {
        return getResult {
            GankApi.create().getToday()
        }
    }
}