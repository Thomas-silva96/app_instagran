package co.tsdroiddeveloper.course.instagram.post.view

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import co.tsdroiddeveloper.course.instagram.R

class PictureAdapter(private val onClick: (Uri) -> Unit) : RecyclerView.Adapter<PictureAdapter.PictureViewHolder>() {

    var items: List<Uri> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder =
        PictureViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_profile_grid, parent, false)
        )

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class PictureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("NewApi")
        fun bind(image: Uri) {
            val bitmap = itemView.context.contentResolver.loadThumbnail(image, Size(200,200), null)
            itemView.findViewById<ImageView>(R.id.item_profile_img_grid).setImageBitmap(bitmap)
            itemView.setOnClickListener {
                onClick.invoke(image)
            }
        }

    }

}
