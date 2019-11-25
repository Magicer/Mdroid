package xyz.magicer.mdroid.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import xyz.magicer.mdroid.base.BaseRepository
import xyz.magicer.mdroid.base.TodayResult
import xyz.magicer.mdroid.base.Result
import xyz.magicer.mdroid.http.GankApi

class TodayRepository : BaseRepository() {


    suspend fun loadToday(): Result<TodayResult> {
        return getResult {
            withContext(Dispatchers.IO) {
                GankApi.create().getToday()
            }
        }
    }
}