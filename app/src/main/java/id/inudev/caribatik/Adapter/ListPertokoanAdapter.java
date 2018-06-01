package id.inudev.caribatik.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import java.util.List;

import id.inudev.caribatik.Holder.ListPertokoanHolder;
import id.inudev.caribatik.Model.PertokoanData;
import id.inudev.caribatik.R;

public abstract class ListPertokoanAdapter extends RecyclerView.Adapter<ListPertokoanHolder> {
    private List<PertokoanData> mData;

    public ListPertokoanAdapter(List<PertokoanData> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public ListPertokoanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview, parent, false);
        return new ListPertokoanHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListPertokoanHolder holder, int position) {
        setScaleAnimation(holder.itemView);
        try {
            bindHolder(holder, mData.get(position));
        } catch (Exception e) {
            bindHolder(holder, null);
        }
    }

    protected abstract void bindHolder(ListPertokoanHolder holder, PertokoanData mData);

    private void setScaleAnimation(View view) {
        ScaleAnimation animation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(350);
        view.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
