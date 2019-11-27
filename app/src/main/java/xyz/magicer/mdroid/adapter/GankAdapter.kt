package xyz.magicer.mdroid.adapter

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import xyz.magicer.mdroid.databinding.ItemGankDefaultBinding
import xyz.magicer.mdroid.model.bean.ResultInfo

class GankAdapter :ListAdapter<ResultInfo,GankAdapter.ViewHolder>(ResultInfoDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemGankDefaultBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info = getItem(position)
        holder.bind(info)
    }

    class ViewHolder(
        private val binding: ItemGankDefaultBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bind(info: ResultInfo) {
            binding.apply {
                item = info
                executePendingBindings()
            }
        }

    }
}

private class ResultInfoDiffCallback:DiffUtil.ItemCallback<ResultInfo>(){
    override fun areItemsTheSame(oldItem: ResultInfo, newItem: ResultInfo): Boolean {
        return  TextUtils.equals(oldItem.id,newItem.id)
    }

    override fun areContentsTheSame(oldItem: ResultInfo, newItem: ResultInfo): Boolean {
      return  oldItem == newItem
    }

}