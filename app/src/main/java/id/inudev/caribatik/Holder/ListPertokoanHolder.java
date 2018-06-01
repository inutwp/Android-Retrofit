package id.inudev.caribatik.Holder;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.Calendar;

import id.inudev.caribatik.Model.PertokoanData;
import id.inudev.caribatik.R;

public class ListPertokoanHolder extends RecyclerView.ViewHolder {

    private TextView ntoko;
    private TextView alamat;
    private TextView notif_operasional;
    private ImageView pictoko;

    public ListPertokoanHolder(View itemView) {
        super(itemView);
        ntoko = itemView.findViewById(R.id.nama_toko);
        alamat = itemView.findViewById(R.id.alamat_toko);
        pictoko = itemView.findViewById(R.id.pic_toko);
        notif_operasional = itemView.findViewById(R.id.notif_operasional);
    }

    @SuppressLint("SetTextI18n")
    public void bind(PertokoanData data){

        ntoko.setText(data.ntoko);
        alamat.setText(data.street);

        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        String jambuka = data.jambuka;
        String subJambuka = jambuka.substring(0, 2);

        String jamtutup = data.jamtutup;
        String subJamtutup = jamtutup.substring(0, 2);

        int JamBuka = Integer.parseInt(subJambuka);
        int JamTutup = Integer.parseInt(subJamtutup);

        int JamHampirBuka = JamBuka - 1;
        int JamHampirTutup = JamTutup - 1;

        if (hour == JamHampirBuka) {
            notif_operasional.setText("Hampir Buka");
            notif_operasional.setTextColor(Color.WHITE);
        } else if (hour >= JamBuka && hour < JamHampirTutup) {
            notif_operasional.setText("Buka");
            notif_operasional.setTextColor(Color.WHITE);
        } else if (hour == JamHampirTutup) {
            notif_operasional.setText("Hampir Tutup");
            notif_operasional.setTextColor(Color.WHITE);
        } else {
            notif_operasional.setText("Tutup");
            notif_operasional.setTextColor(Color.WHITE);
        }

        Glide.with(itemView.getContext())
                .load(data.pictoko)
                .apply(RequestOptions.centerCropTransform())
                .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                .into(pictoko);
    }
}
