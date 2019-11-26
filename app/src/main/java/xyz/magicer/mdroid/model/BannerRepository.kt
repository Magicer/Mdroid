package xyz.magicer.mdroid.model

import xyz.magicer.mdroid.base.BaseRepository
import xyz.magicer.mdroid.base.Result
import xyz.magicer.mdroid.http.WanApi
import xyz.magicer.mdroid.model.bean.WanBanner

class BannerRepository : BaseRepository() {

    suspend fun loadBanner(): Result<WanBanner> {
        return getResult {
            WanApi.create().banner()
        }

    }
}
